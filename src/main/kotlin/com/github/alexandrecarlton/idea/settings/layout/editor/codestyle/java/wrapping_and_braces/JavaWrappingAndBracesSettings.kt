package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces

data class JavaWrappingAndBracesSettings(
    val hardWrapAt: Int? = null,

    val wrapOnTyping: Boolean? = null,

    val keepWhenReformatting: JavaKeepWhenReformattingSettings? = null,

    val extendsImplementsList: JavaExtendsImplementsListSettings? = null,

    val methodDeclarationParameters: JavaMethodDeclarationParametersSettings? = null,

    val ifStatement: JavaIfStatementSettings? = null,

    val forStatement: JavaForStatementSettings? = null,

    val whileStatement: JavaWhileStatementSettings? = null,

    val doWhileStatement: JavaDoWhileStatementSettings? = null,

    val tryWithResources: JavaTryWithResourcesSettings? = null,

    val binaryExpressions: JavaBinaryExpressionsSettings? = null,

    val assignmentStatement: JavaAssignmentStatementSettings? = null,

    val ternaryOperation: JavaTernaryOperationSettings? = null,

    val arrayInitializer: JavaArrayInitializerSettings? = null,

    val assertStatement: JavaAssertStatementSettings? = null,

    val parameterAnnotations: JavaParameterAnnotationsSettings? = null,

    val localVariableAnnotations: JavaLocalVariableAnnotationsSettings? = null,

    val annotationParameters: JavaAnnotationParametersSettings? = null
)
