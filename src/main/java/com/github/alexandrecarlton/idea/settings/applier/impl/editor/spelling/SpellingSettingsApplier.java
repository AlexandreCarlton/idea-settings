package com.github.alexandrecarlton.idea.settings.applier.impl.editor.spelling;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.spelling.SpellingSettings;
import com.intellij.openapi.project.Project;
import com.intellij.spellchecker.settings.SpellCheckerSettings;

import javax.inject.Inject;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SpellingSettingsApplier implements SettingsApplier<SpellingSettings> {

  private final Project project;
  private final SpellCheckerSettings spellCheckerSettings;

  @Inject
  public SpellingSettingsApplier(Project project, SpellCheckerSettings spellCheckerSettings) {
    this.project = project;
    this.spellCheckerSettings = spellCheckerSettings;
  }

  @Override
  public void apply(SpellingSettings settings) {
    settings.dictionaries()
        .stream()
        .map(this::toProjectRelativePathIfRelative)
        .map(Path::toString)
        .forEach(spellCheckerSettings.getCustomDictionariesPaths()::add);
  }

  private Path toProjectRelativePathIfRelative(Path path) {
    if (path.isAbsolute()) {
      return path;
    } else {
      final Path projectPath = Paths.get(project.getBasePath());
      return projectPath.resolve(path);
    }
  }
}
