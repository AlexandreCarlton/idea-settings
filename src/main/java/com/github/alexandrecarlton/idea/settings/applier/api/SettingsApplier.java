package com.github.alexandrecarlton.idea.settings.applier.api;

public interface SettingsApplier<T> {
  void apply(T settings);
}
