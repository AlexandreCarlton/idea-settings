package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler;

import com.github.alexandrecarlton.idea.settings.fixtures.JavapoetTestFixture;
import com.github.alexandrecarlton.idea.settings.starter.Main;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.xmlunit.assertj.XmlAssert.assertThat;

public class CompilerSettingsApplierTest extends JavapoetTestFixture {

  @Test
  public void testBuildProcessHeapSize() throws Exception {
    Files.write(javapoet.resolve(".IDEA-settings.yml"), ImmutableList.of(
        "buildExecutionDeployment:",
        "  compiler:",
        "    buildProcessHeapSizeMbytes: 1234"));
    Main.run(javapoet.toAbsolutePath().toString());
    final Path compilerXml = javapoet.resolve(".idea").resolve("compiler.xml");
    System.out.println(String.join("\n", Files.readAllLines(compilerXml)));
    assertThat(String.join("\n", Files.readAllLines(compilerXml)))
        .valueByXPath("//component[@name='CompilerConfiguration']/option[@name='BUILD_PROCESS_HEAP_SIZE']/@value")
        .asInt()
        .isEqualTo(1234);
  }
}