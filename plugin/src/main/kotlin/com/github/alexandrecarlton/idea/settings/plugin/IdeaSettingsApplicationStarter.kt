package com.github.alexandrecarlton.idea.settings.plugin

import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.github.alexandrecarlton.idea.settings.project.DaggerIdeaSettingsComponent
import com.github.alexandrecarlton.idea.settings.project.IdeaSettingsComponent
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings
import com.intellij.openapi.application.ApplicationStarter
import com.intellij.openapi.application.WriteAction
import com.intellij.openapi.application.ex.ApplicationManagerEx
import java.io.File
import java.io.IOException

class IdeaSettingsApplicationStarter : ApplicationStarter {

    companion object {
        private const val IDEA_SETTINGS_FILENAME = ".IDEA-settings.yml"
    }

    override fun getCommandName() = "applyIdeaSettings"

    override fun isHeadless() = true

    override fun premain(vararg args: String) {
        if (args.size < 2) {
            throw IllegalArgumentException("Please supply the path to the project.")
        }
        val project = File(args[1])
        if (!project.exists()) {
            throw IllegalArgumentException("Please supply a valid path to the project.")
        }
    }

    override fun main(vararg args: String) {
        val project = File(args[1])
        applySettings(project)
        ApplicationManagerEx.getApplicationEx().exit(true, true)
    }

    private fun applySettings(project: File) {
        val component: IdeaSettingsComponent = DaggerIdeaSettingsComponent
            .builder()
            .project(project.absolutePath)
            .build()
        val settings = loadSettings(project)
        ApplicationManagerEx.getApplicationEx().isSaveAllowed = true
        WriteAction.runAndWait<RuntimeException> {
            settings?.let { component.applier().apply(it) }
            component.project().save()
        }
    }

    private fun loadSettings(project: File): IdeaSettings? {
        val ideaSettingsReader = YAMLMapper()
            .registerModule(KotlinModule())
            .registerModule(SimpleModule()
                .addDeserializer(File::class.java, ProjectRelativeFileDeserializer(project)))
            .readerFor(IdeaSettings::class.java)
        val configFile = project.resolve(IDEA_SETTINGS_FILENAME)
        if (!configFile.exists()) {
            return null
        }
        return try {
            ideaSettingsReader.readValue(configFile.inputStream())
        } catch (e: IOException) {
            println(e.message)
            null
        }
    }
}
