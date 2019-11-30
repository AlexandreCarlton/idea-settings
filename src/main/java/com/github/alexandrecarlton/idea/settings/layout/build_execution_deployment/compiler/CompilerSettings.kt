package com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler

data class CompilerSettings (
    val resourcePatterns: List<String>? = null,
    val addRuntimeAssertionsForNotnullAnnotatedMethodsAndParameters: Boolean? = null,
    val buildProcessHeapSizeMbytes: Int? = null,
    val compileIndependentModulesInParallel: Boolean? = null,
    val rebuildModuleOnDependencyChange: Boolean? = null,
    val sharedBuildProcessVmOptions: String? = null
)
