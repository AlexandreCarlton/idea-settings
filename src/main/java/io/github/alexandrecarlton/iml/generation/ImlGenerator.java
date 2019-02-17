package io.github.alexandrecarlton.iml.generation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.intellij.ide.impl.ProjectUtil;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsManager;
import com.intellij.psi.codeStyle.JavaCodeStyleSettings;
import com.sun.org.apache.bcel.internal.classfile.Code;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import io.github.alexandrecarlton.iml.generation.config.CodeStyle;
import io.github.alexandrecarlton.iml.generation.config.Editor;
import io.github.alexandrecarlton.iml.generation.config.IdeaConfig;
import io.github.alexandrecarlton.iml.generation.config.Imports;
import io.github.alexandrecarlton.iml.generation.config.Java;


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

    IdeaConfig config = loadConfig(path);

    Project project = ProjectUtil.openOrImport(path.toString(), null, false);
    project.save();

    config.configure(project);

    ModuleManager moduleManager = ModuleManager.getInstance(project);
    List<Module> modules = Arrays.asList(moduleManager.getModules());

    ModuleRootManager moduleRootManager = ModuleRootManager.getInstance(modules.get(0));
    ModifiableRootModel modifiableRootModel = moduleRootManager.getModifiableModel();
    List<ContentEntry> contentEntries = Arrays.asList(modifiableRootModel.getContentEntries());
    // We can add an excluded folder to a content entry via "file://" + full path to url

    System.out.println("Committing...");
    modifiableRootModel.commit();

    System.out.println("Saving...");
    project.save();
  }

  private IdeaConfig loadConfig(Path project) {
    Path configFile = project.resolve(".IDEA-config.yml");
    if (!Files.exists(configFile)) {
      System.out.println(configFile + " does not exist. Exiting.");
      System.exit(1);
    }
    try (InputStream inputStream = Files.newInputStream(configFile)) {
      return mapper.readValue(inputStream, IdeaConfig.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
