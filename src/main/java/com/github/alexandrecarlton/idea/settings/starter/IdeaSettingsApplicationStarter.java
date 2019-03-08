package com.github.alexandrecarlton.idea.settings.starter;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings;
import com.intellij.openapi.application.ApplicationStarter;
import com.intellij.openapi.application.WriteAction;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class IdeaSettingsApplicationStarter implements ApplicationStarter {

  private static final String IDEA_SETTINGS_FILENAME = ".IDEA-settings.yml";

  private static final ObjectReader READER = new YAMLMapper()
      .registerModule(new Jdk8Module())
      .registerModule(new GuavaModule())
      .readerFor(IdeaSettings.class);

  @Override
  public String getCommandName() {
    return "idea-settings";
  }

  @Override
  public void premain(String... args) {
    if (args.length < 1) {
      throw new IllegalArgumentException("Please supply the path to the project.");
    }
    Path path = Paths.get(args[0]);
    if (!Files.exists(path)) {
      throw new IllegalArgumentException("Please supply a valid path to the project.");
    }
  }

  @Override
  public void main(String... args) {
    Path path = Paths.get(args[0]);
    IdeaSettingsComponent component = DaggerIdeaSettingsComponent
        .builder()
        .project(path.toString())
        .build();
    Optional<IdeaSettings> settings = loadSettings(path);
    component.applicationEx().setSaveAllowed(true);
    WriteAction.runAndWait(() -> {
      settings.ifPresent(component.applier()::apply);
      component.project().save();
    });
  }

  private Optional<IdeaSettings> loadSettings(Path project) {
    Path configFile = project.resolve(IDEA_SETTINGS_FILENAME);
    if (!Files.exists(configFile)) {
      return Optional.empty();
    }
    try (InputStream inputStream = Files.newInputStream(configFile)) {
      return Optional.of(READER.readValue(inputStream));
    } catch (IOException e) {
      System.out.println(e.getMessage());
      return Optional.empty();
    }
  }
}
