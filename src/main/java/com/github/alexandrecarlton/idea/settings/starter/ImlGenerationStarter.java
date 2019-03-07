package com.github.alexandrecarlton.idea.settings.starter;

import com.intellij.openapi.application.ApplicationStarter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    if (args.length < 1) {
      throw new IllegalArgumentException("Please supply the path to the project.");
    }
    Path path = Paths.get(args[0]);
    if (!Files.exists(path)) {
      throw new IllegalArgumentException("Please supply a valid path to the project.");
    }
    ImlGenerator generator = new ImlGenerator();
    generator.generate(path);
  }
}
