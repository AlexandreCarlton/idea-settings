package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment;

import com.github.alexandrecarlton.idea.settings.fixtures.JavapoetTestFixture;
import org.junit.Test;

import java.nio.file.Files;

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

}