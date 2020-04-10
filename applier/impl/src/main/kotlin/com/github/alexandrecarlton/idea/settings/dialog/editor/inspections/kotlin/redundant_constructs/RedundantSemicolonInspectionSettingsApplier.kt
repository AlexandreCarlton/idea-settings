package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.kotlin.redundant_constructs

import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.base.BaseInspectionSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.kotlin.redundant_constructs.options.RedundantSemicolonInspectionOptionsSettings
import com.intellij.codeInspection.ex.ToolsImpl
import javax.inject.Inject
import javax.inject.Named

class RedundantSemicolonInspectionSettingsApplier @Inject
constructor(
    @Named("RedundantSemicolon") toolsImpl: ToolsImpl
) : BaseInspectionSettingsApplier<RedundantSemicolonInspectionOptionsSettings>(toolsImpl)
