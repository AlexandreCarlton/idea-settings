package com.github.alexandrecarlton.idea.settings.applier.impl.editor.spelling;

import com.github.alexandrecarlton.idea.settings.fixtures.JavapoetTestFixture;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SpellingSettingsApplierTest extends JavapoetTestFixture {

  @Test
  public void testDictionaryRelativeToProject() throws Exception {
    writeIdeaSettingsFile(
        "editor:",
        "  spelling:",
        "    dictionaries:",
        "      - dict.dic");
    runIdeaSettings();
    assertThatXml(".idea/workspace.xml")
        .valueByXPath("//component[@name='SpellCheckerSettings']/@CustomDictionary0")
        .asString()
        .isEqualTo("$PROJECT_DIR$/dict.dic");
  }

  @Test
  public void testAbsoluteDictionary() throws Exception {
    writeIdeaSettingsFile(
        "editor:",
        "  spelling:",
        "    dictionaries:",
        "      - /tmp/dict.dic");
    runIdeaSettings();
    assertThatXml(".idea/workspace.xml")
        .valueByXPath("//component[@name='SpellCheckerSettings']/@CustomDictionary0")
        .asString()
        .isEqualTo("/tmp/dict.dic");
  }
}
