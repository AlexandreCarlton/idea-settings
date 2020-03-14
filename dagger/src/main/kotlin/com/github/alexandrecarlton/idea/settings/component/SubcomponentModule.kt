package com.github.alexandrecarlton.idea.settings.component

import com.github.alexandrecarlton.idea.settings.configuration.ConfigurationSubcomponent
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.subcomponent.InspectionsSubcomponent
import com.github.alexandrecarlton.idea.settings.dialog.project_settings.modules.ModuleSubcomponent
import dagger.Module

@Module(subcomponents = [
    ModuleSubcomponent::class,
    ConfigurationSubcomponent::class,
    InspectionsSubcomponent::class])
object SubcomponentModule
