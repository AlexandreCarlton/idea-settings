package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java;

import com.github.alexandrecarlton.idea.settings.fixtures.JavapoetTestFixture;
import com.github.alexandrecarlton.idea.settings.starter.Main;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.xmlunit.assertj.XmlAssert.assertThat;

public class JavaImportSettingsApplierTest extends JavapoetTestFixture {

  @Test
  public void testClassCountToUseImportWithWildcard() throws Exception {
    Files.write(javapoet.resolve(".IDEA-settings.yml"), ImmutableList.of(
        "editor:",
        "  codeStyle:",
        "    java:",
        "      imports:",
        "        classCountToUseImportWithWildcard: 999"));
    Main.run(javapoet.toAbsolutePath().toString());
    final Path projectXml = javapoet.resolve(".idea").resolve("codeStyles").resolve("Project.xml");
    assertThat(String.join("\n", Files.readAllLines(projectXml)))
        .valueByXPath("//JavaCodeStyleSettings/option[@name='CLASS_COUNT_TO_USE_IMPORT_ON_DEMAND']/@value")
        .asInt()
        .isEqualTo(999);
  }

  @Test
  public void testNamesCountToUseStaticImportWithWildcard() throws Exception {
    Files.write(javapoet.resolve(".IDEA-settings.yml"), ImmutableList.of(
        "editor:",
        "  codeStyle:",
        "    java:",
        "      imports:",
        "        namesCountToUseStaticImportWithWildcard: 999"));
    Main.run(javapoet.toAbsolutePath().toString());
    final Path projectXml = javapoet.resolve(".idea").resolve("codeStyles").resolve("Project.xml");
    assertThat(String.join("\n", Files.readAllLines(projectXml)))
        .valueByXPath("//JavaCodeStyleSettings/option[@name='NAMES_COUNT_TO_USE_IMPORT_ON_DEMAND']/@value")
        .asInt()
        .isEqualTo(999);
  }

}