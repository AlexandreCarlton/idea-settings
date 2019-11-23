package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement.JavaArrangementSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.JavaBlankLinesSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.imports.JavaImportsSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc.JavadocSettings;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableJavaCodeStyleSettings.class)
public interface JavaCodeStyleSettings {

  Optional<JavaArrangementSettings> arrangement();

  Optional<JavaBlankLinesSettings> blankLines();

  Optional<JavaImportsSettings> imports();

  Optional<JavadocSettings> javadoc();

}
