package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.javascript;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.javascript.ImmutableJavascriptImportsSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.javascript.JavascriptImportsSettings;
import com.intellij.application.options.CodeStyle;
import com.intellij.lang.javascript.formatter.JSCodeStyleSettings;
import com.intellij.lang.javascript.formatter.JSCodeStyleSettings.BooleanWithGlobalOption;
import org.junit.Before;
import org.junit.Test;

public class JavascriptImportsSettingsApplierTest extends IdeaSettingsTestFixture {

  private JSCodeStyleSettings jsCodeStyleSettings;
  private SettingsApplier<JavascriptImportsSettings> javascriptImportsSettingsApplier;

  @Before
  public void setUp() {
    jsCodeStyleSettings = CodeStyle.getSettings(project).getCustomSettings(JSCodeStyleSettings.class);
    javascriptImportsSettingsApplier = new JavascriptImportsSettingsApplier(jsCodeStyleSettings);
  }

  @Test
  public void usePathsRelativeToTheProjectResourceOrSourcesRootsApplied() {
    assertThat(jsCodeStyleSettings.IMPORT_PREFER_ABSOLUTE_PATH).isEqualTo(BooleanWithGlobalOption.GLOBAL);
    javascriptImportsSettingsApplier.apply(ImmutableJavascriptImportsSettings.builder()
        .usePathsRelativeToTheProjectResourceOrSourcesRoots(true)
        .build());
    assertThat(jsCodeStyleSettings.IMPORT_PREFER_ABSOLUTE_PATH).isEqualTo(BooleanWithGlobalOption.TRUE);
  }

}
