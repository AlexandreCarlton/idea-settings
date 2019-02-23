package com.github.alexandrecarlton.idea.settings.layout.editor;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.CodeStyleSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.general.GeneralSettings;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableEditorSettings.class)
public interface EditorSettings {

  Optional<GeneralSettings> general();

  Optional<CodeStyleSettings> codeStyle();

}
