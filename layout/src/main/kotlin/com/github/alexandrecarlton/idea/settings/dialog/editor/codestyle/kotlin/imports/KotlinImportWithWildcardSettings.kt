package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.imports

import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonTypeName
import com.fasterxml.jackson.annotation.JsonValue

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
sealed class KotlinImportWithWildcardSettings

@JsonTypeName("Use single name import")
object UseSingleNameImportSettings : KotlinImportWithWildcardSettings()

@JsonTypeName("Use import with '*'")
object UseImportWithWildcardSettings : KotlinImportWithWildcardSettings()

@JsonTypeName("Use import with '*' when at least _ names used")
data class UseImportWithWildcardWhenAtLeastNamesUsedSettings(
    @get:JsonValue
    val count: Int
) : KotlinImportWithWildcardSettings()
