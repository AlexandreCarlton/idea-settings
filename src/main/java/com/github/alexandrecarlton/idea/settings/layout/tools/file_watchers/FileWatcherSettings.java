package com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableFileWatcherSettings.class)
public interface FileWatcherSettings {

  String name();

  FileWatcherFilesToWatchSettings filesToWatch();

  FileWatcherToolToRunOnChangesSettings toolToRunOnChanges();

  Optional<FileWatcherAdvancedOptionsSettings> advancedOptions();
}
