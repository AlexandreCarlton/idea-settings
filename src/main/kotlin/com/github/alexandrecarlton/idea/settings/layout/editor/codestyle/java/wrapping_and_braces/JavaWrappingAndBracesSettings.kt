package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces

import com.fasterxml.jackson.annotation.JsonProperty

data class JavaWrappingAndBracesSettings(

    @JsonProperty("Hard wrap at")
    val hardWrapAt: Int? = null,

    @JsonProperty("Wrap on typing")
    val wrapOnTyping: Boolean? = null,

    @JsonProperty("Keep when reformatting")
    val keepWhenReformatting: JavaKeepWhenReformattingSettings? = null,

    @JsonProperty("Extends/implements list")
    val extendsImplementsList: JavaExtendsImplementsListSettings? = null,

    @JsonProperty("Method declaration parameters")
    val methodDeclarationParameters: JavaMethodDeclarationParametersSettings? = null,

    @JsonProperty("if() statement")
    val ifStatement: JavaIfStatementSettings? = null,

    @JsonProperty("for() statement")
    val forStatement: JavaForStatementSettings? = null,

    @JsonProperty("while() statement")
    val whileStatement: JavaWhileStatementSettings? = null,

    @JsonProperty("do ... while() statement")
    val doWhileStatement: JavaDoWhileStatementSettings? = null,

    @JsonProperty("try-with-resources")
    val tryWithResources: JavaTryWithResourcesSettings? = null,

    @JsonProperty("Binary expressions")
    val binaryExpressions: JavaBinaryExpressionsSettings? = null,

    @JsonProperty("Assignment statement")
    val assignmentStatement: JavaAssignmentStatementSettings? = null,

    @JsonProperty("Ternary operation")
    val ternaryOperation: JavaTernaryOperationSettings? = null,

    @JsonProperty("Array initializer")
    val arrayInitializer: JavaArrayInitializerSettings? = null,

    @JsonProperty("Assert statement")
    val assertStatement: JavaAssertStatementSettings? = null,

    @JsonProperty("Parameter annotations")
    val parameterAnnotations: JavaParameterAnnotationsSettings? = null,

    @JsonProperty("Local variable annotations")
    val localVariableAnnotations: JavaLocalVariableAnnotationsSettings? = null,

    @JsonProperty("Annotation parameters")
    val annotationParameters: JavaAnnotationParametersSettings? = null
)
