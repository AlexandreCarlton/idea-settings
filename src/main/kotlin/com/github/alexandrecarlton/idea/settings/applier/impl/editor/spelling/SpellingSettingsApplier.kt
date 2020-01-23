package com.github.alexandrecarlton.idea.settings.applier.impl.editor.spelling

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.spelling.SpellingSettings
import com.intellij.spellchecker.SpellCheckerManager
import com.intellij.spellchecker.settings.SpellCheckerSettings
import javax.inject.Inject

class SpellingSettingsApplier @Inject
constructor(
    private val spellCheckerManager: SpellCheckerManager,
    private val spellCheckerSettings: SpellCheckerSettings
) : SettingsApplier<SpellingSettings> {

    override fun apply(settings: SpellingSettings) {
        settings.dictionaries
            ?.map { it.absolutePath }
            ?.let { spellCheckerSettings.customDictionariesPaths = it }
        settings.acceptedWords
            ?.let(spellCheckerManager::updateUserDictionary)
    }
}
