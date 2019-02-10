package io.github.alexandrecarlton.iml.generation;

import com.intellij.ide.impl.ProjectUtil;
import com.intellij.openapi.application.ApplicationStarter;
import com.intellij.openapi.application.ex.ApplicationEx;
import com.intellij.openapi.application.ex.ApplicationManagerEx;
import com.intellij.openapi.project.Project;

public class ImlGenerationStarter implements ApplicationStarter {

  @Override
  public String getCommandName() {
    return "generate-iml";
  }

  @Override
  public void premain(String... args) {
  }

  @Override
  public void main(String... args) {
    ApplicationEx application = ApplicationManagerEx.getApplicationEx();
    application.setSaveAllowed(true);
    application.runWriteAction(() -> {
      Project project = ProjectUtil.openOrImport(args[0], null, false);
      project.save();
    });
  }
}
