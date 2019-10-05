package com.github.alexandrecarlton.idea.settings.applier.impl.editor.spelling;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.editor.spelling.ImmutableSpellingSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.spelling.SpellingSettings;
import com.intellij.spellchecker.settings.SpellCheckerSettings;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SpellingSettingsApplierTest extends IdeaSettingsTestFixture {

  private SettingsApplier<SpellingSettings> settingsApplier;
  private SpellCheckerSettings spellCheckerSettings;

  @Override
  public void setUp() throws Exception {
    super.setUp();
    spellCheckerSettings = SpellCheckerSettings.getInstance(project);
    settingsApplier = new SpellingSettingsApplier(spellCheckerSettings);
  }

  @Override
  public void tearDown() throws Exception {
    super.tearDown();
    spellCheckerSettings.getCustomDictionariesPaths().clear();
  }

  @Test
  public void dictionaryRelativeToProjectApplied() {
    Path dict = Paths.get(project.getBasePath()).resolve("dict.dic");
    settingsApplier.apply(ImmutableSpellingSettings.builder()
        .addDictionaries(dict)
        .build());
    assertThat(spellCheckerSettings.getCustomDictionariesPaths()).containsOnly(dict.toString());
  }

  @Test
  public void absoluteDictionaryApplied() {
    settingsApplier.apply(ImmutableSpellingSettings.builder()
        .addDictionaries(Paths.get("/tmp/dict.dic"))
        .build());
    assertThat(spellCheckerSettings.getCustomDictionariesPaths()).containsOnly("/tmp/dict.dic");
  }
}
