package com.github.alexandrecarlton.idea.settings.dialog.configurations.common.before_launch

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BeforeLaunchConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BuildConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.RunAnotherConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.RunMavenGoalSettings
import javax.inject.Inject

class BeforeLaunchConfigurationSettingsApplier @Inject
constructor(
    private val buildConfigurationSettingsApplier: SettingsApplier<BuildConfigurationSettings>,
    private val runAnotherConfigurationSettingsApplier: SettingsApplier<RunAnotherConfigurationSettings>,
    private val runMavenGoalSettingsApplier: SettingsApplier<RunMavenGoalSettings>
) : SettingsApplier<BeforeLaunchConfigurationSettings> {

    override fun apply(settings: BeforeLaunchConfigurationSettings) {
        when (settings) {
            is BuildConfigurationSettings -> buildConfigurationSettingsApplier.apply(settings)
            is RunAnotherConfigurationSettings -> runAnotherConfigurationSettingsApplier.apply(settings)
            is RunMavenGoalSettings -> runMavenGoalSettingsApplier.apply(settings)
        }
    }
}
