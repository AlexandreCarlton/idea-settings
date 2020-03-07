package com.github.alexandrecarlton.idea.settings.dialog.editor.spelling

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.spellchecker.SpellCheckerManager
import com.intellij.spellchecker.settings.SpellCheckerSettings
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.File

class SpellingSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<SpellingSettings>
    private lateinit var spellCheckerManager: SpellCheckerManager
    private lateinit var spellCheckerSettings: SpellCheckerSettings

    @Before
    public override fun setUp() {
        spellCheckerManager = SpellCheckerManager.getInstance(project)
        spellCheckerSettings = SpellCheckerSettings.getInstance(project)
        settingsApplier = SpellingSettingsApplier(spellCheckerManager, spellCheckerSettings)
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

    @Test
    fun acceptedWordsApplied() {
        settingsApplier.apply(SpellingSettings(acceptedWords = listOf("abcd", "efgh")))
        assertThat(spellCheckerManager.userDictionaryWords).contains("abcd", "efgh")
    }
}
