package com.github.alexandrecarlton.idea.settings.starter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.intellij.ide.impl.ProjectUtil;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.CodeStyleSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.EditorSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.JavaImportsSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.JavaCodeStyleSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.IdeaSettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class ImlGenerator {
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
    component.applier().apply(settings);
  }

  private IdeaSettings loadSettings(Path project) {
    Path configFile = project.resolve(".IDEA-config.yml");
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