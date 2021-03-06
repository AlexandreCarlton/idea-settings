package com.github.alexandrecarlton.idea.settings.dialog.tools.file_watchers

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.common.filetype.IdeaFileType
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.lang.javascript.JavaScriptFileType
import com.intellij.openapi.fileTypes.FileType
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import java.util.function.Function

class FileWatcherSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<FileWatcherSettings>
    private val fileTypeMapper = mockk<Function<IdeaFileType, FileType>>()

    @Before
    public override fun setUp() {
        settingsApplier = FileWatcherSettingsApplier(platform.projectTasksOptions, fileTypeMapper)
        every { fileTypeMapper.apply(IdeaFileType.JAVASCRIPT) } returns JavaScriptFileType.INSTANCE
    }

    @Test
    fun basicSettingsApplied() {
        settingsApplier.apply(FileWatcherSettings(
            name = "Basic File Watcher",
            filesToWatch = FileWatcherFilesToWatchSettings(
                fileType = IdeaFileType.JAVASCRIPT,
                scope = "Module 'foo'"),
            toolToRunOnChanges = FileWatcherToolToRunOnChangesSettings(
                program = "/usr/bin/foo",
                arguments = "bar",
                outputPathsToRefresh = "\$FilePath$",
                workingDirectory = "\$ProjectFileDir$"
                )))

        val taskOptions = platform.projectTasksOptions.tasks
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
                fileType = IdeaFileType.JAVASCRIPT,
                scope = "Module 'foo'"),
            toolToRunOnChanges = FileWatcherToolToRunOnChangesSettings(
                program = "/usr/bin/foo",
                arguments = "bar",
                outputPathsToRefresh = "\$FilePath"),
            advancedOptions = FileWatcherAdvancedOptionsSettings(
                autoSaveEditedFilesToTriggerTheWatcher = true,
                triggerTheWatcherOnExternalChanges = false,
                triggerTheWatcherRegardlessOfSyntaxErrors = true)))

        val taskOptions = platform.projectTasksOptions.tasks
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
