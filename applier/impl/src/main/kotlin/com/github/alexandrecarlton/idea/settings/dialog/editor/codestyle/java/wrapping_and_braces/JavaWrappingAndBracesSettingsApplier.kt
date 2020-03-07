package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.wrapping_and_braces

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
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
        settings.hardWrapAt?.let { commonCodeStyleSettings.RIGHT_MARGIN = it }
        settings.wrapOnTyping?.let { commonCodeStyleSettings.WRAP_ON_TYPING = toWrapOnTyping(it).intValue }

        settings.keepWhenReformatting?.lineBreaks?.let { commonCodeStyleSettings.KEEP_LINE_BREAKS = it }
        settings.keepWhenReformatting?.commentAtFirstColumn?.let { commonCodeStyleSettings.KEEP_FIRST_COLUMN_COMMENT = it }
        settings.keepWhenReformatting?.controlStatementInOneLine?.let { commonCodeStyleSettings.KEEP_CONTROL_STATEMENT_IN_ONE_LINE = it }
        settings.keepWhenReformatting?.multipleExpressionsInOneLine?.let { commonCodeStyleSettings.KEEP_MULTIPLE_EXPRESSIONS_IN_ONE_LINE = it }
        settings.keepWhenReformatting?.simpleBlocksInOneLine?.let { commonCodeStyleSettings.KEEP_SIMPLE_BLOCKS_IN_ONE_LINE = it }
        settings.keepWhenReformatting?.simpleMethodsInOneLine?.let { commonCodeStyleSettings.KEEP_SIMPLE_METHODS_IN_ONE_LINE = it }
        settings.keepWhenReformatting?.simpleLambdasInOneLine?.let { commonCodeStyleSettings.KEEP_SIMPLE_LAMBDAS_IN_ONE_LINE = it }
        settings.keepWhenReformatting?.simpleClassesInOneLine?.let { commonCodeStyleSettings.KEEP_SIMPLE_CLASSES_IN_ONE_LINE = it }

        settings.extendsImplementsList?.wrapping?.let { commonCodeStyleSettings.EXTENDS_LIST_WRAP = toWrap(it) }
        settings.extendsImplementsList?.alignWhenMultiline?.let { commonCodeStyleSettings.ALIGN_MULTILINE_EXTENDS_LIST = it }

        settings.methodDeclarationParameters?.wrapping?.let { commonCodeStyleSettings.METHOD_PARAMETERS_WRAP = toWrap(it) }

        settings.ifStatement?.forceBraces?.let { commonCodeStyleSettings.IF_BRACE_FORCE = toForce(it) }

        settings.forStatement?.wrapping?.let { commonCodeStyleSettings.FOR_STATEMENT_WRAP = toWrap(it) }
        settings.forStatement?.forceBraces?.let { commonCodeStyleSettings.FOR_BRACE_FORCE = toForce(it) }

        settings.whileStatement?.forceBraces?.let { commonCodeStyleSettings.WHILE_BRACE_FORCE = toForce(it) }

        settings.doWhileStatement?.forceBraces?.let { commonCodeStyleSettings.DOWHILE_BRACE_FORCE = toForce(it) }

        settings.tryWithResources?.wrapping?.let { commonCodeStyleSettings.RESOURCE_LIST_WRAP = toWrap(it) }

        settings.binaryExpressions?.wrapping?.let { commonCodeStyleSettings.BINARY_OPERATION_WRAP = toWrap(it) }
        settings.binaryExpressions?.alignWhenMultiline?.let { commonCodeStyleSettings.ALIGN_MULTILINE_BINARY_OPERATION = it }

        settings.assignmentStatement?.wrapping?.let { commonCodeStyleSettings.ASSIGNMENT_WRAP = toWrap(it) }

        settings.ternaryOperation?.wrapping?.let { commonCodeStyleSettings.TERNARY_OPERATION_WRAP = toWrap(it) }

        settings.arrayInitializer?.wrapping?.let { commonCodeStyleSettings.ARRAY_INITIALIZER_WRAP = toWrap(it) }

        settings.assertStatement?.wrapping?.let { commonCodeStyleSettings.ASSERT_STATEMENT_WRAP = toWrap(it) }

        settings.parameterAnnotations?.wrapping?.let { commonCodeStyleSettings.PARAMETER_ANNOTATION_WRAP = toWrap(it) }

        settings.localVariableAnnotations?.wrapping?.let { commonCodeStyleSettings.VARIABLE_ANNOTATION_WRAP = toWrap(it) }

        settings.annotationParameters?.wrapping?.let { javaCodeStyleSettings.ANNOTATION_PARAMETER_WRAP = toWrap(it) }
        settings.annotationParameters?.alignWhenMultiline?.let { javaCodeStyleSettings.ALIGN_MULTILINE_ANNOTATION_PARAMETERS = it }
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
