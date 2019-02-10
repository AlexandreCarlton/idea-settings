package io.github.alexandrecarlton.iml.generation;

import com.intellij.ide.plugins.PluginManager;
import com.intellij.idea.IdeaApplication;

import javax.swing.SwingUtilities;

public class MainImpl {
  private MainImpl() {}

  /**
   * Called from PluginManager via reflection.
   */
  protected static void start(final String... args) {
    IdeaApplication app = new ImlGenerationIdeaApplication(args);
    SwingUtilities.invokeLater(() -> {
      PluginManager.installExceptionHandler();
      app.run();
      // IntelliJ hangs here so we force a clean exit.
      System.exit(0);
    });
  }
}
