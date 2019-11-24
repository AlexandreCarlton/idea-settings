package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaCodeStyleSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement.JavaArrangementSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.JavaBlankLinesSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.imports.JavaImportsSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc.JavadocSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces.JavaWrappingAndBracesSettings;
import javax.inject.Inject;

public class JavaCodeStyleSettingsApplier implements SettingsApplier<JavaCodeStyleSettings> {

  private final SettingsApplier<JavaArrangementSettings> javaArrangementSettingsApplier;
  private final SettingsApplier<JavaBlankLinesSettings> javaBlankLinesSettingsApplier;
  private final SettingsApplier<JavaImportsSettings> javaImportsSettingsApplier;
  private final SettingsApplier<JavadocSettings> javadocSettingsApplier;
  private final SettingsApplier<JavaWrappingAndBracesSettings> javaWrappingAndBracesSettingsApplier;

  @Inject
  public JavaCodeStyleSettingsApplier(SettingsApplier<JavaArrangementSettings> javaArrangementSettingsApplier,
                                      SettingsApplier<JavaBlankLinesSettings> javaBlankLinesSettingsApplier,
                                      SettingsApplier<JavaImportsSettings> javaImportsSettingsApplier,
                                      SettingsApplier<JavadocSettings> javadocSettingsApplier,
                                      SettingsApplier<JavaWrappingAndBracesSettings> javaWrappingAndBracesSettingsApplier) {
    this.javaArrangementSettingsApplier = javaArrangementSettingsApplier;
    this.javaBlankLinesSettingsApplier = javaBlankLinesSettingsApplier;
    this.javaImportsSettingsApplier = javaImportsSettingsApplier;
    this.javadocSettingsApplier = javadocSettingsApplier;
    this.javaWrappingAndBracesSettingsApplier = javaWrappingAndBracesSettingsApplier;
  }

  public void apply(JavaCodeStyleSettings settings) {
    settings.arrangement().ifPresent(javaArrangementSettingsApplier::apply);
    settings.blankLines().ifPresent(javaBlankLinesSettingsApplier::apply);
    settings.imports().ifPresent(javaImportsSettingsApplier::apply);
    settings.javadoc().ifPresent(javadocSettingsApplier::apply);
    settings.wrappingAndBraces().ifPresent(javaWrappingAndBracesSettingsApplier::apply);
  }
}
