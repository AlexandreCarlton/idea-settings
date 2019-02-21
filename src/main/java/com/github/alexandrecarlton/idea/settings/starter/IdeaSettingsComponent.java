package com.github.alexandrecarlton.idea.settings.starter;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings;
import dagger.BindsInstance;
import dagger.Component;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Component(modules = {SettingsApplierModule.class, ProjectModule.class})
public interface IdeaSettingsComponent {
  SettingsApplier<IdeaSettings> applier();

  @Component.Builder
  interface Builder {
    @BindsInstance Builder project(@Named("project") String project);
    IdeaSettingsComponent build();
  }
}
