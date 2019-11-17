package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavadocInvalidTagsSettings.class)
public interface JavadocInvalidTagsSettings {

  Optional<Boolean> keepInvalidTags();

  Optional<Boolean> keepEmptyParamTags();

  Optional<Boolean> keepEmptyReturnTags();

  Optional<Boolean> keepEmptyThrowsTags();
}
