package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.kotlin.redundant_constructs

import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.base.BaseInspectionSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.kotlin.redundant_constructs.options.UnusedImportDirectiveInspectionOptionsSettings
import com.intellij.codeInspection.ex.ToolsImpl
import javax.inject.Inject
import javax.inject.Named

class UnusedImportDirectiveInspectionSettingsApplier @Inject
constructor(
    @Named("KotlinUnusedImport") toolsImpl: ToolsImpl
) : BaseInspectionSettingsApplier<UnusedImportDirectiveInspectionOptionsSettings>(toolsImpl)
