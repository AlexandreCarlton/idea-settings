package com.github.alexandrecarlton.idea.settings.applier.impl.editor

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.EditorSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.CodeStyleSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.general.GeneralSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.spelling.SpellingSettings

import javax.inject.Inject

class EditorSettingsApplier @Inject
constructor(private val generalSettingsApplier: SettingsApplier<GeneralSettings>,
            private val codeStyleSettingsApplier: SettingsApplier<CodeStyleSettings>,
            private val spellingSettingsApplier: SettingsApplier<SpellingSettings>) : SettingsApplier<EditorSettings> {

    override fun apply(settings: EditorSettings) {
        settings.general?.let(generalSettingsApplier::apply)
        settings.codeStyle?.let(codeStyleSettingsApplier::apply)
        settings.spelling?.let(spellingSettingsApplier::apply)
    }
}
