package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.probable_bugs.options

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import dagger.Module

@Module(includes = [NoOpJavaProbableBugsInspectionsOptionsModule::class])
object JavaProbableBugsInspectionsOptionsModule : AbstractPluginModule() {

}
