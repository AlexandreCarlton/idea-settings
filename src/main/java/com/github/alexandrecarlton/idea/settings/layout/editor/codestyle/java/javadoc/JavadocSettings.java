package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavadocSettings.class)
public interface JavadocSettings {

  Optional<Boolean> enableJavadocFormatting();

  Optional<JavadocAlignmentSettings> alignment();

  Optional<JavadocBlankLinesSettings> blankLines();

  Optional<JavadocInvalidTagsSettings> invalidTags();

  Optional<JavadocOtherSettings> other();

}
