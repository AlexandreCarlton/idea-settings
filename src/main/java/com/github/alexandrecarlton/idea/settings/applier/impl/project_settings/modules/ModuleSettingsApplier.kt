package com.github.alexandrecarlton.idea.settings.applier.impl.project_settings.modules

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.project_settings.modules.ModuleSettings
import com.intellij.openapi.roots.ModifiableRootModel
import org.jetbrains.jps.model.java.JavaResourceRootType
import org.jetbrains.jps.model.java.JavaSourceRootType
import java.net.URI
import java.nio.file.Paths
import javax.inject.Inject

class ModuleSettingsApplier @Inject
constructor(private val modifiableRootModel: ModifiableRootModel) : SettingsApplier<ModuleSettings> {

    override fun apply(settings: ModuleSettings) {
        val contentEntries = listOf(*modifiableRootModel.contentEntries)
        settings.sources().forEach { source ->
            try {
                val contentEntry = contentEntries
                    .firstOrNull { c -> Paths.get(URI.create(c.url)) == source.contentRoot() }
                    ?: modifiableRootModel.addContentEntry(source.contentRoot().toUri().toString())

                source.sources()
                    .stream()
                    .map { source.contentRoot().resolve(it) }
                    .map { it.toUri() }
                    .map { it.toString() }
                    .forEach { contentEntry.addSourceFolder(it, JavaSourceRootType.SOURCE) }
                source.tests()
                    .map { source.contentRoot().resolve(it) }
                    .map { it.toUri() }
                    .map { it.toString() }
                    .forEach { contentEntry.addSourceFolder(it, JavaSourceRootType.TEST_SOURCE) }
                source.resources()
                    .stream()
                    .map { source.contentRoot().resolve(it) }
                    .map { it.toUri() }
                    .map { it.toString() }
                    .forEach { contentEntry.addSourceFolder(it, JavaResourceRootType.RESOURCE) }
                source.testResources()
                    .stream()
                    .map { source.contentRoot().resolve(it) }
                    .map { it.toUri() }
                    .map { it.toString() }
                    .forEach { contentEntry.addSourceFolder(it, JavaResourceRootType.TEST_RESOURCE) }
                source.excluded()
                    .stream()
                    .map { source.contentRoot().resolve(it) }
                    .map { it.toUri() }
                    .map { it.toString() }
                    .forEach { contentEntry.addExcludeFolder(it) }
            } finally {
                modifiableRootModel.commit()
            }
        }
    }
}
