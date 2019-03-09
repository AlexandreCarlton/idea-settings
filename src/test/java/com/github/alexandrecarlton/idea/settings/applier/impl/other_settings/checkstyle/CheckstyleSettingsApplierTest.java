package com.github.alexandrecarlton.idea.settings.applier.impl.other_settings.checkstyle;

import com.github.alexandrecarlton.idea.settings.fixtures.JavapoetTestFixture;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class CheckstyleSettingsApplierTest extends JavapoetTestFixture {

  @Test
  public void testCheckstyleVersion() throws Exception {
    writeIdeaSettingsFile(
        "otherSettings:",
        "  checkstyle:",
        "    checkstyleVersion: '8.16'");
    runIdeaSettings();
    assertThatXml(".idea/checkstyle-idea.xml")
        .valueByXPath("//entry[@key='checkstyle-version']/@value")
        .isEqualTo("8.16");
  }
  @Test
  public void testScanScope() throws Exception {
    writeIdeaSettingsFile(
        "otherSettings:",
        "  checkstyle:",
        "    scanScope: Only Java sources (including tests)");
    runIdeaSettings();
    assertThatXml(".idea/checkstyle-idea.xml")
        .valueByXPath("//entry[@key='scanscope']/@value")
        .isEqualTo("JavaOnlyWithTests");
  }

  @Test
  public void testTreatCheckstyleErrorsAsWarnings() throws Exception {
    writeIdeaSettingsFile(
        "otherSettings:",
        "  checkstyle:",
        "    treatCheckstyleErrorsAsWarnings: true");
    runIdeaSettings();
    assertThatXml(".idea/checkstyle-idea.xml")
        .valueByXPath("//entry[@key='suppress-errors']/@value")
        .asBoolean()
        .isEqualTo(true);
  }

  @Test
  public void testLocalConfigurationFile() throws Exception {
    writeIdeaSettingsFile(
        "otherSettings:",
        "  checkstyle:",
        "    configurationFiles:",
        "      - active: true",
        "        description: Javapoet Checkstyle",
        "        file: checkstyle.xml");
    runIdeaSettings();
    assertThatXml(".idea/checkstyle-idea.xml")
        .valueByXPath("//entry[@key='active-configuration']/@value")
        .isEqualTo("PROJECT_RELATIVE:$PROJECT_DIR$/checkstyle.xml:Javapoet Checkstyle");
  }

  @Test
  public void testBundledConfigurationFile() throws Exception {
    writeIdeaSettingsFile(
        "otherSettings:",
        "  checkstyle:",
        "    configurationFiles:",
        "      - active: true",
        "        description: Google Checks",
        "        file: bundled");
    runIdeaSettings();
    assertThatXml(".idea/checkstyle-idea.xml")
        .valueByXPath("//entry[@key='active-configuration']/@value")
        .isEqualTo("BUNDLED:(bundled):Google Checks");
  }

}
