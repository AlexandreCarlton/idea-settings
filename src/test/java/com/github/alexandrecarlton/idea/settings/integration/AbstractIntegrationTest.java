package com.github.alexandrecarlton.idea.settings.integration;

import org.assertj.core.api.Assertions;
import org.xmlunit.assertj.XmlAssert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import build.bazel.tests.integration.WorkspaceDriver;

public class AbstractIntegrationTest {

  protected static final WorkspaceDriver driver = new WorkspaceDriver();
  protected static Path path;

  public static void setUpClass(String project, String... ideaSettings) throws IOException, InterruptedException {
    WorkspaceDriver.setUpClass();
    driver.setUp();

    driver.copyFromRunfiles("idea_settings/apply-idea-settings.sh", "apply-idea-settings.sh");
    driver.copyFromRunfiles("idea_settings/plugins.tar", "plugins.tar");
    driver.copyFromRunfiles("idea-IC/bin/idea.sh", "idea-IC/bin/idea.sh");
    driver.copyFromRunfiles("idea-IC/bin/linux/idea64.vmoptions",
        "idea-IC/bin/linux/idea64.vmoptions");
    driver.copyDirectoryFromRunfiles(project, "");

    driver.scratchFile("BUILD",
        "sh_binary(",
        "    name = \"apply-idea-settings\",",
        "    srcs = [\"apply-idea-settings.sh\"],",
        "    data = [",
        "        \"plugins.tar\",",
        "        \"idea-IC/bin/idea.sh\",",
        "        \"idea-IC/bin/linux/idea64.vmoptions\",",
        "    ],",
        "    deps = [\"@bazel_tools//tools/bash/runfiles\"],",
        ")");

    driver.scratchFile(project + "/.IDEA-settings.yml", ideaSettings);
    path = driver.currentWorkspace().resolve(project);
  }

  public static void runIdeaSettings() throws IOException, InterruptedException {
    driver.bazel("run", "//:apply-idea-settings", path.toString()).mustRunSuccessfully();
  }


  protected static XmlAssert assertThatXml(String file) throws IOException {
    final Path xml = path.resolve(file);
    Assertions.assertThat(xml).exists();
    final String xmlContent = String.join("\n", Files.readAllLines(xml));
    System.out.println("Content of " + xml + " is:");
    System.out.println(xmlContent);
    return XmlAssert.assertThat(xmlContent);
  }

}
