package com.github.alexandrecarlton.idea.settings.integration;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;

/**
 * An integration test primarily designed to test module addition and modification.
 */
public class AutoIntegrationTest extends AbstractIntegrationTest {

  private static Path auto;

  @BeforeClass
  public static void setUpClass() throws IOException, InterruptedException {
    AbstractIntegrationTest.setUpClass("auto",
        "Project Settings:",
        "  Modules:",
        "    - Name: auto-parent",
        "      Sources:",
        "        - Content Root: .",
        "          Excluded:" ,
        "            - README.md",
        "    - Name: common",
        "      Sources:",
        "        - Content Root: common",
        "          Sources:",
        "            - src/main/java",
        "          Tests:",
        "            - src/test/java");
    runIdeaSettings();
    auto = path;
  }

  @Test
  public void testExcludeFileOnExistingModule() throws IOException {
    assertThatXml("auto-parent.iml")
        .hasXPath("//content[@url='file://$MODULE_DIR$']/excludeFolder[@url='file://$MODULE_DIR$/README.md']");
  }

  @Test
  public void testCreatedModule() throws IOException {
    assertThatXml("common/common.iml")
        .hasXPath("//content[@url='file://$MODULE_DIR$']/sourceFolder[@url='file://$MODULE_DIR$/src/main/java'][@isTestSource='false']");
    assertThatXml("common/common.iml")
        .hasXPath("//content[@url='file://$MODULE_DIR$']/sourceFolder[@url='file://$MODULE_DIR$/src/test/java'][@isTestSource='true']");
  }

}
