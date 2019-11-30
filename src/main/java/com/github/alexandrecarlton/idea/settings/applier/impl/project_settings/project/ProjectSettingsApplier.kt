package com.github.alexandrecarlton.idea.settings.applier.impl.project_settings.project

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectLanguageLevel
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectLanguageLevel.JAVA_10
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectLanguageLevel.JAVA_11
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectLanguageLevel.JAVA_12
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectLanguageLevel.JAVA_1_3
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectLanguageLevel.JAVA_1_4
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectLanguageLevel.JAVA_5
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectLanguageLevel.JAVA_6
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectLanguageLevel.JAVA_7
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectLanguageLevel.JAVA_8
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectLanguageLevel.JAVA_9
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectLanguageLevel.JAVA_X
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectSettings
import com.intellij.openapi.project.ex.ProjectEx
import com.intellij.openapi.roots.LanguageLevelProjectExtension
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.pom.java.LanguageLevel

import javax.inject.Inject

class ProjectSettingsApplier @Inject
constructor(private val languageLevelProjectExtension: LanguageLevelProjectExtension,
            private val projectEx: ProjectEx,
            private val projectRootManager: ProjectRootManager) : SettingsApplier<ProjectSettings> {

    override fun apply(settings: ProjectSettings) {
        settings.projectName().ifPresent { projectEx.setProjectName(it) }
        settings.projectSdk().ifPresent { projectRootManager.projectSdkName = it }
        settings.projectLanguageLevel().ifPresent { languageLevelProjectExtension.languageLevel = toLanguageLevel(it) }
    }

    private fun toLanguageLevel(level: ProjectLanguageLevel) =
        when (level) {
            JAVA_1_3 -> LanguageLevel.JDK_1_3
            JAVA_1_4 -> LanguageLevel.JDK_1_4
            JAVA_5 -> LanguageLevel.JDK_1_5
            JAVA_6 -> LanguageLevel.JDK_1_6
            JAVA_7 -> LanguageLevel.JDK_1_7
            JAVA_8 -> LanguageLevel.JDK_1_8
            JAVA_9 -> LanguageLevel.JDK_1_9
            JAVA_10 -> LanguageLevel.JDK_10
            JAVA_11 -> LanguageLevel.JDK_11
            JAVA_12 -> LanguageLevel.JDK_12
            JAVA_X -> LanguageLevel.JDK_X
        }
}
