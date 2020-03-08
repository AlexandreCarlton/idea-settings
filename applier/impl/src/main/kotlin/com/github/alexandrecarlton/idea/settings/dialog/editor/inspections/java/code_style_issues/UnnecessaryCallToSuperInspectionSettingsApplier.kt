package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues

import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.base.BaseInspectionSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues.options.UnnecessaryCallToSuperInspectionOptionsSettings
import com.intellij.codeInspection.ex.ToolsImpl
import javax.inject.Inject
import javax.inject.Named

class UnnecessaryCallToSuperInspectionSettingsApplier @Inject
constructor(
    @Named("UnnecessarySuperConstructor") toolsImpl: ToolsImpl
) : BaseInspectionSettingsApplier<UnnecessaryCallToSuperInspectionOptionsSettings>(toolsImpl)
