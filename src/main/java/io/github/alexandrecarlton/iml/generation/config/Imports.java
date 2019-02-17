package io.github.alexandrecarlton.iml.generation.config;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.intellij.openapi.project.Project;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.JavaCodeStyleSettings;

import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableImports.class)
public interface Imports {
  Optional<Integer> classCountToUseImportWithWildcard();
  Optional<Integer> namesCountToUseStaticImportWithWildcard();

  default void configure(Project project) {
    CodeStyleSettings codeStyleSettings = com.intellij.application.options.CodeStyle.getSettings(project);
    JavaCodeStyleSettings javaCodeStyleSettings = codeStyleSettings.getCustomSettings(JavaCodeStyleSettings.class);
    classCountToUseImportWithWildcard().ifPresent(javaCodeStyleSettings::setClassCountToUseImportOnDemand);
    namesCountToUseStaticImportWithWildcard().ifPresent(javaCodeStyleSettings::setNamesCountToUseImportOnDemand);
    com.intellij.application.options.CodeStyle.setMainProjectSettings(project, codeStyleSettings);
  }
}
