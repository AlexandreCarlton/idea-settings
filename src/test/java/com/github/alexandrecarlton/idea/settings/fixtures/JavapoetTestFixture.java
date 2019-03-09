package com.github.alexandrecarlton.idea.settings.fixtures;

import com.github.alexandrecarlton.idea.settings.starter.Main;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import org.xmlunit.assertj.XmlAssert;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

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

    // Corresponds to ~/.IdeaIC20XX.X/{config,system}, respectively.
    // We set these to empty folders to avoid contamination between tests.
    System.setProperty("idea.config.path", String.valueOf(temporaryFolder.newFolder("idea-config")));
    System.setProperty("idea.system.path", String.valueOf(temporaryFolder.newFolder("idea-system")));
  }

  protected void writeIdeaSettingsFile(String... lines) throws IOException {
    Files.write(javapoet.resolve(".IDEA-settings.yml"), Arrays.asList(lines));
  }

  protected void runIdeaSettings() throws Exception {
    Main.run(javapoet.toAbsolutePath().toString());
  }

  protected XmlAssert assertThatXml(String file) throws IOException {
    final Path path = javapoet.resolve(file);
    assertThat(path).exists();
    final String pathContent = String.join("\n", Files.readAllLines(path));
    System.out.println("Content of " + path + " is:");
    System.out.println(pathContent);
    return XmlAssert.assertThat(pathContent);
  }
}
