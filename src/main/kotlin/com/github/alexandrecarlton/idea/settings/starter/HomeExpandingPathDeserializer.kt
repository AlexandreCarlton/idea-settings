package com.github.alexandrecarlton.idea.settings.starter

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer
import java.nio.file.Path

/**
 * A custom [Path] deserialiser that:
 * - resolves the path relative to the project checkout.
 * - expands `~` to the user's home directory.
 * Note that this requires that the path exist on the user's filesystem.
 */
// TODO: This should deserialise a File instead, once everything is in Kotlin.
class HomeExpandingPathDeserializer(private val basePath: Path, vc: Class<*>?) : StdScalarDeserializer<Path>(vc) {

    constructor(basePath: Path) : this(basePath, null)

    override fun deserialize(jp: JsonParser, ctxt: DeserializationContext): Path =
        basePath.resolve(jp.valueAsString
            .replace("~", System.getProperty("user.home")))
            // TODO: Remove toRealPath; just call it when comparing modules.
            // Causing us too many issues otherwise.
            .toRealPath()
}
