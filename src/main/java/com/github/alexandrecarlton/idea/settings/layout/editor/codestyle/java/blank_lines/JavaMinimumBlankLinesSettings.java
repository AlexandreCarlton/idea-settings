package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavaMinimumBlankLinesSettings.class)
public interface JavaMinimumBlankLinesSettings {

  Optional<Integer> beforePackageStatement();

  Optional<Integer> afterPackageStatement();

  Optional<Integer> beforeImports();

  Optional<Integer> afterImports();

  Optional<Integer> aroundClass();

  Optional<Integer> afterClassHeader();

  Optional<Integer> beforeClassEnd();

  Optional<Integer> afterAnonymousClassHeader();

  Optional<Integer> aroundFieldInInterface();

  Optional<Integer> aroundField();

  Optional<Integer> aroundMethodInInterface();

  Optional<Integer> aroundMethod();

  Optional<Integer> beforeMethodBody();

  Optional<Integer> aroundInitializer();
}
