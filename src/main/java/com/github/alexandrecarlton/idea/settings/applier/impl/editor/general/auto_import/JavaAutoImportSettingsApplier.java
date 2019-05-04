package com.github.alexandrecarlton.idea.settings.applier.impl.editor.general.auto_import;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import.JavaAutoImportSettings;
import com.intellij.codeInsight.CodeInsightWorkspaceSettings;
import com.intellij.codeInsight.JavaProjectCodeInsightSettings;

import javax.inject.Inject;

public class JavaAutoImportSettingsApplier implements SettingsApplier<JavaAutoImportSettings> {

  private final CodeInsightWorkspaceSettings codeInsightWorkspaceSettings;
  private final JavaProjectCodeInsightSettings javaProjectCodeInsightSettings;

  @Inject
  public JavaAutoImportSettingsApplier(CodeInsightWorkspaceSettings codeInsightWorkspaceSettings,
                                       JavaProjectCodeInsightSettings javaProjectCodeInsightSettings) {
    this.codeInsightWorkspaceSettings = codeInsightWorkspaceSettings;
    this.javaProjectCodeInsightSettings = javaProjectCodeInsightSettings;
  }

  @Override
  public void apply(JavaAutoImportSettings settings) {
    // This saves to the workspace file, which we don't know how to persist (yet).
    settings.optimizeImportsOnTheFly().ifPresent(optimize -> {
       codeInsightWorkspaceSettings.optimizeImportsOnTheFly = optimize;
    });

    javaProjectCodeInsightSettings.excludedNames.addAll(settings.excludeFromImportAndCompletion());
  }
}
