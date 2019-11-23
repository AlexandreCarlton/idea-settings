package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaCodeStyleSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement.JavaArrangementSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.JavaBlankLinesSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.imports.JavaImportsSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc.JavadocSettings;
import javax.inject.Inject;

public class JavaCodeStyleSettingsApplier implements SettingsApplier<JavaCodeStyleSettings> {

  private final SettingsApplier<JavaArrangementSettings> javaArrangementSettingsApplier;
  private final SettingsApplier<JavaBlankLinesSettings> javaBlankLinesSettingsApplier;
  private final SettingsApplier<JavaImportsSettings> javaImportsSettingsApplier;
  private final SettingsApplier<JavadocSettings> javadocSettingsApplier;

  @Inject
  public JavaCodeStyleSettingsApplier(SettingsApplier<JavaArrangementSettings> javaArrangementSettingsApplier,
                                      SettingsApplier<JavaBlankLinesSettings> javaBlankLinesSettingsApplier,
                                      SettingsApplier<JavaImportsSettings> javaImportsSettingsApplier,
                                      SettingsApplier<JavadocSettings> javadocSettingsApplier) {
    this.javaArrangementSettingsApplier = javaArrangementSettingsApplier;
    this.javaBlankLinesSettingsApplier = javaBlankLinesSettingsApplier;
    this.javaImportsSettingsApplier = javaImportsSettingsApplier;
    this.javadocSettingsApplier = javadocSettingsApplier;
  }

  public void apply(JavaCodeStyleSettings java) {
    java.arrangement().ifPresent(javaArrangementSettingsApplier::apply);
    java.blankLines().ifPresent(javaBlankLinesSettingsApplier::apply);
    java.imports().ifPresent(javaImportsSettingsApplier::apply);
    java.javadoc().ifPresent(javadocSettingsApplier::apply);
  }
}
