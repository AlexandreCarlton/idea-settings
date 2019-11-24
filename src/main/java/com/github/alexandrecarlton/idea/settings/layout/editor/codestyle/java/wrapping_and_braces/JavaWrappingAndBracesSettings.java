package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavaWrappingAndBracesSettings.class)
public interface JavaWrappingAndBracesSettings {
  Optional<Integer> hardWrapAt();

  Optional<Boolean> wrapOnTyping();

  Optional<JavaKeepWhenReformattingSettings> keepWhenReformatting();

  Optional<JavaExtendsImplementsListSettings> extendsImplementsList();

  Optional<JavaMethodDeclarationParametersSettings> methodDeclarationParameters();

  Optional<JavaIfStatementSettings> ifStatement();

  Optional<JavaForStatementSettings> forStatement();

  Optional<JavaWhileStatementSettings> whileStatement();

  Optional<JavaDoWhileStatementSettings> doWhileStatement();

  Optional<JavaTryWithResourcesSettings> tryWithResources();

  Optional<JavaBinaryExpressionsSettings> binaryExpressions();

  Optional<JavaAssignmentStatementSettings> assignmentStatement();

  Optional<JavaTernaryOperationSettings> ternaryOperation();

  Optional<JavaArrayInitializerSettings> arrayInitializer();

  Optional<JavaAssertStatementSettings> assertStatement();

  Optional<JavaParameterAnnotationsSettings> parameterAnnotations();

  Optional<JavaLocalVariableAnnotationsSettings> localVariableAnnotations();

  Optional<JavaAnnotationParametersSettings> annotationParameters();
}
