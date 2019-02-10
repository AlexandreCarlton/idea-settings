package io.github.alexandrecarlton.iml.generation;

import com.intellij.ide.Bootstrap;

class Main {
  public static void main(String... args) {
    // Ensures that IntelliJ knows we are running in headless mode.
    System.setProperty("java.awt.headless", Boolean.TRUE.toString());
    // Necessary for IntelliJ to know it's running as the "CommunityEdition"
    System.setProperty("idea.platform.prefix", "Idea");
    // Verify that we have a working JRE (failing early otherwise).
    System.setProperty("idea.jre.check", Boolean.TRUE.toString());

    // Enforce that Main#isHeadless returns true.
    String[] emptyArgs = {};
    com.intellij.idea.Main.setFlags(emptyArgs);

    try {
      // Using Bootstrap to launch MainImpl#start allows us to set up the classpath correctly.
      Bootstrap.main(args, MainImpl.class.getName(), "start");
    } catch (Throwable t) {
      System.out.println("Start Failed.");
      System.exit(1);
    }
  }
}
