package com.github.alexandrecarlton.idea.settings.dialog.tools.sonarlint.project_settings

import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonTypeName
import com.fasterxml.jackson.annotation.JsonValue
import java.io.File

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
sealed class SonarlintFileExclusion

@JsonTypeName("Exclude file")
data class ExcludeFile(
    @get:JsonValue
    val file: File
) : SonarlintFileExclusion()

@JsonTypeName("Exclude directory")
data class ExcludeDirectory(
    @get:JsonValue
    val directory: File
) : SonarlintFileExclusion()

@JsonTypeName("Exclude using GLOB pattern")
data class ExcludeUsingGlobPattern(
    @get:JsonValue
    val glob: String
) : SonarlintFileExclusion()
