package com.github.alexandrecarlton.idea.settings.layout.other_settings.save_actions

import com.fasterxml.jackson.annotation.JsonProperty

data class FormattingActionsSettings(
    @JsonProperty("Optimize imports")
    val optimizeImports: Boolean? = null,

    @JsonProperty("Reformat file")
    val reformatFile: Boolean? = null,

    @JsonProperty("Reformat only changed code (only if VCS configured)")
    val reformatOnlyChangedCode: Boolean? = null,

    @JsonProperty("Rearrange fields and methods (configured in \"File > Settins > Editor > Codestyle > (...) > Arrangement\")")
    val rearrangeFieldsAndMethods: Boolean? = null
)
