package com.github.alexandrecarlton.idea.settings.starter;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings;
import com.intellij.openapi.application.ex.ApplicationEx;
import com.intellij.openapi.project.Project;
import dagger.BindsInstance;
import dagger.Component;

import javax.inject.Named;

@Component(modules = {
    IdeaModule.class,
    SettingsApplierModule.class,
    ProjectModule.class})
public interface IdeaSettingsComponent {
  SettingsApplier<IdeaSettings> applier();
  Project project();
  ApplicationEx applicationEx();

  @Component.Builder
  interface Builder {
    @BindsInstance Builder project(@Named("project") String project);
    IdeaSettingsComponent build();
  }
}
