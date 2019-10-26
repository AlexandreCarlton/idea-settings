package com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableFileWatcherAdvancedOptionsSettings.class)
public interface FileWatcherAdvancedOptionsSettings {

  Optional<Boolean> autoSaveEditedFilesToTriggerTheWatcher();

  Optional<Boolean> triggerTheWatcherRegardlessOfSyntaxErrors();

  Optional<Boolean> triggerTheWatcherOnExternalChanges();
}
