package com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks.javascript;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptLanguageVersion;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptSettings;
import com.intellij.lang.javascript.dialects.JSLanguageLevel;
import com.intellij.lang.javascript.settings.JSRootConfiguration;

public class JavascriptSettingsApplier implements SettingsApplier<JavascriptSettings> {

  private final JSRootConfiguration jsRootConfiguration;

  public JavascriptSettingsApplier(JSRootConfiguration jsRootConfiguration) {
    this.jsRootConfiguration = jsRootConfiguration;
  }

  @Override
  public void apply(JavascriptSettings settings) {
    settings.javascriptLanguageVersion()
      .map(JavascriptSettingsApplier::toJSLanguageLevel)
      .ifPresent(jsRootConfiguration::storeLanguageLevelAndUpdateCaches);
  }

  private static JSLanguageLevel toJSLanguageLevel(JavascriptLanguageVersion version) {
    switch(version) {
      case FLOW: return JSLanguageLevel.FLOW;
      case ECMASCRIPT_3: return JSLanguageLevel.JS_1_5;
      case ECMASCRIPT_5_1: return JSLanguageLevel.ES5;
      case ECMASCRIPT_6: return JSLanguageLevel.ES6;
      case JAVASCRIPT_1_8_5: return JSLanguageLevel.JS_1_8_5;
      case NASHORN_JS: return JSLanguageLevel.NASHORN;
      case REACT_JSX: return JSLanguageLevel.JSX;
      default:
        throw new IllegalArgumentException("Unknown JavascriptLanguageVersion: " + version);
    }
  }
}
