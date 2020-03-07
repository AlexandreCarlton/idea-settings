package com.github.alexandrecarlton.idea.settings.dialog.other_settings.save_actions

import com.dubreuia.model.Action
import com.dubreuia.model.Storage
import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import javax.inject.Inject

class SaveActionsSettingsApplier @Inject constructor(private val storage: Storage)
    : SettingsApplier<SaveActionsSettings> {

    override fun apply(settings: SaveActionsSettings) {
        settings.general?.let(this::applyGeneral)
        settings.formattingActions?.let(this::applyFormatting)
        settings.javaInspectionAndQuickFix?.let(this::applyJavaInspectionAndQuickFix)
    }

    private fun applyFormatting(settings: FormattingActionsSettings) {
        settings.optimizeImports?.let { storage.setEnabled(Action.organizeImports, it) }
        settings.reformatFile?.let { storage.setEnabled(Action.reformat, it) }
        settings.reformatOnlyChangedCode?.let { storage.setEnabled(Action.reformatChangedCode, it) }
        settings.rearrangeFieldsAndMethods?.let { storage.setEnabled(Action.rearrange, it) }
    }

    private fun applyGeneral(settings: GeneralSaveActionsSettings) {
        settings.activateSaveActionsOnBatch?.let { setSaveAction(Action.activateOnBatch, it) }
        settings.activateSaveActionsOnSave?.let { setSaveAction(Action.activate, it) }
        settings.activateSaveActionsOnShortcut?.let { setSaveAction(Action.activateOnShortcut, it) }
    }

    private fun setSaveAction(action: Action, enabled: Boolean) {
        if (enabled) {
            storage.actions.add(action)
        } else {
            storage.actions.remove(action)
        }
    }

    private fun applyJavaInspectionAndQuickFix(settings: JavaInspectionAndQuickFixSettings) {
        settings.addBlocksToIfWhileForStatements?.let { storage.setEnabled(Action.useBlocks, it) }
        settings.addClassQualifierToStaticMemberAccess?.let { storage.setEnabled(Action.unqualifiedStaticMemberAccess, it) }
        settings.addClassQualifierToStaticMemberAccessOutsideDeclaringClass?.let { storage.setEnabled(Action.customUnqualifiedStaticMemberAccess, it) }
        settings.addFinalModifierToField?.let { storage.setEnabled(Action.fieldCanBeFinal, it) }
        settings.addFinalModifierToLocalVariableOrParameter?.let { storage.setEnabled(Action.localCanBeFinal, it) }
        settings.addFinalModifierToLocalVariableOrParameterExecptIfItIsImplicit?.let { storage.setEnabled(Action.localCanBeFinalExceptImplicit, it) }
        settings.addMissingOverrideAnnotations?.let { storage.setEnabled(Action.missingOverrideAnnotation, it) }
        settings.addStaticModifierToMethods?.let { storage.setEnabled(Action.methodMayBeStatic, it) }
        settings.addSerialVersionUidFieldForSerializableClasses?.let { storage.setEnabled(Action.generateSerialVersionUID, it) }
        settings.addThisToFieldAccess?.let { storage.setEnabled(Action.unqualifiedFieldAccess, it) }
        settings.addThisToMethodAccess?.let { storage.setEnabled(Action.unqualifiedMethodAccess, it) }
        settings.changeVisibilityOfFieldOrMethodToLowerAccess?.let { storage.setEnabled(Action.accessCanBeTightened, it) }
        settings.removeBlocksFromIfWhileForStatements?.let { storage.setEnabled(Action.singleStatementInBlock, it) }
        settings.removeExplicitGenericTypeForDiamond?.let { storage.setEnabled(Action.explicitTypeCanBeDiamond, it) }
        settings.removeFinalFromPrivateMethod?.let { storage.setEnabled(Action.finalPrivateMethod, it) }
        settings.removeUnnecessaryFinalToLocalVariableOrParameter?.let { storage.setEnabled(Action.unnecessaryFinalOnLocalVariableOrParameter, it) }
        settings.removeUnnecessarySemicolon?.let { storage.setEnabled(Action.unnecessarySemicolon, it) }
        settings.removeUnnecessaryThisToFieldAndMethod?.let { storage.setEnabled(Action.unnecessaryThis, it) }
        settings.removeUnusedSuppressWarningAnnotation?.let { storage.setEnabled(Action.suppressAnnotation, it) }
    }
}
