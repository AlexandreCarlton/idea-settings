package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript.code_quality_tools.JavascriptCodeQualityToolsSettings
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.lang.javascript.dialects.JSLanguageLevel
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class JavascriptSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<JavascriptSettings>
    private val javascriptCodeQualityToolsSettingsApplier = mockk<SettingsApplier<JavascriptCodeQualityToolsSettings>>(relaxUnitFun = true)

    @Before
    public override fun setUp() {
        settingsApplier = JavascriptSettingsApplier(platform.jsRootConfiguration, javascriptCodeQualityToolsSettingsApplier)
    }

    // TODO We had a test for React JSX but it was removed - we should add the remaining ones.
}
