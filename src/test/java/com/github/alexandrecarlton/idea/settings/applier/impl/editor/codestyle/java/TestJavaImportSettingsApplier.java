package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java;

import com.github.alexandrecarlton.idea.settings.starter.Main;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.util.Objects.requireNonNull;
import static org.xmlunit.assertj.XmlAssert.assertThat;

public class TestJavaImportSettingsApplier {

  @Rule
  public TemporaryFolder temporaryFolder = new TemporaryFolder();

  private Path javapoet;

  @Before
  public void setUp() throws IOException {
    final String javapoetPomLocation = requireNonNull(System.getProperty("javapoet.pom"));
    final Path originalJavaPoet = Paths.get(javapoetPomLocation).getParent();
    javapoet = temporaryFolder.newFolder().toPath().resolve("javapoet");
    Files
        .walk(originalJavaPoet)
        .forEach(source -> {
          try {
            Files.copy(source, javapoet.resolve(originalJavaPoet.relativize(source)));
          } catch (IOException e) {
            throw new UncheckedIOException(e);
          }
        });
  }

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

}