package com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableFileWatcherToolToRunOnChangesSettings.class)
public interface FileWatcherToolToRunOnChangesSettings {

  String program();

  String arguments();

  String outputPathsToRefresh();
}
