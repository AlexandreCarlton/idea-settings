package com.github.alexandrecarlton.idea.settings.integration;

import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * An integration test that loads up an entire project first, and then verifies the output in
 * individual tests.
 * These tests share (read-only) state as importing a real project for every test is both memory-
 * and time-intensive.
 */
public class JavapoetIntegrationTest extends AbstractIntegrationTest {

  private static Path javapoet;

  @BeforeClass
  public static void setUpClass() throws IOException, InterruptedException {
    AbstractIntegrationTest.setUpClass("javapoet",
        "projectSettings:",
        "  project:",
        "    projectName: my-project-name",
        "    projectSdk: my-project-sdk",
        "    projectLanguageLevel: '6'",
        "",
        "buildExecutionDeployment:",
        "  buildTools:",
        "    maven:",
        "      importing:",
        "        vmOptionsForImporter: -Xmx1g",
        "      mavenHomeDirectory: maven-bin",
        "  compiler:",
        "    addRuntimeAssertionsForNotnullAnnotatedMethodsAndParameters: false",
        "    buildProcessHeapSizeMbytes: 1234",
        "    compileIndependentModulesInParallel: true",
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
        "        file: checkstyle.xml",
        "",
        "configurations:",
        "  remote:",
        "    - name: Remote Configuration",
        "      configuration:",
        "        host: 8.8.8.8",
        "        port: 5000");

    driver.copyDirectoryFromRunfiles("maven-bin", "");
    Files.move(
        driver.currentWorkspace().resolve("maven-bin"),
        driver.currentWorkspace().resolve("javapoet/maven-bin"));

    driver.scratchFile("javapoet/dict.dic");

    runIdeaSettings();
    javapoet = path;
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
  public void compileIndependentModulesInParallel() throws IOException {
    assertThatXml(".idea/workspace.xml")
        .valueByXPath("//component[@name='CompilerWorkspaceConfiguration']/option[@name='PARALLEL_COMPILATION']/@value")
        .asBoolean()
        .isTrue();
  }

  @Test
  public void vmOptionsForImporter() throws IOException {
    assertThatXml(".idea/workspace.xml")
        .valueByXPath("//MavenImportingSettings/option[@name='vmOptionsForImporter']/@value")
        .isEqualTo("-Xmx1g");
  }

  @Test
  public void mavenHome() throws IOException {
    assertThatXml(".idea/workspace.xml")
        .valueByXPath("//MavenGeneralSettings/option[@name='mavenHome']/@value")
        .isEqualTo("$PROJECT_DIR$/maven-bin");
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

  @Test
  public void checkRemoteConfigurationHost() throws IOException {
    assertThatXml(".idea/runConfigurations/Remote_Configuration.xml")
        .valueByXPath("//configuration[@name='Remote Configuration']/option[@name='HOST']/@value")
        .isEqualTo("8.8.8.8");
  }

  @Test
  public void checkRemoteConfigurationPort() throws IOException {
    assertThatXml(".idea/runConfigurations/Remote_Configuration.xml")
        .valueByXPath("//configuration[@name='Remote Configuration']/option[@name='PORT']/@value")
        .isEqualTo("5000");
  }

}
