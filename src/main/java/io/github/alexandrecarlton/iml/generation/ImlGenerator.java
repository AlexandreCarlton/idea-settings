package io.github.alexandrecarlton.iml.generation;

import com.intellij.ide.impl.ProjectUtil;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class ImlGenerator {

  /**
   * Generates *.iml files for the given path.
   * @param path the location of the project.
   */
  public void generate(Path path) {
    Project project = ProjectUtil.openOrImport(path.toString(), null, false);
    project.save();

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

}
