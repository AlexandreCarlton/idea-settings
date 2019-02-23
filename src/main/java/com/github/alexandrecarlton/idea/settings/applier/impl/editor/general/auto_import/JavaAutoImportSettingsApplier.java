package com.github.alexandrecarlton.idea.settings.applier.impl.editor.general.auto_import;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import.JavaAutoImportSettings;
import com.intellij.codeInsight.JavaProjectCodeInsightSettings;
import com.intellij.openapi.project.Project;

import javax.inject.Inject;

public class JavaAutoImportSettingsApplier implements SettingsApplier<JavaAutoImportSettings> {

  private final Project project;

  @Inject
  public JavaAutoImportSettingsApplier(Project project) {
    this.project = project;
  }

  @Override
  public void apply(JavaAutoImportSettings settings) {
    // This saves to the workspace file, which we don't know how to persist (yet).
    // CodeInsightWorkspaceSettings workspaceSettings = CodeInsightWorkspaceSettings.getInstance(project);
    // settings.optimizeImportsOnTheFly().ifPresent(optimize -> {
    //   workspaceSettings.optimizeImportsOnTheFly = optimize;
    // });

    final JavaProjectCodeInsightSettings codeInsightSettings = JavaProjectCodeInsightSettings.getSettings(project);
    codeInsightSettings.excludedNames.addAll(settings.excludeFromImportAndCompletion());
  }
}
