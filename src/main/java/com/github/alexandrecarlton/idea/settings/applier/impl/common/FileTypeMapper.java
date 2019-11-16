package com.github.alexandrecarlton.idea.settings.applier.impl.common;

import com.intellij.openapi.fileTypes.FileType;
import java.util.function.Supplier;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Maps our {@link FileType} layout to an IntelliJ file type.
 * If none can be found, a sentinel value is returned.
 */
public class FileTypeMapper {

  private final Supplier<FileType> javascriptFileTypeSupplier;

  @Inject
  public FileTypeMapper(@Named("JavaScript") Supplier<FileType> javascriptFileTypeSupplier) {
    this.javascriptFileTypeSupplier = javascriptFileTypeSupplier;
  }

  public FileType mapFileType(com.github.alexandrecarlton.idea.settings.layout.common.FileType fileType) {
    switch (fileType) {
      case JAVASCRIPT: return javascriptFileTypeSupplier.get();
      default:
        throw new IllegalArgumentException("Unhandled file type: " + fileType);
    }
  }

}
