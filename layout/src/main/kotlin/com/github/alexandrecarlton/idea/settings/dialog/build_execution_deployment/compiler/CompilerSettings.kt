package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.compiler

import com.fasterxml.jackson.annotation.JsonProperty

data class CompilerSettings (

    @JsonProperty("Resource patterns")
    val resourcePatterns: List<String>? = null,

    @JsonProperty("Add runtime assertions for notnull-annotated methods and parameters")
    val addRuntimeAssertionsForNotnullAnnotatedMethodsAndParameters: Boolean? = null,

    /**
     * This can be found in the Compiler menu by clicking on 'Configure annotations...'
     * We use the window name (defined by xprop) for the [JsonProperty] value.
     */
    @JsonProperty("Nullable/NotNull Configuration")
    val nullableNotNullConfiguration: NullableNotNullConfigurationSettings? = null,

    @JsonProperty("Build process heap size (Mbytes)")
    val buildProcessHeapSizeMbytes: Int? = null,

    @JsonProperty("Compile independent modules in parallel")
    val compileIndependentModulesInParallel: Boolean? = null,

    @JsonProperty("Rebuild module on dependency change")
    val rebuildModuleOnDependencyChange: Boolean? = null,

    @JsonProperty("Shared build process VM options")
    val sharedBuildProcessVmOptions: String? = null
)
