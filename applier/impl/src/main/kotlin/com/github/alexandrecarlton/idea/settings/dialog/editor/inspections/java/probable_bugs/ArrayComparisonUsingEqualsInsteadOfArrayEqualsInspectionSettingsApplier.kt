package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.probable_bugs

import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.base.BaseInspectionSettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.probable_bugs.options.ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionOptionsSettings
import com.intellij.codeInspection.ex.ToolsImpl
import javax.inject.Inject
import javax.inject.Named

class ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionSettingsApplier @Inject
constructor(
    @Named("ArrayEquality") toolsImpl: ToolsImpl
) : BaseInspectionSettingsApplier<ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionOptionsSettings>(toolsImpl)
