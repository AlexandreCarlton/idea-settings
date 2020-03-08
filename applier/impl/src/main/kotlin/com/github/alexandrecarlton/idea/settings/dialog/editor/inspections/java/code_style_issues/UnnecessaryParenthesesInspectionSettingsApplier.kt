package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues

import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.base.BaseInspectionSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues.options.UnnecessaryParenthesesInspectionOptionsSettings
import com.intellij.codeInspection.ex.ToolsImpl
import javax.inject.Inject
import javax.inject.Named

class UnnecessaryParenthesesInspectionSettingsApplier @Inject
constructor(
    @Named("UnnecessaryParentheses") toolsImpl: ToolsImpl
) : BaseInspectionSettingsApplier<UnnecessaryParenthesesInspectionOptionsSettings>(toolsImpl)
