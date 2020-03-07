package com.github.alexandrecarlton.idea.settings.dialog.project_settings.project

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectLanguageLevel
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectSettings
import com.intellij.openapi.application.WriteAction
import com.intellij.openapi.project.ex.ProjectEx
import com.intellij.openapi.roots.LanguageLevelProjectExtension
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.pom.java.LanguageLevel
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class ProjectSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<ProjectSettings>
    private lateinit var languageLevelProjectExtension: LanguageLevelProjectExtension
    private lateinit var projectRootManager: ProjectRootManager

    @Before
    public override fun setUp() {
        languageLevelProjectExtension = LanguageLevelProjectExtension.getInstance(project)
        projectRootManager = ProjectRootManager.getInstance(project)
        settingsApplier = ProjectSettingsApplier(languageLevelProjectExtension, project as ProjectEx, projectRootManager)
    }

    @Test
    fun projectNameApplied() {
        settingsApplier.apply(ProjectSettings(projectName = "my-project-name"))
        assertThat(project.name).isEqualTo("my-project-name")
    }

    @Test
    fun projectSdkApplied() {
        WriteAction.runAndWait<RuntimeException> {
            settingsApplier.apply(ProjectSettings(projectSdk = "my-project-sdk"))
        }
        assertThat(projectRootManager.projectSdkName).isEqualTo("my-project-sdk")
    }

    @Test
    fun projectLanguageLevelApplied() {
        settingsApplier.apply(ProjectSettings(projectLanguageLevel = ProjectLanguageLevel.JAVA_6))
        assertThat(languageLevelProjectExtension.languageLevel).isEqualByComparingTo(LanguageLevel.JDK_1_6)
    }
}
