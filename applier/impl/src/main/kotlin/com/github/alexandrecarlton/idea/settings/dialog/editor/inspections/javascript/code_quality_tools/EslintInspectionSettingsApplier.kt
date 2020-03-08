package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript.code_quality_tools

import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.base.BaseInspectionSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript.code_quality_tools.options.EslintInspectionOptionsSettings
import com.intellij.codeInspection.ex.ToolsImpl
import javax.inject.Inject
import javax.inject.Named

class EslintInspectionSettingsApplier @Inject
constructor(
    @Named("Eslint") toolsImpl: ToolsImpl
) : BaseInspectionSettingsApplier<EslintInspectionOptionsSettings>(toolsImpl)
