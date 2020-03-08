package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.javadoc

import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.base.BaseInspectionSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.javadoc.options.MissingDeprecatedAnnotationInspectionOptionsSettings
import com.intellij.codeInspection.ex.ToolsImpl
import javax.inject.Inject
import javax.inject.Named

class MissingDeprecatedAnnotationInspectionSettingsApplier @Inject
constructor(
    @Named("MissingDeprecatedAnnotation") toolsImpl: ToolsImpl
) : BaseInspectionSettingsApplier<MissingDeprecatedAnnotationInspectionOptionsSettings>(toolsImpl)
