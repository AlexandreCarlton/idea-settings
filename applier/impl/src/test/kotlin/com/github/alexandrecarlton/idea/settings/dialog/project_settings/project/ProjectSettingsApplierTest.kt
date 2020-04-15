package com.github.alexandrecarlton.idea.settings.dialog.project_settings.project

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.openapi.application.WriteAction
import com.intellij.openapi.project.ex.ProjectEx
import com.intellij.openapi.projectRoots.JavaSdk
import com.intellij.pom.java.LanguageLevel
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class ProjectSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<ProjectSettings>

    @Before
    public override fun setUp() {
        settingsApplier = ProjectSettingsApplier(platform.languageLevelProjectExtension, project as ProjectEx, platform.projectRootManager)
    }

    @Test
    fun projectNameApplied() {
        settingsApplier.apply(ProjectSettings(projectName = "my-project-name"))
        assertThat(project.name).isEqualTo("my-project-name")
    }

    @Test
    fun projectSdkApplied() {
        WriteAction.runAndWait<RuntimeException> {
            settingsApplier.apply(ProjectSettings(
                projectSdk = ProjectSdkSettings(
                    name = "my-project-sdk",
                    type = ProjectSdkType.JAVA)))
        }
        assertThat(platform.projectRootManager.projectSdkName).isEqualTo("my-project-sdk")
        assertThat(platform.projectRootManager.projectSdkTypeName).isEqualTo("JavaSDK")
    }

    @Test
    fun projectLanguageLevelApplied() {
        settingsApplier.apply(ProjectSettings(projectLanguageLevel = ProjectLanguageLevel.JAVA_6))
        assertThat(platform.languageLevelProjectExtension.languageLevel).isEqualByComparingTo(LanguageLevel.JDK_1_6)
    }
}
