package com.github.alexandrecarlton.idea.settings.dialog.editor.spelling

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.File

class SpellingSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<SpellingSettings>

    @Before
    public override fun setUp() {
        settingsApplier = SpellingSettingsApplier(platform.spellCheckerManager, platform.spellCheckerSettings)
    }

    @After
    public override fun tearDown() {
        platform.spellCheckerSettings.customDictionariesPaths.clear()
    }

    @Test
    fun dictionaryRelativeToProjectApplied() {
        val dict = File(project.basePath).resolve("dict.dic")
        settingsApplier.apply(SpellingSettings(dictionaries = listOf(dict)))
        assertThat(platform.spellCheckerSettings.customDictionariesPaths).containsOnly(dict.toString())
    }

    @Test
    fun absoluteDictionaryApplied() {
        settingsApplier.apply(SpellingSettings(dictionaries = listOf(File("/tmp/dict.dic"))))
        assertThat(platform.spellCheckerSettings.customDictionariesPaths).containsOnly("/tmp/dict.dic")
    }

    @Test
    fun acceptedWordsApplied() {
        settingsApplier.apply(SpellingSettings(acceptedWords = listOf("abcd", "efgh")))
        assertThat(platform.spellCheckerManager.userDictionaryWords).contains("abcd", "efgh")
    }
}
