package com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonDeserialize(as = ImmutableFileWatcherFilesToWatchSettings.class)
public interface FileWatcherFilesToWatchSettings {

  Optional<FileWatcherFileType> fileType();

  Optional<String> scope();
}
