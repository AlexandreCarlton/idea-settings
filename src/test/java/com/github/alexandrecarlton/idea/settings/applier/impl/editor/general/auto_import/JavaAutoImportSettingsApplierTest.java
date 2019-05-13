package com.github.alexandrecarlton.idea.settings.applier.impl.editor.general.auto_import;

import com.github.alexandrecarlton.idea.settings.fixtures.JavapoetTestFixture;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import static org.junit.Assert.*;

public class JavaAutoImportSettingsApplierTest extends JavapoetTestFixture {

  @Test
  public void testOptimizeImportsOnTheFly() throws Exception {
    writeIdeaSettingsFile(
        "editor:",
        "  general:",
        "    autoImport:",
        "      java:",
        "        optimizeImportsOnTheFly: true");
    runIdeaSettings();
    assertThatXml(".idea/workspace.xml")
        .valueByXPath("//component[@name='CodeInsightWorkspaceSettings']/option[@name='optimizeImportsOnTheFly']/@value")
        .asBoolean()
        .isTrue();
  }
  @Test
  public void testExcludeFromImportAndCompletion() throws Exception {
    writeIdeaSettingsFile(
        "editor:",
        "  general:",
        "    autoImport:",
        "      java:",
        "        excludeFromImportAndCompletion:",
        "          - com.google.inject.Inject",
        "          - com.sun.istack.internal.Nullable");
    runIdeaSettings();
    // Xmlunit does not appear to support asList() in the way one would expect.
    assertThatXml(".idea/codeInsightSettings.xml")
        .hasXPath("//component[@name='JavaProjectCodeInsightSettings']/excluded-names/name[text()='com.google.inject.Inject']");
    assertThatXml(".idea/codeInsightSettings.xml")
        .hasXPath("//component[@name='JavaProjectCodeInsightSettings']/excluded-names/name[text()='com.sun.istack.internal.Nullable']");
  }

}
