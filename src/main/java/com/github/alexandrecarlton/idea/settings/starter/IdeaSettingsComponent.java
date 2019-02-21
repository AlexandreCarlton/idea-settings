package com.github.alexandrecarlton.idea.settings.starter;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings;
import dagger.Component;

@Component(modules = SettingsApplierModule.class)
public interface IdeaSettingsComponent {
  SettingsApplier<IdeaSettings> applier();
}
