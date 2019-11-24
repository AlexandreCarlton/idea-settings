package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavaKeepWhenReformattingSettings.class)
public interface JavaKeepWhenReformattingSettings {

  Optional<Boolean> lineBreaks();

  Optional<Boolean> commentAtFirstColumn();

  Optional<Boolean> controlStatementInOneLine();

  Optional<Boolean> multipleExpressionsInOneLine();

  Optional<Boolean> simpleBlocksInOneLine();

  Optional<Boolean> simpleMethodsInOneLine();

  Optional<Boolean> simpleLambdasInOneLine();

  Optional<Boolean> simpleClassesInOneLine();
}
