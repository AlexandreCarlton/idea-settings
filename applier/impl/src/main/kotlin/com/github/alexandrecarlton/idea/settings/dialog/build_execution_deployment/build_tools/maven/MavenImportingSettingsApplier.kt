package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools.maven

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import org.jetbrains.idea.maven.execution.MavenRunnerSettings
import javax.inject.Inject

class MavenImportingSettingsApplier @Inject
constructor(private val mavenImportingSettings: org.jetbrains.idea.maven.project.MavenImportingSettings) : SettingsApplier<MavenImportingSettings> {

    override fun apply(settings: MavenImportingSettings) {
        settings.vmOptionsForImporter?.let { mavenImportingSettings.vmOptionsForImporter = it }
        settings.jdkForImporter?.let { mavenImportingSettings.jdkForImporter = toJdkForImporter(it) }
    }

    // Unfortunately this cannot be an enum as this can take in custom JDK types
    private fun toJdkForImporter(jdk: String) = when (jdk) {
        // See ExternalSystemJdkComboBox.java for "sanitised" names
        "Use Project JDK" -> MavenRunnerSettings.USE_PROJECT_JDK
        "Use Internal JRE" -> MavenRunnerSettings.USE_INTERNAL_JAVA
        "Use JAVA_HOME" -> MavenRunnerSettings.USE_JAVA_HOME
        else -> jdk
    }

}
