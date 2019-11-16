package com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.alexandrecarlton.idea.settings.layout.common.FileType;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableFileWatcherFilesToWatchSettings.class)
public interface FileWatcherFilesToWatchSettings {

  Optional<FileType> fileType();

  Optional<String> scope();
}
