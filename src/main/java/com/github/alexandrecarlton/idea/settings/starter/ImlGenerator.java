package com.github.alexandrecarlton.idea.settings.starter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings;
import com.intellij.openapi.application.WriteAction;
import com.intellij.openapi.application.ex.ApplicationEx;
import com.intellij.openapi.application.ex.ApplicationManagerEx;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

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
    IdeaSettings settings = loadSettings(path);
    IdeaSettingsComponent component = DaggerIdeaSettingsComponent
        .builder()
        .project(path.toString())
        .build();
    // TODO: We should DI the Project and ApplicationEx, and pull them from the component.
    WriteAction.runAndWait(() -> {
      component.applier().apply(settings);
      // TODO: project.save(); so SettingsApplier<IdeaSettings> doesn't have to save it.
    });
    ApplicationEx appEx = ApplicationManagerEx.getApplicationEx();
    appEx.exit(false, true);
  }

  private IdeaSettings loadSettings(Path project) {
    Path configFile = project.resolve(IDEA_SETTINGS_FILENAME);
    if (!Files.exists(configFile)) {
      System.out.println(configFile + " does not exist. Exiting.");
      System.exit(1);
    }
    try (InputStream inputStream = Files.newInputStream(configFile)) {
      return mapper.readValue(inputStream, IdeaSettings.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
