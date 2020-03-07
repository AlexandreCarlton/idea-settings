package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptLanguageVersion
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptSettings
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.code_quality_tools.JavascriptCodeQualityToolsSettings
import com.intellij.lang.javascript.dialects.JSLanguageLevel
import com.intellij.lang.javascript.settings.JSRootConfiguration
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class JavascriptSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<JavascriptSettings>
    private lateinit var jsRootConfiguration: JSRootConfiguration
    private val javascriptCodeQualityToolsSettingsApplier = mockk<SettingsApplier<JavascriptCodeQualityToolsSettings>>(relaxUnitFun = true)

    @Before
    public override fun setUp() {
        jsRootConfiguration = JSRootConfiguration.getInstance(project)
        settingsApplier = JavascriptSettingsApplier(jsRootConfiguration, javascriptCodeQualityToolsSettingsApplier)
    }

    @Test
    fun setLanguageToReact() {
        settingsApplier.apply(JavascriptSettings(javascriptLanguageVersion = JavascriptLanguageVersion.REACT_JSX))
        assertThat(jsRootConfiguration.languageLevel).isEqualTo(JSLanguageLevel.JSX)
    }
}
