package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavadocOtherSettings.class)
public interface JavadocOtherSettings {

  Optional<Boolean> wrapAtRightMargin();

  Optional<Boolean> enableLeadingAsterisks();

  Optional<Boolean> useThrowsRatherThanException();

  Optional<Boolean> generatePOnEmptyLines();

  Optional<Boolean> keepEmptyLines();

  Optional<Boolean> doNotWrapOneLineComments();

  Optional<Boolean> preserveLineFeeds();

  Optional<Boolean> parameterDescriptionsOnNewLine();

  Optional<Boolean> indentContinuationLines();

}
