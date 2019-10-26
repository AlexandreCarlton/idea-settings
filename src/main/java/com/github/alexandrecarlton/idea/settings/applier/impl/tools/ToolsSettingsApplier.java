package com.github.alexandrecarlton.idea.settings.applier.impl.tools;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.tools.ToolsSettings;
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherSettings;

import javax.inject.Inject;

public class ToolsSettingsApplier implements SettingsApplier<ToolsSettings> {

  private final SettingsApplier<FileWatcherSettings> fileWatcherSettingsApplier;

  @Inject
  public ToolsSettingsApplier(SettingsApplier<FileWatcherSettings> fileWatcherSettingsApplier) {
    this.fileWatcherSettingsApplier = fileWatcherSettingsApplier;
  }

  @Override
  public void apply(ToolsSettings settings) {
    settings.fileWatchers().forEach(fileWatcherSettingsApplier::apply);
  }

}
