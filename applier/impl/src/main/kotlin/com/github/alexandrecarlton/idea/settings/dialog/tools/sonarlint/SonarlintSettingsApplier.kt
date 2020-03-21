package com.github.alexandrecarlton.idea.settings.dialog.tools.sonarlint

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.tools.sonarlint.project_settings.SonarlintProjectSettingsSettings
import javax.inject.Inject

class SonarlintSettingsApplier @Inject constructor(
    private val sonarlintProjectSettingsSettingsApplier: SettingsApplier<SonarlintProjectSettingsSettings>
) : SettingsApplier<SonarlintSettings>
{
    override fun apply(settings: SonarlintSettings) {
        settings.projectSettings?.let(sonarlintProjectSettingsSettingsApplier::apply)
    }
}
