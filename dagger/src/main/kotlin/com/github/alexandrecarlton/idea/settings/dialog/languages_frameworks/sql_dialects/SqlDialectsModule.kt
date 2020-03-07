package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object SqlDialectsModule : AbstractPluginModule() {

    @Provides
    internal fun provideSqlDialectsSettingsApplier(applier: Lazy<SqlDialectsSettingsApplier>) =
        provideIfLoaded(Plugin.DATABASE_TOOLS_AND_SQL, applier)
}
