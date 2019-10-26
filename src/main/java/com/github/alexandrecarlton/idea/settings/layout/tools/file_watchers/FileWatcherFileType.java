package com.github.alexandrecarlton.idea.settings.layout.tools.file_watchers;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: This should be a common filetype that can be mapped to FileType (retrieved using FileTypeManager).
public enum FileWatcherFileType {

  @JsonProperty("JavaScript")
  JAVASCRIPT
}
