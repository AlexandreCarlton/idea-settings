package com.github.alexandrecarlton.idea.settings.fixtures;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * A base test class to set up Javapoet for settings configuration.
 */
public abstract class JavapoetTestFixture {

  @Rule
  public TemporaryFolder temporaryFolder = new TemporaryFolder();

  protected Path javapoet;

  @Before
  public void setUp() throws IOException {
    final String javapoetPomLocation = requireNonNull(System.getProperty("javapoet.pom"));
    final Path originalJavaPoet = Paths.get(javapoetPomLocation).getParent();
    javapoet = temporaryFolder.newFolder().toPath().resolve("javapoet");
    assertThat(javapoet).doesNotExist();
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
}
