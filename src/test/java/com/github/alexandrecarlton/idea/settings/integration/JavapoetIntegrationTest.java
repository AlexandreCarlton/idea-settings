package com.github.alexandrecarlton.idea.settings.integration;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xmlunit.assertj.XmlAssert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import build.bazel.tests.integration.WorkspaceDriver;

/**
 * An integration test that loads up an entire project first, and then verifies the output in
 * individual tests.
 * These tests share (read-only) state as importing a real project for every test is both memory-
 * and time-intensive.
 */
public class JavapoetIntegrationTest {

  private static final WorkspaceDriver driver = new WorkspaceDriver();
  private static Path javapoet;

  @BeforeClass
  public static void setUpClass() throws IOException, InterruptedException {
    WorkspaceDriver.setUpClass();
    driver.setUp();

    driver.copyFromRunfiles("idea_settings/apply-idea-settings.sh", "apply-idea-settings.sh");
    driver.copyFromRunfiles("idea_settings/plugins.tar", "plugins.tar");
    driver.copyFromRunfiles("idea-IC/bin/idea.sh", "idea-IC/bin/idea.sh");
    driver.copyFromRunfiles("idea-IC/bin/linux/idea64.vmoptions", "idea-IC/bin/linux/idea64.vmoptions");
    driver.copyDirectoryFromRunfiles("javapoet", "");

    driver.scratchFile("BUILD",
        "sh_binary(",
        "    name = \"apply-idea-settings\",",
        "    srcs = [\"apply-idea-settings.sh\"],",
        "    data = [",
        "        \"plugins.tar\",",
        "        \"idea-IC/bin/idea.sh\",",
        "        \"idea-IC/bin/linux/idea64.vmoptions\",",
        "    ],",
        "    deps = [\"@bazel_tools//tools/bash/runfiles\"],",
        ")");
    javapoet = driver.currentWorkspace().resolve("javapoet");

    driver.scratchFile("javapoet/.IDEA-settings.yml",
        "projectSettings:",
        "  project:",
        "    projectName: my-project-name",
        "    projectSdk: my-project-sdk",
        "    projectLanguageLevel: '6'",
        "",
        "buildExecutionDeployment:",
        "  compiler:",
        "    addRuntimeAssertionsForNotnullAnnotatedMethodsAndParameters: false",
        "    buildProcessHeapSizeMbytes: 1234",
        "  requiredPlugins:",
        "    - plugin: CheckStyle-IDEA",
        "      minimumVersion: 5.23.0",
        "      maximumVersion: 5.24.1",
        "editor:",
        "  codeStyle:",
        "    java:",
        "      imports:",
        "        classCountToUseImportWithWildcard: 123",
        "        namesCountToUseStaticImportWithWildcard: 456",
        "  general:",
        "    autoImport:",
        "      java:",
        "        optimizeImportsOnTheFly: true",
        "        excludeFromImportAndCompletion:",
        "          - com.google.inject.Inject",
        "          - com.sun.istack.internal.Nullable",
        "  spelling:",
        "    dictionaries:",
        "      - dict.dic",
        "otherSettings:",
        "  checkstyle:",
        "    checkstyleVersion: '8.16'",
        "    scanScope: Only Java sources (including tests)",
        "    treatCheckstyleErrorsAsWarnings: true",
        "    configurationFiles:",
        "      - active: true",
        "        description: Javapoet Checkstyle",
        "        file: checkstyle.xml");

    driver.bazel("run", "//:apply-idea-settings", javapoet.toString()).mustRunSuccessfully();
  }

  @Before
  public void setUp() throws IOException, InterruptedException {
  }

  @Test
  public void projectName() {
    Assertions.assertThat(javapoet.resolve(".idea/.name"))
        .hasContent("my-project-name");
  }

  @Test
  public void projectSdk() throws IOException {
    assertThatXml(".idea/misc.xml")
        .valueByXPath("//component[@name='ProjectRootManager']/@project-jdk-name")
        .isEqualTo("my-project-sdk");
  }

  @Test
  public void projectLanguageLevel() throws IOException {
    assertThatXml(".idea/misc.xml")
        .valueByXPath("//component[@name='ProjectRootManager']/@languageLevel")
        .isEqualTo("JDK_1_6");
  }

  @Test
  public void buildProcessHeapSize() throws IOException {
    assertThatXml(".idea/compiler.xml")
        .valueByXPath("//component[@name='CompilerConfiguration']/option[@name='BUILD_PROCESS_HEAP_SIZE']/@value")
        .asInt()
        .isEqualTo(1234);
  }

  @Test
  public void addRuntimeAssertionsForNotnullAnnotatedMethodsAndParameters() throws IOException {
    assertThatXml(".idea/compiler.xml")
        .valueByXPath("//component[@name='CompilerConfiguration']/addNotNullAssertions/@enabled")
        .asBoolean()
        .isEqualTo(false);
  }

  @Test
  public void requiredPlugins() throws IOException {
    assertThatXml(".idea/externalDependencies.xml")
        .hasXPath("//component[@name='ExternalDependencies']/plugin[@id='CheckStyle-IDEA']");
  }

  @Test
  public void requiredPluginsMinimumVersion() throws IOException {
    assertThatXml(".idea/externalDependencies.xml")
        .valueByXPath("//component[@name='ExternalDependencies']/plugin[@id='CheckStyle-IDEA']/@min-version")
        .isEqualTo("5.23.0");
  }

  @Test
  public void requiredPluginsMaximumVersion() throws IOException {
    assertThatXml(".idea/externalDependencies.xml")
          .valueByXPath("//component[@name='ExternalDependencies']/plugin[@id='CheckStyle-IDEA']/@max-version")
          .isEqualTo("5.24.1");
  }

  /**
   * This should be set implicitly when setting any codestyle setting.
   */
  @Test
  public void usePerProjectSettings() throws IOException {
    assertThatXml(".idea/codeStyles/codeStyleConfig.xml")
        .valueByXPath("//option[@name='USE_PER_PROJECT_SETTINGS']/@value")
        .asBoolean()
        .isEqualTo(true);
  }

  @Test
  public void classCountToUseImportWithWildcard() throws IOException {
    assertThatXml(".idea/codeStyles/Project.xml")
        .valueByXPath("//JavaCodeStyleSettings/option[@name='CLASS_COUNT_TO_USE_IMPORT_ON_DEMAND']/@value")
        .asInt()
        .isEqualTo(123);
  }

  @Test
  public void namesCountToUseStaticImportWithWildcard() throws IOException {
    assertThatXml(".idea/codeStyles/Project.xml")
        .valueByXPath("//JavaCodeStyleSettings/option[@name='NAMES_COUNT_TO_USE_IMPORT_ON_DEMAND']/@value")
        .asInt()
        .isEqualTo(456);
  }

  @Test
  public void optimizeImportsOnTheFly() throws IOException {
    assertThatXml(".idea/workspace.xml")
        .valueByXPath("//component[@name='CodeInsightWorkspaceSettings']/option[@name='optimizeImportsOnTheFly']/@value")
        .asBoolean()
        .isTrue();
  }

  @Test
  public void excludeFromImportAndCompletion() throws IOException {
    assertThatXml(".idea/codeInsightSettings.xml")
        .hasXPath("//component[@name='JavaProjectCodeInsightSettings']/excluded-names/name[text()='com.google.inject.Inject']");
    assertThatXml(".idea/codeInsightSettings.xml")
        .hasXPath("//component[@name='JavaProjectCodeInsightSettings']/excluded-names/name[text()='com.sun.istack.internal.Nullable']");
  }

  @Test
  public void dictionaryRelativeToProject() throws IOException {
    assertThatXml(".idea/workspace.xml")
        .valueByXPath("//component[@name='SpellCheckerSettings']/@CustomDictionary0")
        .asString()
        .isEqualTo("$PROJECT_DIR$/dict.dic");
  }

  @Test
  public void checkstyleVersion() throws IOException {
    assertThatXml(".idea/checkstyle-idea.xml")
        .valueByXPath("//entry[@key='checkstyle-version']/@value")
        .isEqualTo("8.16");
  }

  @Test
  public void checkstyleScanScope() throws IOException {
    assertThatXml(".idea/checkstyle-idea.xml")
        .valueByXPath("//entry[@key='scanscope']/@value")
        .isEqualTo("JavaOnlyWithTests");
  }

  @Test
  public void checkstyleTreatCheckstyleErrorsAsWarnings() throws IOException {
    assertThatXml(".idea/checkstyle-idea.xml")
        .valueByXPath("//entry[@key='suppress-errors']/@value")
        .asBoolean()
        .isTrue();
  }

  @Test
  public void checkstyleLocalConfigurationFile() throws IOException {
    assertThatXml(".idea/checkstyle-idea.xml")
        .valueByXPath("//entry[@key='active-configuration']/@value")
        .isEqualTo("PROJECT_RELATIVE:$PROJECT_DIR$/checkstyle.xml:Javapoet Checkstyle");
  }

  private XmlAssert assertThatXml(String file) throws IOException {
    final Path path = javapoet.resolve(file);
    Assertions.assertThat(path).exists();
    final String pathContent = String.join("\n", Files.readAllLines(path));
    System.out.println("Content of " + path + " is:");
    System.out.println(pathContent);
    return XmlAssert.assertThat(pathContent);
  }

}
