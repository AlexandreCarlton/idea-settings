package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.wrapping_and_braces

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.Force
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaWrappingAndBracesSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.Wrapping
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.codeStyle.CommonCodeStyleSettings.WrapOnTyping
import com.intellij.psi.codeStyle.JavaCodeStyleSettings
import javax.inject.Inject
import javax.inject.Named

class JavaWrappingAndBracesSettingsApplier @Inject
constructor(@param:Named("java") private val commonCodeStyleSettings: CommonCodeStyleSettings,
            private val javaCodeStyleSettings: JavaCodeStyleSettings) : SettingsApplier<JavaWrappingAndBracesSettings> {

    override fun apply(settings: JavaWrappingAndBracesSettings) {
        settings.hardWrapAt()
            .ifPresent { commonCodeStyleSettings.RIGHT_MARGIN = it }
        settings.wrapOnTyping()
            .map { this.toWrapOnTyping(it) }
            .ifPresent { commonCodeStyleSettings.WRAP_ON_TYPING = it.intValue }

        settings.keepWhenReformatting()
            .flatMap { it.lineBreaks() }
            .ifPresent { commonCodeStyleSettings.KEEP_LINE_BREAKS = it }
        settings.keepWhenReformatting()
            .flatMap { it.commentAtFirstColumn() }
            .ifPresent { commonCodeStyleSettings.KEEP_FIRST_COLUMN_COMMENT = it }
        settings.keepWhenReformatting()
            .flatMap { it.controlStatementInOneLine() }
            .ifPresent { commonCodeStyleSettings.KEEP_CONTROL_STATEMENT_IN_ONE_LINE = it }
        settings.keepWhenReformatting()
            .flatMap { it.multipleExpressionsInOneLine() }
            .ifPresent { commonCodeStyleSettings.KEEP_MULTIPLE_EXPRESSIONS_IN_ONE_LINE = it }
        settings.keepWhenReformatting()
            .flatMap { it.simpleBlocksInOneLine() }
            .ifPresent { commonCodeStyleSettings.KEEP_SIMPLE_BLOCKS_IN_ONE_LINE = it }
        settings.keepWhenReformatting()
            .flatMap { it.simpleMethodsInOneLine() }
            .ifPresent { commonCodeStyleSettings.KEEP_SIMPLE_METHODS_IN_ONE_LINE = it }
        settings.keepWhenReformatting()
            .flatMap { it.simpleLambdasInOneLine() }
            .ifPresent { commonCodeStyleSettings.KEEP_SIMPLE_LAMBDAS_IN_ONE_LINE = it }
        settings.keepWhenReformatting()
            .flatMap { it.simpleClassesInOneLine() }
            .ifPresent { commonCodeStyleSettings.KEEP_SIMPLE_CLASSES_IN_ONE_LINE = it }

        settings.extendsImplementsList()
            .flatMap { it.wrapping() }
            .map { toWrap(it) }
            .ifPresent { commonCodeStyleSettings.EXTENDS_LIST_WRAP = it }
        settings.extendsImplementsList()
            .flatMap { it.alignWhenMultiline() }
            .ifPresent { commonCodeStyleSettings.ALIGN_MULTILINE_EXTENDS_LIST = it }

        settings.methodDeclarationParameters()
            .flatMap  { it.wrapping() }
            .map { toWrap(it) }
            .ifPresent { commonCodeStyleSettings.METHOD_PARAMETERS_WRAP = it }

        settings.ifStatement()
            .flatMap { it.forceBraces() }
            .map { toForce(it) }
            .ifPresent { commonCodeStyleSettings.IF_BRACE_FORCE = it }

        settings.forStatement()
            .flatMap { it.wrapping() }
            .map { this.toWrap(it) }
            .ifPresent { commonCodeStyleSettings.FOR_STATEMENT_WRAP = it }
        settings.forStatement()
            .flatMap { it.forceBraces() }
            .map { toForce(it) }
            .ifPresent { commonCodeStyleSettings.FOR_BRACE_FORCE = it }

        settings.whileStatement()
            .flatMap { it.forceBraces() }
            .map { toForce(it) }
            .ifPresent { commonCodeStyleSettings.WHILE_BRACE_FORCE = it }

        settings.doWhileStatement()
            .flatMap { it.forceBraces() }
            .map { toForce(it) }
            .ifPresent { commonCodeStyleSettings.DOWHILE_BRACE_FORCE = it }

        settings.tryWithResources()
            .flatMap { it.wrapping() }
            .map { toWrap(it) }
            .ifPresent { commonCodeStyleSettings.RESOURCE_LIST_WRAP = it }

        settings.binaryExpressions()
            .flatMap { it.wrapping() }
            .map { toWrap(it) }
            .ifPresent { commonCodeStyleSettings.BINARY_OPERATION_WRAP = it }
        settings.binaryExpressions()
            .flatMap { it.alignWhenMultiline() }
            .ifPresent { commonCodeStyleSettings.ALIGN_MULTILINE_BINARY_OPERATION = it }

        settings.assignmentStatement()
            .flatMap { it.wrapping() }
            .map { toWrap(it) }
            .ifPresent { commonCodeStyleSettings.ASSIGNMENT_WRAP = it }

        settings.ternaryOperation()
            .flatMap { it.wrapping() }
            .map { toWrap(it) }
            .ifPresent { commonCodeStyleSettings.TERNARY_OPERATION_WRAP = it }

        settings.arrayInitializer()
            .flatMap { it.wrapping() }
            .map { this.toWrap(it) }
            .ifPresent { commonCodeStyleSettings.ARRAY_INITIALIZER_WRAP = it }

        settings.assertStatement()
            .flatMap { it.wrapping() }
            .map { toWrap(it) }
            .ifPresent { commonCodeStyleSettings.ASSERT_STATEMENT_WRAP = it }

        settings.parameterAnnotations()
            .flatMap { it.wrapping() }
            .map { this.toWrap(it) }
            .ifPresent { commonCodeStyleSettings.PARAMETER_ANNOTATION_WRAP = it }

        settings.localVariableAnnotations()
            .flatMap { it.wrapping() }
            .map { toWrap(it) }
            .ifPresent { commonCodeStyleSettings.VARIABLE_ANNOTATION_WRAP = it }

        settings.localVariableAnnotations()
            .flatMap { it.wrapping() }
            .map { toWrap(it) }
            .ifPresent { commonCodeStyleSettings.VARIABLE_ANNOTATION_WRAP = it }

        settings.annotationParameters()
            .flatMap { it.wrapping() }
            .map { toWrap(it) }
            .ifPresent { javaCodeStyleSettings.ANNOTATION_PARAMETER_WRAP = it }
        settings.annotationParameters()
            .flatMap { it.alignWhenMultiline() }
            .ifPresent { javaCodeStyleSettings.ALIGN_MULTILINE_ANNOTATION_PARAMETERS = it }
    }

    // TODO: Add option to use 'Default'?
    private fun toWrapOnTyping(wrapOnTyping: Boolean) =
        if (wrapOnTyping)
            WrapOnTyping.WRAP
        else
            WrapOnTyping.NO_WRAP

    private fun toWrap(wrapping: Wrapping) =
        when (wrapping) {
            Wrapping.DO_NOT_WRAP -> CommonCodeStyleSettings.DO_NOT_WRAP
            Wrapping.WRAP_IF_LONG -> CommonCodeStyleSettings.WRAP_AS_NEEDED
            // See intellij-community's WrapperTest for evidence of this binary OR combination being used.
            Wrapping.CHOP_DOWN_IF_LONG -> CommonCodeStyleSettings.WRAP_AS_NEEDED or CommonCodeStyleSettings.WRAP_ON_EVERY_ITEM
            Wrapping.WRAP_ALWAYS -> CommonCodeStyleSettings.WRAP_ALWAYS
        }

    private fun toForce(force: Force) =
        when (force) {
            Force.DO_NOT_FORCE -> CommonCodeStyleSettings.DO_NOT_FORCE
            Force.WHEN_MULTILINE -> CommonCodeStyleSettings.FORCE_BRACES_IF_MULTILINE
            Force.ALWAYS -> CommonCodeStyleSettings.FORCE_BRACES_ALWAYS
        }
}
