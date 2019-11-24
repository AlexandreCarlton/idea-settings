package com.github.alexandrecarlton.idea.settings.fixtures;

import com.intellij.openapi.project.Project;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * Helper class to allow the test to run with JUnit 4.
 */
@RunWith(JUnit4.class)
public class IdeaSettingsTestFixture extends BasePlatformTestCase {

  @Rule
  public final MockitoRule mockitoRule = MockitoJUnit.rule();

  @Rule
  public TemporaryFolder temporaryFolder = new TemporaryFolder(Paths.get("/tmp").toFile());

  protected Project project;

  @Before
  public void setUpIdeaSettingsTestFixture() throws Exception {
    System.setProperty("idea.config.path", temporaryFolder.newFolder("idea", "config").toString());
    System.setProperty("idea.system.path", temporaryFolder.newFolder("idea", "system").toString());

    super.setUp();

    project = myFixture.getProject();
  }

  @After
  public void tearDownIdeaSettingsTestFixture() throws Exception {
    super.tearDown();
  }

}
