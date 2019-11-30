package com.github.alexandrecarlton.idea.settings.starter

import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import com.fasterxml.jackson.datatype.guava.GuavaModule
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.github.alexandrecarlton.idea.settings.dagger.project.DaggerIdeaSettingsComponent
import com.github.alexandrecarlton.idea.settings.dagger.project.IdeaSettingsComponent
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings
import com.intellij.openapi.application.ApplicationStarter
import com.intellij.openapi.application.WriteAction
import com.intellij.openapi.application.ex.ApplicationManagerEx
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

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
        val path = Paths.get(args[1])
        if (!Files.exists(path)) {
            throw IllegalArgumentException("Please supply a valid path to the project.")
        }
    }

    override fun main(vararg args: String) {
        val path = Paths.get(args[1])
        applySettings(path)
        ApplicationManagerEx.getApplicationEx().exit(true, true)
    }

    private fun applySettings(path: Path) {
        val component: IdeaSettingsComponent = DaggerIdeaSettingsComponent
            .builder()
            .project(path.toString())
            .build()
        val settings = loadSettings(path)
        ApplicationManagerEx.getApplicationEx().isSaveAllowed = true
        WriteAction.runAndWait<RuntimeException> {
            settings?.also { component.applier().apply(it) }
            component.project().save()
        }
    }

    private fun loadSettings(project: Path): IdeaSettings? {
        val ideaSettingsReader = YAMLMapper()
            .registerModule(Jdk8Module())
            .registerModule(GuavaModule())
            .registerModule(SimpleModule()
                .addDeserializer(Path::class.java, HomeExpandingPathDeserializer(project)))
            .readerFor(IdeaSettings::class.java)
        val configFile = project.resolve(IDEA_SETTINGS_FILENAME)
        if (!Files.exists(configFile)) {
            return null
        }
        return try {
            Files.newInputStream(configFile).use { inputStream -> ideaSettingsReader.readValue(inputStream) }
        } catch (e: IOException) {
            println(e.message)
            null
        }
    }
}
