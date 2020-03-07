package com.github.alexandrecarlton.idea.settings.dialog.other_settings

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.other_settings.OtherSettings
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleSettings
import com.github.alexandrecarlton.idea.settings.layout.other_settings.save_actions.SaveActionsSettings

import javax.inject.Inject

class OtherSettingsApplier @Inject
constructor(
    private val checkstyleSettingsApplier: SettingsApplier<CheckstyleSettings>,
    private val saveActionsSettingsApplier: SettingsApplier<SaveActionsSettings>
) : SettingsApplier<OtherSettings> {

    override fun apply(settings: OtherSettings) {
        settings.checkstyle?.let(checkstyleSettingsApplier::apply)
        settings.saveActions?.let(saveActionsSettingsApplier::apply)
    }
}
