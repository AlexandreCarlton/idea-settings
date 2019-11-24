package com.github.alexandrecarlton.idea.settings.applier.impl.tools.file_watchers

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.common.FileTypeMapper
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.common.FileType
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherSettings
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.ImmutableFileWatcherAdvancedOptionsSettings
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.ImmutableFileWatcherFilesToWatchSettings
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.ImmutableFileWatcherSettings
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.ImmutableFileWatcherToolToRunOnChangesSettings
import com.intellij.lang.javascript.JavaScriptFileType
import com.intellij.plugins.watcher.model.ProjectTasksOptions
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`

class FileWatcherSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<FileWatcherSettings>
    private lateinit var projectTasksOptions: ProjectTasksOptions
    @Mock
    private lateinit var fileTypeMapper: FileTypeMapper

    @Before
    public override fun setUp() {
        projectTasksOptions = ProjectTasksOptions.getInstance(project)
        settingsApplier = FileWatcherSettingsApplier(projectTasksOptions, fileTypeMapper)
    }

    @Test
    fun basicSettingsApplied() {
        `when`(fileTypeMapper.mapFileType(FileType.JAVASCRIPT)).thenReturn(JavaScriptFileType.INSTANCE)

        settingsApplier.apply(ImmutableFileWatcherSettings.builder()
                .name("Basic File Watcher")
                .toolToRunOnChanges(ImmutableFileWatcherToolToRunOnChangesSettings.builder()
                        .program("/usr/bin/foo")
                        .arguments("bar")
                        .outputPathsToRefresh("\$FilePath$")
                        .build())
                .filesToWatch(ImmutableFileWatcherFilesToWatchSettings.builder()
                        .fileType(FileType.JAVASCRIPT)
                        .scope("Module 'foo'")
                        .build())
                .build())

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
        assertThat(taskOptions.fileExtension).isEqualTo("js")
        assertThat(taskOptions.scopeName).isEqualTo("Module 'foo'")
    }

    @Test
    fun advancedSettingsApplied() {
        settingsApplier.apply(ImmutableFileWatcherSettings.builder()
                .name("Advanced Watcher Settings")
                .toolToRunOnChanges(ImmutableFileWatcherToolToRunOnChangesSettings.builder()
                        .program("/usr/bin/foo")
                        .arguments("bar")
                        .outputPathsToRefresh("\$FilePath$")
                        .build())
                .filesToWatch(ImmutableFileWatcherFilesToWatchSettings.builder()
                        .fileType(FileType.JAVASCRIPT)
                        .scope("Module 'foo'")
                        .build())
                .advancedOptions(ImmutableFileWatcherAdvancedOptionsSettings.builder()
                        .autoSaveEditedFilesToTriggerTheWatcher(true)
                        .triggerTheWatcherOnExternalChanges(false)
                        .triggerTheWatcherRegardlessOfSyntaxErrors(true)
                        .build())
                .build())

        val taskOptions = projectTasksOptions.tasks
                .stream()
                .filter { pair -> "Advanced Watcher Settings" == pair.first.name }
                .findFirst()
                .get()
                .first
        assertThat(taskOptions.isImmediateSync).isTrue()
        assertThat(taskOptions.isRunOnExternalChanges).isFalse()
        assertThat(taskOptions.isCheckSyntaxErrors).isTrue()
    }
}
