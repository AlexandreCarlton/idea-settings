package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.javascript;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.javascript.JavascriptImportsSettings;
import com.intellij.lang.javascript.formatter.JSCodeStyleSettings;
import com.intellij.lang.javascript.formatter.JSCodeStyleSettings.BooleanWithGlobalOption;
import javax.inject.Inject;

public class JavascriptImportsSettingsApplier implements SettingsApplier<JavascriptImportsSettings> {

  private final JSCodeStyleSettings jsCodeStyleSettings;

  @Inject
  public JavascriptImportsSettingsApplier(JSCodeStyleSettings jsCodeStyleSettings) {
    this.jsCodeStyleSettings = jsCodeStyleSettings;
  }

  @Override
  public void apply(JavascriptImportsSettings settings) {
    settings.usePathsRelativeToTheProjectResourceOrSourcesRoots()
        .ifPresent(use -> jsCodeStyleSettings.IMPORT_PREFER_ABSOLUTE_PATH = toBooleanWithGlobalOption(use));
  }

  private BooleanWithGlobalOption toBooleanWithGlobalOption(boolean value) {
    return value ? BooleanWithGlobalOption.TRUE : BooleanWithGlobalOption.FALSE;
  }
}
