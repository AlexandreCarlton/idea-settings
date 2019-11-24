package com.github.alexandrecarlton.idea.settings.applier.impl.editor.general.auto_import;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import.ImmutableJavaAutoImportSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import.JavaAutoImportSettings;
import com.intellij.codeInsight.CodeInsightWorkspaceSettings;
import com.intellij.codeInsight.JavaProjectCodeInsightSettings;
import org.junit.Before;
import org.junit.Test;

public class JavaAutoImportSettingsApplierTest extends IdeaSettingsTestFixture {

  private SettingsApplier<JavaAutoImportSettings> settingsApplier;
  private CodeInsightWorkspaceSettings codeInsightWorkspaceSettings;
  private JavaProjectCodeInsightSettings javaProjectCodeInsightSettings;

  @Before
  public void setUp() {
    codeInsightWorkspaceSettings = CodeInsightWorkspaceSettings.getInstance(project);
    javaProjectCodeInsightSettings = JavaProjectCodeInsightSettings.getSettings(project);
    settingsApplier = new JavaAutoImportSettingsApplier(codeInsightWorkspaceSettings, javaProjectCodeInsightSettings);
  }

  @Test
  public void optimizeImportsOnTheFlyApplied() {
    settingsApplier.apply(ImmutableJavaAutoImportSettings.builder()
        .optimizeImportsOnTheFly(true)
        .build());
    assertThat(codeInsightWorkspaceSettings.optimizeImportsOnTheFly).isTrue();
  }
  @Test
  public void excludeFromImportAndCompletionApplied() {
    settingsApplier.apply(ImmutableJavaAutoImportSettings.builder()
        .addExcludeFromImportAndCompletion(
            "com.google.inject.Inject",
            "com.sun.istack.internal.Nullable")
        .build());
    assertThat(javaProjectCodeInsightSettings.excludedNames).containsExactlyInAnyOrder(
        "com.google.inject.Inject",
        "com.sun.istack.internal.Nullable");
  }

}
