package com.github.alexandrecarlton.idea.settings.applier.impl.project_settings.modules;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.project_settings.modules.ModuleSettings;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;

import org.jetbrains.jps.model.java.JavaResourceRootType;
import org.jetbrains.jps.model.java.JavaSourceRootType;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class ModuleSettingsApplier implements SettingsApplier<ModuleSettings> {

  private final ModifiableRootModel modifiableRootModel;
  // TODO: Once we deserialise all paths relative to the project, we no longer need this.
  private final Project project;

  @Inject
  public ModuleSettingsApplier(ModifiableRootModel modifiableRootModel, Project project) {
    this.modifiableRootModel = modifiableRootModel;
    this.project = project;
  }

  @Override
  public void apply(ModuleSettings settings) {
    List<ContentEntry> contentEntries = Arrays.asList(modifiableRootModel.getContentEntries());
    settings.sources().forEach(source -> {
      try {
        final Path path;
        try {
          // TODO: Deserialise all paths relative to the project
          path = Paths.get(project.getBasePath()).resolve(source.contentRoot()).toRealPath();
        } catch (IOException e) {
          throw new UncheckedIOException(e);
        }

        ContentEntry contentEntry = contentEntries.stream()
            .filter(c -> Paths.get(URI.create(c.getUrl())).equals(path))
            .findFirst()
            .orElse(modifiableRootModel.addContentEntry(path.toUri().toString()));
        source.sources()
            .stream()
            .map(path::resolve)
            .map(Path::toUri)
            .map(URI::toString)
            .forEach(uri -> contentEntry.addSourceFolder(uri, JavaSourceRootType.SOURCE));
        source.tests()
            .stream()
            .map(path::resolve)
            .map(Path::toUri)
            .map(URI::toString)
            .forEach(uri -> contentEntry.addSourceFolder(uri, JavaSourceRootType.TEST_SOURCE));
        source.resources()
            .stream()
            .map(path::resolve)
            .map(Path::toUri)
            .map(URI::toString)
            .forEach(uri -> contentEntry.addSourceFolder(uri, JavaResourceRootType.RESOURCE));
        source.testResources()
            .stream()
            .map(path::resolve)
            .map(Path::toUri)
            .map(URI::toString)
            .forEach(uri -> contentEntry.addSourceFolder(uri, JavaResourceRootType.TEST_RESOURCE));
        source.excluded()
            .stream()
            .map(path::resolve)
            .map(Path::toUri)
            .map(URI::toString)
            .forEach(contentEntry::addExcludeFolder);
      } finally {
        modifiableRootModel.commit();
      }
    });
  }
}
