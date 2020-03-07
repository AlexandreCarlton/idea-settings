package com.github.alexandrecarlton.idea.settings.dialog

import dagger.Binds
import dagger.Module

@Module
interface IdeaModule {

    @Binds
    fun bindIdeaSettingsApplier(applier: IdeaSettingsApplier): SettingsApplier<IdeaSettings>

}
