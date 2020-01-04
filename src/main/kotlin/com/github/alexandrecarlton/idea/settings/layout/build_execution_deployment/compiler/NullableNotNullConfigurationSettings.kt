package com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler

import com.fasterxml.jackson.annotation.JsonProperty

data class NullableNotNullConfigurationSettings (

    @JsonProperty("Nullable annotations")
    val nullableAnnotations: NullableAnnotationsSettings? = null,

    @JsonProperty("NotNull annotations")
    val notnullAnnotations: NotnullAnnotationsSettings? = null
)

data class NullableAnnotationsSettings (

    @JsonProperty("Annotation used for code generation")
    val annotationUsedForCodeGeneration: String? = null,

    @JsonProperty("Annotations")
    val annotations: List<String>? = null
)

data class NotnullAnnotationsSettings (

    @JsonProperty("Annotation used for code generation")
    val annotationUsedForCodeGeneration: String? = null,

    @JsonProperty("Annotations")
    val annotations: List<InstrumentedAnnotation>? = null
)

data class InstrumentedAnnotation (

    @JsonProperty("Annotation")
    val annotation: String,

    @JsonProperty("Instrument")
    val instrumented: Boolean? = null
)
