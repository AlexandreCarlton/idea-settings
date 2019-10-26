package com.github.alexandrecarlton.idea.settings.layout.tools;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers.FileWatcherSettings;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@JsonDeserialize(as = ImmutableToolsSettings.class)
public interface ToolsSettings {

  List<FileWatcherSettings> fileWatchers();

}
