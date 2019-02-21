package com.github.alexandrecarlton.idea.settings.applier.api;

import com.intellij.openapi.project.Project;

public interface SettingsApplier<T> {
  void apply(Project project, T settings);
}
