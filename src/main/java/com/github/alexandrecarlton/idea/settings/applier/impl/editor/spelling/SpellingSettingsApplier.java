package com.github.alexandrecarlton.idea.settings.applier.impl.editor.spelling;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.editor.spelling.SpellingSettings;
import com.intellij.spellchecker.settings.SpellCheckerSettings;

import java.nio.file.Path;

import javax.inject.Inject;

public class SpellingSettingsApplier implements SettingsApplier<SpellingSettings> {

  private final SpellCheckerSettings spellCheckerSettings;

  @Inject
  public SpellingSettingsApplier(SpellCheckerSettings spellCheckerSettings) {
    this.spellCheckerSettings = spellCheckerSettings;
  }

  @Override
  public void apply(SpellingSettings settings) {
    settings.dictionaries()
        .stream()
        .map(Path::toString)
        .forEach(spellCheckerSettings.getCustomDictionariesPaths()::add);
  }
}
