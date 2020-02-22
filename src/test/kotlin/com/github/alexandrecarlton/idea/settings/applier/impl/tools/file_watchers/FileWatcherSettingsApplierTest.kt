package com.github.alexandrecarlton.idea.settings.applier.impl.tools.file_watchers

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.common.FileTypeMapper
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.common.FileType
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherAdvancedOptionsSettings
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherFilesToWatchSettings
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherSettings
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherToolToRunOnChangesSettings
import com.intellij.lang.javascript.JavaScriptFileType
import com.intellij.plugins.watcher.model.ProjectTasksOptions
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import java.util.function.Supplier

class FileWatcherSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<FileWatcherSettings>
    private lateinit var projectTasksOptions: ProjectTasksOptions
    private val fileTypeMapper = FileTypeMapper(Supplier { JavaScriptFileType.INSTANCE })

    @Before
    public override fun setUp() {
        projectTasksOptions = ProjectTasksOptions.getInstance(project)
        settingsApplier = FileWatcherSettingsApplier(projectTasksOptions, fileTypeMapper)
    }

    @Test
    fun basicSettingsApplied() {
        settingsApplier.apply(FileWatcherSettings(
            name = "Basic File Watcher",
            filesToWatch = FileWatcherFilesToWatchSettings(
                fileType = FileType.JAVASCRIPT,
                scope = "Module 'foo'"),
            toolToRunOnChanges = FileWatcherToolToRunOnChangesSettings(
                program = "/usr/bin/foo",
                arguments = "bar",
                outputPathsToRefresh = "\$FilePath$",
                workingDirectory = "\$ProjectFileDir$"
                )))

        val taskOptions = projectTasksOptions.tasks
                .stream()
                .filter { pair -> "Basic File Watcher" == pair.first.name }
                .findFirst()
                .get()
                .first
        assertThat(taskOptions.name).isEqualTo("Basic File Watcher")
        assertThat(taskOptions.program).isEqualTo("/usr/bin/foo")
        assertThat(taskOptions.arguments).isEqualTo("bar")
        assertThat(taskOptions.output).isEqualTo("\$FilePath$")
        assertThat(taskOptions.workingDir).isEqualTo("\$ProjectFileDir$")
        assertThat(taskOptions.fileExtension).isEqualTo("js")
        assertThat(taskOptions.scopeName).isEqualTo("Module 'foo'")
    }

    @Test
    fun advancedSettingsApplied() {
        settingsApplier.apply(FileWatcherSettings(
            name = "Advanced Watcher Settings",
            filesToWatch = FileWatcherFilesToWatchSettings(
                fileType = FileType.JAVASCRIPT,
                scope = "Module 'foo'"),
            toolToRunOnChanges = FileWatcherToolToRunOnChangesSettings(
                program = "/usr/bin/foo",
                arguments = "bar",
                outputPathsToRefresh = "\$FilePath"),
            advancedOptions = FileWatcherAdvancedOptionsSettings(
                autoSaveEditedFilesToTriggerTheWatcher = true,
                triggerTheWatcherOnExternalChanges = false,
                triggerTheWatcherRegardlessOfSyntaxErrors = true)))

        val taskOptions = projectTasksOptions.tasks
                .stream()
                .filter { pair -> "Advanced Watcher Settings" == pair.first.name }
                .findFirst()
                .get()
                .first
        assertThat(taskOptions.isImmediateSync).isTrue()
        assertThat(taskOptions.isRunOnExternalChanges).isFalse()
        assertThat(taskOptions.isCheckSyntaxErrors).isFalse()
    }
}
