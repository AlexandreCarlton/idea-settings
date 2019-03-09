package com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java;

import com.github.alexandrecarlton.idea.settings.fixtures.JavapoetTestFixture;
import org.junit.Test;

public class JavaImportSettingsApplierTest extends JavapoetTestFixture {

  @Test
  public void testClassCountToUseImportWithWildcard() throws Exception {
    writeIdeaSettingsFile(
        "editor:",
        "  codeStyle:",
        "    java:",
        "      imports:",
        "        classCountToUseImportWithWildcard: 999");
    runIdeaSettings();
    assertThatXml(".idea/codeStyles/codeStyleConfig.xml")
        .valueByXPath("//option[@name='USE_PER_PROJECT_SETTINGS']/@value")
        .asBoolean()
        .isEqualTo(true);
    assertThatXml(".idea/codeStyles/Project.xml")
        .valueByXPath("//JavaCodeStyleSettings/option[@name='CLASS_COUNT_TO_USE_IMPORT_ON_DEMAND']/@value")
        .asInt()
        .isEqualTo(999);
  }

  @Test
  public void testNamesCountToUseStaticImportWithWildcard() throws Exception {
    writeIdeaSettingsFile(
        "editor:",
        "  codeStyle:",
        "    java:",
        "      imports:",
        "        namesCountToUseStaticImportWithWildcard: 999");
    runIdeaSettings();
    assertThatXml(".idea/codeStyles/codeStyleConfig.xml")
        .valueByXPath("//option[@name='USE_PER_PROJECT_SETTINGS']/@value")
        .asBoolean()
        .isEqualTo(true);
    assertThatXml(".idea/codeStyles/Project.xml")
        .valueByXPath("//JavaCodeStyleSettings/option[@name='NAMES_COUNT_TO_USE_IMPORT_ON_DEMAND']/@value")
        .asInt()
        .isEqualTo(999);
  }

}
