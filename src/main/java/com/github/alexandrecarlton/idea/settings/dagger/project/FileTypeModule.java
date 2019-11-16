package com.github.alexandrecarlton.idea.settings.dagger.project;

import com.github.alexandrecarlton.idea.settings.dagger.common.Plugin;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.lang.javascript.JavaScriptFileType;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.UnknownFileType;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.util.function.Supplier;
import javax.inject.Named;

@Module
public class FileTypeModule {

  private static final Logger LOG = Logger.getInstance(FileTypeModule.class);

  @Provides
  static JavaScriptFileType provideJavaScriptFileType() {
    return JavaScriptFileType.INSTANCE;
  }

  @Provides
  @Named("JavaScript")
  static Supplier<FileType> provideJavaScriptFileTypeSupplier(Lazy<JavaScriptFileType> javaScriptFileType) {
    return provideIfLoaded(Plugin.JAVASCRIPT_AND_TYPESCRIPT, javaScriptFileType);
  }

  private static Supplier<FileType> provideIfLoaded(Plugin plugin, Lazy<? extends FileType> fileTypeSupplier) {
    if (PluginManager.isPluginInstalled(PluginId.findId(plugin.getId()))) {
      return fileTypeSupplier::get;
    } else {
      LOG.warn("Unable to use file type as '" + plugin.getName() + "' is not installed, using 'Unknown' instead.");
      return () -> UnknownFileType.INSTANCE;
    }
  }
}
