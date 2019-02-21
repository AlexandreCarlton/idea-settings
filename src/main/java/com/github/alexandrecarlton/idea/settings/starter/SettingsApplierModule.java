package com.github.alexandrecarlton.idea.settings.starter;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.IdeaSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.EditorSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.CodeStyleSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.JavaCodeStyleSettingsApplier;
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.JavaImportsSettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.EditorSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.CodeStyleSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaCodeStyleSettings;
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaImportsSettings;
import dagger.Binds;
import dagger.Module;

@Module
public interface SettingsApplierModule {

  @Binds
  SettingsApplier<IdeaSettings> bindIdeaSettingsApplier(IdeaSettingsApplier applier);

  @Binds
  SettingsApplier<EditorSettings> bindEditorSettingsApplier(EditorSettingsApplier applier);

  @Binds
  SettingsApplier<CodeStyleSettings> bindCodeStyleSettingsApplier(CodeStyleSettingsApplier applier);

  @Binds
  SettingsApplier<JavaCodeStyleSettings> bindJavaCodeStyleSettingsApplier(JavaCodeStyleSettingsApplier applier);

  @Binds
  SettingsApplier<JavaImportsSettings> bindJavaImportsSettingsApplier(JavaImportsSettingsApplier applier);

}
