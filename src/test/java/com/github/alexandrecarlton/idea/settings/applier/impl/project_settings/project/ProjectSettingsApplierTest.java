package com.github.alexandrecarlton.idea.settings.applier.impl.project_settings.project;

import com.github.alexandrecarlton.idea.settings.fixtures.JavapoetTestFixture;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProjectSettingsApplierTest extends JavapoetTestFixture {

  @Test
  public void testProjectName() throws Exception {
    writeIdeaSettingsFile(
        "projectSettings:",
        "  project:",
        "    projectName: my-project-name");
    runIdeaSettings();
    assertThat(javapoet.resolve(".idea/.name")).hasContent("my-project-name");
  }

  @Test
  public void testProjectSdk() throws Exception {
    writeIdeaSettingsFile(
        "projectSettings:",
        "  project:",
        "    projectSdk: my-project-sdk");
    runIdeaSettings();
    assertThatXml(".idea/misc.xml")
        .valueByXPath("//component[@name='ProjectRootManager']/@project-jdk-name")
        .isEqualTo("my-project-sdk");
  }

  @Test
  public void testProjectLanguageLevel() throws Exception {
    writeIdeaSettingsFile(
        "projectSettings:",
        "  project:",
        "    projectLanguageLevel: '6'");
    runIdeaSettings();
    assertThatXml(".idea/misc.xml")
        .valueByXPath("//component[@name='ProjectRootManager']/@languageLevel")
        .isEqualTo("JDK_1_6");
  }

}
