package com.github.alexandrecarlton.idea.settings.applier.impl.editor.spelling

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.editor.spelling.ImmutableSpellingSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.spelling.SpellingSettings
import com.intellij.spellchecker.settings.SpellCheckerSettings
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.nio.file.Paths

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
        val dict = Paths.get(project.basePath).resolve("dict.dic")
        settingsApplier.apply(ImmutableSpellingSettings.builder()
            .addDictionaries(dict)
            .build())
        assertThat(spellCheckerSettings.customDictionariesPaths).containsOnly(dict.toString())
    }

    @Test
    fun absoluteDictionaryApplied() {
        settingsApplier.apply(ImmutableSpellingSettings.builder()
            .addDictionaries(Paths.get("/tmp/dict.dic"))
            .build())
        assertThat(spellCheckerSettings.customDictionariesPaths).containsOnly("/tmp/dict.dic")
    }
}
