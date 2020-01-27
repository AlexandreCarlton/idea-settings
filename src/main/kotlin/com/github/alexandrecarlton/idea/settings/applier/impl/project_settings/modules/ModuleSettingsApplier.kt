package com.github.alexandrecarlton.idea.settings.applier.impl.project_settings.modules

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.project_settings.modules.ModuleSettings
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.vfs.LocalFileSystem
import org.jetbrains.jps.model.java.JavaModuleSourceRootTypes
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

                source.sources?.forEach { rootSettings ->
                    localFileSystem.findFileByIoFile(source.contentRoot.resolve(rootSettings.root))
                            ?.let { folder -> contentEntry.sourceFolders.firstOrNull { it.file == folder }
                                    ?: contentEntry.addSourceFolder(folder, JavaSourceRootType.SOURCE) }
                            ?.also { sourceFolder -> rootSettings.properties?.packagePrefix?.let {
                                sourceFolder.packagePrefix = it
                            } }
                            ?.also { sourceFolder -> rootSettings.properties?.forGeneratedSources?.let {
                                sourceFolder.jpsElement.getProperties(JavaModuleSourceRootTypes.SOURCES)?.isForGeneratedSources = it
                            } }
                }
                source.tests?.forEach { rootSettings ->
                    localFileSystem.findFileByIoFile(source.contentRoot.resolve(rootSettings.root))
                            ?.let { folder -> contentEntry.sourceFolders.firstOrNull { it.file == folder }
                                    ?: contentEntry.addSourceFolder(folder, JavaSourceRootType.TEST_SOURCE) }
                            ?.also { sourceFolder -> rootSettings.properties?.packagePrefix?.let {
                                sourceFolder.packagePrefix = it
                            } }
                            ?.also { sourceFolder -> rootSettings.properties?.forGeneratedSources?.let {
                                sourceFolder.jpsElement.getProperties(JavaModuleSourceRootTypes.SOURCES)?.isForGeneratedSources = it
                            } }
                }
                source.resources?.forEach { rootSettings ->
                    localFileSystem.findFileByIoFile(source.contentRoot.resolve(rootSettings.root))
                            ?.let { folder -> contentEntry.sourceFolders.firstOrNull { it.file == folder }
                                    ?: contentEntry.addSourceFolder(folder, JavaResourceRootType.RESOURCE) }
                            ?.also { sourceFolder -> rootSettings.properties?.packagePrefix?.let {
                                sourceFolder.packagePrefix = it
                            } }
                            ?.also { sourceFolder -> rootSettings.properties?.forGeneratedResources?.let {
                                sourceFolder.jpsElement.getProperties(JavaModuleSourceRootTypes.RESOURCES)?.isForGeneratedSources = it
                            } }
                }
                source.testResources?.forEach { rootSettings ->
                    localFileSystem.findFileByIoFile(source.contentRoot.resolve(rootSettings.root))
                            ?.let { folder -> contentEntry.sourceFolders.firstOrNull { it.file == folder }
                                    ?: contentEntry.addSourceFolder(folder, JavaResourceRootType.TEST_RESOURCE) }
                            ?.also { sourceFolder -> rootSettings.properties?.packagePrefix?.let {
                                sourceFolder.packagePrefix = it
                            } }
                            ?.also { sourceFolder -> rootSettings.properties?.forGeneratedResources?.let {
                                sourceFolder.jpsElement.getProperties(JavaModuleSourceRootTypes.RESOURCES)?.isForGeneratedSources = it
                            } }
                }
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
