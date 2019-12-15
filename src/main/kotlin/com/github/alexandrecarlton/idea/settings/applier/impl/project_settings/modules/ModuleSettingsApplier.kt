package com.github.alexandrecarlton.idea.settings.applier.impl.project_settings.modules

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.project_settings.modules.ModuleSettings
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.vfs.LocalFileSystem
import org.jetbrains.jps.model.java.JavaResourceRootType
import org.jetbrains.jps.model.java.JavaSourceRootType
import javax.inject.Inject

class ModuleSettingsApplier @Inject
constructor(private val localFileSystem: LocalFileSystem,
            private val modifiableRootModel: ModifiableRootModel) : SettingsApplier<ModuleSettings> {

    override fun apply(settings: ModuleSettings) {
        val contentEntries = listOf(*modifiableRootModel.contentEntries)
        settings.sources?.forEach { source ->
            try {
                val contentRootFile = localFileSystem.findFileByIoFile(source.contentRoot)!!
                val contentEntry = contentEntries
                    .firstOrNull { entry -> entry.file == contentRootFile }
                    ?: modifiableRootModel.addContentEntry(contentRootFile)

                source.sources
                    ?.map(source.contentRoot::resolve)
                    ?.mapNotNull(localFileSystem::findFileByIoFile)
                    ?.forEach { contentEntry.addSourceFolder(it, JavaSourceRootType.SOURCE) }
                source.tests
                    ?.map(source.contentRoot::resolve)
                    ?.mapNotNull(localFileSystem::findFileByIoFile)
                    ?.forEach { contentEntry.addSourceFolder(it, JavaSourceRootType.TEST_SOURCE) }
                source.resources
                    ?.map(source.contentRoot::resolve)
                    ?.mapNotNull(localFileSystem::findFileByIoFile)
                    ?.forEach { contentEntry.addSourceFolder(it, JavaResourceRootType.RESOURCE) }
                source.testResources
                    ?.map(source.contentRoot::resolve)
                    ?.mapNotNull(localFileSystem::findFileByIoFile)
                    ?.forEach { contentEntry.addSourceFolder(it, JavaResourceRootType.TEST_RESOURCE) }
                source.excluded
                    ?.map(source.contentRoot::resolve)
                    ?.mapNotNull(localFileSystem::findFileByIoFile)
                    ?.forEach { contentEntry.addExcludeFolder(it) }

            } finally {
                modifiableRootModel.commit()
            }
        }
    }
}
