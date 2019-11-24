package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.wrapping_and_braces;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.Force;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaAnnotationParametersSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaArrayInitializerSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaAssertStatementSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaAssignmentStatementSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaBinaryExpressionsSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaDoWhileStatementSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaExtendsImplementsListSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaForStatementSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaIfStatementSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaKeepWhenReformattingSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaLocalVariableAnnotationsSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaMethodDeclarationParametersSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaParameterAnnotationsSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaTernaryOperationSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaTryWithResourcesSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaWhileStatementSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaWrappingAndBracesSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.Wrapping;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings.WrapOnTyping;
import com.intellij.psi.codeStyle.JavaCodeStyleSettings;
import javax.inject.Inject;
import javax.inject.Named;

public class JavaWrappingAndBracesSettingsApplier implements SettingsApplier<JavaWrappingAndBracesSettings> {

  private final CommonCodeStyleSettings commonCodeStyleSettings;
  private final JavaCodeStyleSettings javaCodeStyleSettings;

  @Inject
  public JavaWrappingAndBracesSettingsApplier(@Named("java") CommonCodeStyleSettings commonCodeStyleSettings,
                                              JavaCodeStyleSettings javaCodeStyleSettings) {
    this.commonCodeStyleSettings = commonCodeStyleSettings;
    this.javaCodeStyleSettings = javaCodeStyleSettings;
  }

  @Override
  public void apply(JavaWrappingAndBracesSettings settings) {
    settings.hardWrapAt()
        .ifPresent(margin -> commonCodeStyleSettings.RIGHT_MARGIN = margin);
    settings.wrapOnTyping()
        .map(this::toWrapOnTyping)
        .ifPresent(wrapOnTyping -> commonCodeStyleSettings.WRAP_ON_TYPING = wrapOnTyping.intValue);

    settings.keepWhenReformatting()
        .flatMap(JavaKeepWhenReformattingSettings::lineBreaks)
        .ifPresent(keep -> commonCodeStyleSettings.KEEP_LINE_BREAKS = keep);
    settings.keepWhenReformatting()
        .flatMap(JavaKeepWhenReformattingSettings::commentAtFirstColumn)
        .ifPresent(keep -> commonCodeStyleSettings.KEEP_FIRST_COLUMN_COMMENT = keep);
    settings.keepWhenReformatting()
        .flatMap(JavaKeepWhenReformattingSettings::controlStatementInOneLine)
        .ifPresent(keep -> commonCodeStyleSettings.KEEP_CONTROL_STATEMENT_IN_ONE_LINE = keep);
    settings.keepWhenReformatting()
        .flatMap(JavaKeepWhenReformattingSettings::multipleExpressionsInOneLine)
        .ifPresent(keep -> commonCodeStyleSettings.KEEP_MULTIPLE_EXPRESSIONS_IN_ONE_LINE = keep);
    settings.keepWhenReformatting()
        .flatMap(JavaKeepWhenReformattingSettings::simpleBlocksInOneLine)
        .ifPresent(keep -> commonCodeStyleSettings.KEEP_SIMPLE_BLOCKS_IN_ONE_LINE = keep);
    settings.keepWhenReformatting()
        .flatMap(JavaKeepWhenReformattingSettings::simpleMethodsInOneLine)
        .ifPresent(keep -> commonCodeStyleSettings.KEEP_SIMPLE_METHODS_IN_ONE_LINE = keep);
    settings.keepWhenReformatting()
        .flatMap(JavaKeepWhenReformattingSettings::simpleLambdasInOneLine)
        .ifPresent(keep -> commonCodeStyleSettings.KEEP_SIMPLE_LAMBDAS_IN_ONE_LINE = keep);
    settings.keepWhenReformatting()
        .flatMap(JavaKeepWhenReformattingSettings::simpleClassesInOneLine)
        .ifPresent(keep -> commonCodeStyleSettings.KEEP_SIMPLE_CLASSES_IN_ONE_LINE = keep);

    settings.extendsImplementsList()
        .flatMap(JavaExtendsImplementsListSettings::wrapping)
        .map(this::toWrap)
        .ifPresent(wrap -> commonCodeStyleSettings.EXTENDS_LIST_WRAP = wrap);
    settings.extendsImplementsList()
        .flatMap(JavaExtendsImplementsListSettings::alignWhenMultiline)
        .ifPresent(align -> commonCodeStyleSettings.ALIGN_MULTILINE_EXTENDS_LIST = align);

    settings.methodDeclarationParameters()
        .flatMap(JavaMethodDeclarationParametersSettings::wrapping)
        .map(this::toWrap)
        .ifPresent(wrap -> commonCodeStyleSettings.METHOD_PARAMETERS_WRAP = wrap);

    settings.ifStatement()
        .flatMap(JavaIfStatementSettings::forceBraces)
        .map(this::toForce)
        .ifPresent(force -> commonCodeStyleSettings.IF_BRACE_FORCE = force);

    settings.forStatement()
        .flatMap(JavaForStatementSettings::wrapping)
        .map(this::toWrap)
        .ifPresent(wrap -> commonCodeStyleSettings.FOR_STATEMENT_WRAP = wrap);
    settings.forStatement()
        .flatMap(JavaForStatementSettings::forceBraces)
        .map(this::toForce)
        .ifPresent(force -> commonCodeStyleSettings.FOR_BRACE_FORCE = force);

    settings.whileStatement()
        .flatMap(JavaWhileStatementSettings::forceBraces)
        .map(this::toForce)
        .ifPresent(force -> commonCodeStyleSettings.WHILE_BRACE_FORCE = force);

    settings.doWhileStatement()
        .flatMap(JavaDoWhileStatementSettings::forceBraces)
        .map(this::toForce)
        .ifPresent(force -> commonCodeStyleSettings.DOWHILE_BRACE_FORCE = force);

    settings.tryWithResources()
        .flatMap(JavaTryWithResourcesSettings::wrapping)
        .map(this::toWrap)
        .ifPresent(wrap -> commonCodeStyleSettings.RESOURCE_LIST_WRAP = wrap);

    settings.binaryExpressions()
        .flatMap(JavaBinaryExpressionsSettings::wrapping)
        .map(this::toWrap)
        .ifPresent(wrap -> commonCodeStyleSettings.BINARY_OPERATION_WRAP = wrap);
    settings.binaryExpressions()
        .flatMap(JavaBinaryExpressionsSettings::alignWhenMultiline)
        .ifPresent(align -> commonCodeStyleSettings.ALIGN_MULTILINE_BINARY_OPERATION = align);

    settings.assignmentStatement()
        .flatMap(JavaAssignmentStatementSettings::wrapping)
        .map(this::toWrap)
        .ifPresent(wrap -> commonCodeStyleSettings.ASSIGNMENT_WRAP = wrap);

    settings.ternaryOperation()
        .flatMap(JavaTernaryOperationSettings::wrapping)
        .map(this::toWrap)
        .ifPresent(wrap -> commonCodeStyleSettings.TERNARY_OPERATION_WRAP = wrap);

    settings.arrayInitializer()
        .flatMap(JavaArrayInitializerSettings::wrapping)
        .map(this::toWrap)
        .ifPresent(wrap -> commonCodeStyleSettings.ARRAY_INITIALIZER_WRAP = wrap);

    settings.assertStatement()
        .flatMap(JavaAssertStatementSettings::wrapping)
        .map(this::toWrap)
        .ifPresent(wrap -> commonCodeStyleSettings.ASSERT_STATEMENT_WRAP = wrap);

    settings.parameterAnnotations()
        .flatMap(JavaParameterAnnotationsSettings::wrapping)
        .map(this::toWrap)
        .ifPresent(wrap -> commonCodeStyleSettings.PARAMETER_ANNOTATION_WRAP = wrap);

    settings.localVariableAnnotations()
        .flatMap(JavaLocalVariableAnnotationsSettings::wrapping)
        .map(this::toWrap)
        .ifPresent(wrap -> commonCodeStyleSettings.VARIABLE_ANNOTATION_WRAP = wrap);

    settings.localVariableAnnotations()
        .flatMap(JavaLocalVariableAnnotationsSettings::wrapping)
        .map(this::toWrap)
        .ifPresent(wrap -> commonCodeStyleSettings.VARIABLE_ANNOTATION_WRAP = wrap);

    settings.annotationParameters()
        .flatMap(JavaAnnotationParametersSettings::wrapping)
        .map(this::toWrap)
        .ifPresent(wrap -> javaCodeStyleSettings.ANNOTATION_PARAMETER_WRAP = wrap);
    settings.annotationParameters()
        .flatMap(JavaAnnotationParametersSettings::alignWhenMultiline)
        .ifPresent(align -> javaCodeStyleSettings.ALIGN_MULTILINE_ANNOTATION_PARAMETERS = align);
  }

  // TODO: Add option to use 'Default'?
  private WrapOnTyping toWrapOnTyping(boolean wrapOnTyping) {
    return wrapOnTyping
        ? WrapOnTyping.WRAP
        : WrapOnTyping.NO_WRAP;
  }

  private int toWrap(Wrapping wrapping) {
    switch (wrapping) {
      case DO_NOT_WRAP: return CommonCodeStyleSettings.DO_NOT_WRAP;
      case WRAP_IF_LONG: return CommonCodeStyleSettings.WRAP_AS_NEEDED;
      // See intellij-community's WrapperTest for evidence of this binary OR combination being used.
      case CHOP_DOWN_IF_LONG: return CommonCodeStyleSettings.WRAP_AS_NEEDED | CommonCodeStyleSettings.WRAP_ON_EVERY_ITEM;
      case WRAP_ALWAYS: return CommonCodeStyleSettings.WRAP_ALWAYS;
      default:
        throw new IllegalArgumentException("Unhandled wrapping: " + wrapping);
    }
  }

  private int toForce(Force force) {
    switch (force) {
      case DO_NOT_FORCE: return CommonCodeStyleSettings.DO_NOT_FORCE;
      case WHEN_MULTILINE: return CommonCodeStyleSettings.FORCE_BRACES_IF_MULTILINE;
      case ALWAYS: return CommonCodeStyleSettings.FORCE_BRACES_ALWAYS;
      default:
        throw new IllegalArgumentException("Unahdled force: " + force);
    }
  }
}
