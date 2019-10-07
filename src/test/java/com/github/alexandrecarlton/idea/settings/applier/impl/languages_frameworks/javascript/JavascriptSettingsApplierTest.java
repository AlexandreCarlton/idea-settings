package com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks.javascript;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.ImmutableJavascriptSettings;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptLanguageVersion;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptSettings;
import com.intellij.lang.javascript.dialects.JSLanguageLevel;
import com.intellij.lang.javascript.settings.JSRootConfiguration;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JavascriptSettingsApplierTest extends IdeaSettingsTestFixture {

  private SettingsApplier<JavascriptSettings> settingsApplier;
  private JSRootConfiguration jsRootConfiguration;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    jsRootConfiguration = JSRootConfiguration.getInstance(project);
    settingsApplier = new JavascriptSettingsApplier(jsRootConfiguration);
  }

  @Test
  public void setLanguageToReact() {
    settingsApplier.apply(ImmutableJavascriptSettings.builder()
        .javascriptLanguageVersion(JavascriptLanguageVersion.REACT_JSX)
        .build());
    assertThat(jsRootConfiguration.getLanguageLevel()).isEqualTo(JSLanguageLevel.JSX);
  }

}
