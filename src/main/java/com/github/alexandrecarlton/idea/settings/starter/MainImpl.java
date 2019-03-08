package com.github.alexandrecarlton.idea.settings.starter;

import com.intellij.ide.plugins.PluginManager;
import com.intellij.idea.IdeaApplication;

import javax.swing.SwingUtilities;
import java.lang.reflect.InvocationTargetException;

public class MainImpl {
  private MainImpl() {}

  /**
   * Called from PluginManager via reflection.
   */
  protected static void start(final String... args) throws InvocationTargetException, InterruptedException {
    IdeaApplication app = new IdeaSettingsIdeaApplication(args);
    SwingUtilities.invokeAndWait(() -> {
      PluginManager.installExceptionHandler();
      app.run();
    });
  }
}
