package com.github.alexandrecarlton.idea.settings.starter;

import com.intellij.ide.Bootstrap;
import com.intellij.openapi.application.ex.ApplicationManagerEx;

public class Main {

  private static final String IDEA_MAIN_THREAD_NAME = "Idea Main Thread";

  public static void main(String... args) {
    int exitCode = 0;
    try {
      run(args);
    } catch (Throwable t) {
      System.out.println(t.getMessage());
      exitCode = 1;
    } finally {
      System.exit(exitCode);
    }
  }

  /**
   * The main method that does not call {@link System#exit} to allow for testing.
   */
  public static void run(String... args) throws Exception {
    // Ensures that IntelliJ knows we are running in headless mode.
    System.setProperty("java.awt.headless", Boolean.TRUE.toString());
    // Necessary for IntelliJ to know it's running as the "CommunityEdition"
    System.setProperty("idea.platform.prefix", "Idea");
    // Verify that we have a working JRE (failing early otherwise).
    System.setProperty("idea.jre.check", Boolean.TRUE.toString());

    // Enforce that Main#isHeadless returns true.
    com.intellij.idea.Main.setFlags(new String[]{});
    // Using Bootstrap to launch MainImpl#start allows us to set up the classpath correctly.
    Bootstrap.main(args, MainImpl.class.getName(), "start");
    waitForIdeaMainThread();
  }

  /**
   * Forces the application to wait for IDEA to finish importing the project and generating files;
   * this is useful when writing tests.
   */
  private static void waitForIdeaMainThread() {
    Thread
        .getAllStackTraces()
        .keySet()
        .stream()
        .filter(t -> IDEA_MAIN_THREAD_NAME.equals(t.getName()))
        .findFirst()
        .ifPresent(thread -> {
          try {
            thread.join();
          } catch (InterruptedException e) {
            System.out.println(e.getMessage());
          }
        });
  }
}
