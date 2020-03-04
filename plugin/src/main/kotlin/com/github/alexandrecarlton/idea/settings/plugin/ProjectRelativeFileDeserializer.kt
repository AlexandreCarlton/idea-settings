package com.github.alexandrecarlton.idea.settings.plugin

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer
import java.io.File
import java.nio.file.Path

/**
 * A custom [Path] deserialiser that:
 * - resolves the path relative to the project checkout.
 * - expands `~` to the user's home directory.
 * Note that this requires that the path exist on the user's filesystem.
 */
class ProjectRelativeFileDeserializer(private val project: File, vc: Class<*>?) : StdScalarDeserializer<File>(vc) {

    constructor(project: File) : this(project, null)

    override fun deserialize(jp: JsonParser, ctxt: DeserializationContext) = project.resolve(File(jp.valueAsString))
}
