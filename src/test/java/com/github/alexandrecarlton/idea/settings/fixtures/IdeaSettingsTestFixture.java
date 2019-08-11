package com.github.alexandrecarlton.idea.settings.fixtures;

import com.intellij.openapi.project.Project;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * Helper method to allow the test to run with JUnit 4.
 */
@RunWith(JUnit4.class)
public class IdeaSettingsTestFixture extends BasePlatformTestCase {

  @Rule
  public final MockitoRule mockitoRule = MockitoJUnit.rule();

  static {
    // TODO: Use a separate sandboxed path for each test invocation.
    System.setProperty("idea.config.path", "/tmp/idea-config-path");
    System.setProperty("idea.system.path", "/tmp/idea-system-path");
  }

  protected Project project;

  @Before
  @Override
  public void setUp() throws Exception {
    super.setUp();
    project = myFixture.getProject();
  }

  @After
  @Override
  public void tearDown() throws Exception {
    super.tearDown();
  }

}
