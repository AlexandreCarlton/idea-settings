package com.github.alexandrecarlton.idea.settings.applier.impl.editor.spelling

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.editor.spelling.SpellingSettings
import com.intellij.spellchecker.settings.SpellCheckerSettings
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.File

class SpellingSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<SpellingSettings>
    private lateinit var spellCheckerSettings: SpellCheckerSettings

    @Before
    public override fun setUp() {
        spellCheckerSettings = SpellCheckerSettings.getInstance(project)
        settingsApplier = SpellingSettingsApplier(spellCheckerSettings)
    }

    @After
    public override fun tearDown() {
        spellCheckerSettings.customDictionariesPaths.clear()
    }

    @Test
    fun dictionaryRelativeToProjectApplied() {
        val dict = File(project.basePath).resolve("dict.dic")
        settingsApplier.apply(SpellingSettings(dictionaries = listOf(dict)))
        assertThat(spellCheckerSettings.customDictionariesPaths).containsOnly(dict.toString())
    }

    @Test
    fun absoluteDictionaryApplied() {
        settingsApplier.apply(SpellingSettings(dictionaries = listOf(File("/tmp/dict.dic"))))
        assertThat(spellCheckerSettings.customDictionariesPaths).containsOnly("/tmp/dict.dic")
    }
}
