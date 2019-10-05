package com.github.alexandrecarlton.idea.settings.applier.impl.project_settings.modules;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.project_settings.modules.ModuleSettings;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;

import org.jetbrains.jps.model.java.JavaResourceRootType;
import org.jetbrains.jps.model.java.JavaSourceRootType;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class ModuleSettingsApplier implements SettingsApplier<ModuleSettings> {

  private final ModifiableRootModel modifiableRootModel;

  @Inject
  public ModuleSettingsApplier(ModifiableRootModel modifiableRootModel) {
    this.modifiableRootModel = modifiableRootModel;
  }

  @Override
  public void apply(ModuleSettings settings) {
    List<ContentEntry> contentEntries = Arrays.asList(modifiableRootModel.getContentEntries());
    settings.sources().forEach(source -> {
      try {
        ContentEntry contentEntry = contentEntries.stream()
            .filter(c -> Paths.get(URI.create(c.getUrl())).equals(source.contentRoot()))
            .findFirst()
            .orElse(modifiableRootModel.addContentEntry(source.contentRoot().toUri().toString()));

        source.sources()
            .stream()
            .map(source.contentRoot()::resolve)
            .map(Path::toUri)
            .map(URI::toString)
            .forEach(uri -> contentEntry.addSourceFolder(uri, JavaSourceRootType.SOURCE));
        source.tests()
            .stream()
            .map(source.contentRoot()::resolve)
            .map(Path::toUri)
            .map(URI::toString)
            .forEach(uri -> contentEntry.addSourceFolder(uri, JavaSourceRootType.TEST_SOURCE));
        source.resources()
            .stream()
            .map(source.contentRoot()::resolve)
            .map(Path::toUri)
            .map(URI::toString)
            .forEach(uri -> contentEntry.addSourceFolder(uri, JavaResourceRootType.RESOURCE));
        source.testResources()
            .stream()
            .map(source.contentRoot()::resolve)
            .map(Path::toUri)
            .map(URI::toString)
            .forEach(uri -> contentEntry.addSourceFolder(uri, JavaResourceRootType.TEST_RESOURCE));
        source.excluded()
            .stream()
            .map(source.contentRoot()::resolve)
            .map(Path::toUri)
            .map(URI::toString)
            .forEach(contentEntry::addExcludeFolder);
      } finally {
        modifiableRootModel.commit();
      }
    });
  }
}
