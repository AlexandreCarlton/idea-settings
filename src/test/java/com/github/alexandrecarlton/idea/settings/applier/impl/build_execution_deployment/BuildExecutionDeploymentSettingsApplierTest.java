package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment;

import com.github.alexandrecarlton.idea.settings.fixtures.JavapoetTestFixture;
import org.junit.Test;

public class BuildExecutionDeploymentSettingsApplierTest extends JavapoetTestFixture {

  @Test
  public void testRequiredPlugins() throws Exception {
    writeIdeaSettingsFile(
        "buildExecutionDeployment:",
        "  requiredPlugins:",
        "    - plugin: CheckStyle-IDEA");
    runIdeaSettings();
    assertThatXml(".idea/externalDependencies.xml")
        .hasXPath("//component[@name='ExternalDependencies']/plugin[@id='CheckStyle-IDEA']");
  }

  @Test
  public void testRequiredPluginsWithVersion() throws Exception {
    writeIdeaSettingsFile(
        "buildExecutionDeployment:",
        "  requiredPlugins:",
        "    - plugin: CheckStyle-IDEA",
        "      minimumVersion: 5.23.0",
        "      maximumVersion: 5.24.1");
    runIdeaSettings();
    assertThatXml(".idea/externalDependencies.xml")
        .valueByXPath("//component[@name='ExternalDependencies']/plugin[@id='CheckStyle-IDEA']/@min-version")
        .isEqualTo("5.23.0");
    assertThatXml(".idea/externalDependencies.xml")
        .valueByXPath("//component[@name='ExternalDependencies']/plugin[@id='CheckStyle-IDEA']/@max-version")
        .isEqualTo("5.24.1");
  }

}
