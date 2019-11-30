package com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks.javascript

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptLanguageVersion
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptLanguageVersion.ECMASCRIPT_3
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptLanguageVersion.ECMASCRIPT_5_1
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptLanguageVersion.ECMASCRIPT_6
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptLanguageVersion.FLOW
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptLanguageVersion.JAVASCRIPT_1_8_5
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptLanguageVersion.NASHORN_JS
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptLanguageVersion.REACT_JSX
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptSettings
import com.intellij.lang.javascript.dialects.JSLanguageLevel
import com.intellij.lang.javascript.settings.JSRootConfiguration
import javax.inject.Inject

class JavascriptSettingsApplier @Inject
constructor(private val jsRootConfiguration: JSRootConfiguration) : SettingsApplier<JavascriptSettings> {

    override fun apply(settings: JavascriptSettings) {
        settings.javascriptLanguageVersion?.let { jsRootConfiguration.storeLanguageLevelAndUpdateCaches(toJSLanguageLevel(it)) }
    }

    private fun toJSLanguageLevel(version: JavascriptLanguageVersion) =
        when (version) {
            FLOW -> JSLanguageLevel.FLOW
            ECMASCRIPT_3 -> JSLanguageLevel.JS_1_5
            ECMASCRIPT_5_1 -> JSLanguageLevel.ES5
            ECMASCRIPT_6 -> JSLanguageLevel.ES6
            JAVASCRIPT_1_8_5 -> JSLanguageLevel.JS_1_8_5
            NASHORN_JS -> JSLanguageLevel.NASHORN
            REACT_JSX -> JSLanguageLevel.JSX
        }
}
