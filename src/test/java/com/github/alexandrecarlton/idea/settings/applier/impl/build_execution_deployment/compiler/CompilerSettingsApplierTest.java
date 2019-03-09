package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler;

import com.github.alexandrecarlton.idea.settings.fixtures.JavapoetTestFixture;
import org.junit.Test;

public class CompilerSettingsApplierTest extends JavapoetTestFixture {

  @Test
  public void testBuildProcessHeapSize() throws Exception {
    writeIdeaSettingsFile(
        "buildExecutionDeployment:",
        "  compiler:",
        "    buildProcessHeapSizeMbytes: 1234");
    runIdeaSettings();
    assertThatXml(".idea/compiler.xml")
        .valueByXPath("//component[@name='CompilerConfiguration']/option[@name='BUILD_PROCESS_HEAP_SIZE']/@value")
        .asInt()
        .isEqualTo(1234);
  }
}