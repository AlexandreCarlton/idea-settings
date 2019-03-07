package com.github.alexandrecarlton.idea.settings.starter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings;
import com.intellij.openapi.application.WriteAction;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

// TODO: Inline into ImlGgenerationStarter
public class ImlGenerator {

  private static final String IDEA_SETTINGS_FILENAME = ".IDEA-settings.yml";

  private final ObjectMapper mapper = new YAMLMapper()
      // Snake case didn't work for some reason.
//      .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
      .registerModule(new Jdk8Module())
      .registerModule(new GuavaModule());

  /**
   * Generates *.iml files for the given path.
   * @param path the location of the project.
   */
  public void generate(Path path) {
    IdeaSettingsComponent component = DaggerIdeaSettingsComponent
        .builder()
        .project(path.toString())
        .build();
    Optional<IdeaSettings> settings = loadSettings(path);
    try {
      WriteAction.runAndWait(() -> {
        settings.ifPresent(component.applier()::apply);
        component.project().save();
      });
    } catch (Throwable t) {
      System.out.println(t.getMessage());
    } finally {
      component.applicationEx().exit(false, true);
    }
  }

  private Optional<IdeaSettings> loadSettings(Path project) {
    Path configFile = project.resolve(IDEA_SETTINGS_FILENAME);
    if (!Files.exists(configFile)) {
      return Optional.empty();
    }
    try (InputStream inputStream = Files.newInputStream(configFile)) {
      return Optional.of(mapper.readValue(inputStream, IdeaSettings.class));
    } catch (IOException e) {
      return Optional.empty();
    }
  }
}
