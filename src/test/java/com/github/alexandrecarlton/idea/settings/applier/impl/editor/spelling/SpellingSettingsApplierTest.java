package com.github.alexandrecarlton.idea.settings.applier.impl.editor.spelling;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.editor.spelling.ImmutableSpellingSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.spelling.SpellingSettings;
import com.intellij.spellchecker.settings.SpellCheckerSettings;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SpellingSettingsApplierTest extends IdeaSettingsTestFixture {

  private SettingsApplier<SpellingSettings> settingsApplier;
  private SpellCheckerSettings spellCheckerSettings;

  @Before
  public void setUp() {
    spellCheckerSettings = SpellCheckerSettings.getInstance(project);
    settingsApplier = new SpellingSettingsApplier(spellCheckerSettings);
  }

  @After
  public void tearDown() {
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
