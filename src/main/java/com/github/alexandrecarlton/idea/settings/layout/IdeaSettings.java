package com.github.alexandrecarlton.idea.settings.layout;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.alexandrecarlton.idea.settings.layout.editor.EditorSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.general.GeneralSettings;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableIdeaSettings.class)
public interface IdeaSettings {

  Optional<EditorSettings> editor();

  Optional<GeneralSettings> general();

}

