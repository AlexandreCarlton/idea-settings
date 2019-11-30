package com.github.alexandrecarlton.idea.settings.applier.impl.other_settings

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.other_settings.OtherSettings
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleSettings

import javax.inject.Inject

class OtherSettingsApplier @Inject
constructor(private val checkstyleSettingsApplier: SettingsApplier<CheckstyleSettings>) : SettingsApplier<OtherSettings> {

    override fun apply(settings: OtherSettings) {
        settings.checkstyle?.let(checkstyleSettingsApplier::apply)
    }
}
