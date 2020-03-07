package com.github.alexandrecarlton.idea.settings.dialog.other_settings.save_actions

import com.dubreuia.model.Action
import com.dubreuia.model.Storage
import com.dubreuia.model.StorageFactory
import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.other_settings.save_actions.FormattingActionsSettings
import com.github.alexandrecarlton.idea.settings.layout.other_settings.save_actions.GeneralSaveActionsSettings
import com.github.alexandrecarlton.idea.settings.layout.other_settings.save_actions.JavaInspectionAndQuickFixSettings
import com.github.alexandrecarlton.idea.settings.layout.other_settings.save_actions.SaveActionsSettings
import org.assertj.core.api.AbstractAssert
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class SaveActionsSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<SaveActionsSettings>
    private lateinit var storage: Storage

    @Before
    public override fun setUp() {
        storage = StorageFactory.DEFAULT.getStorage(project)
        settingsApplier = SaveActionsSettingsApplier(storage)
    }

    @Test
    fun `Activate save actions on save`() {
        settingsApplier.apply(SaveActionsSettings(
            general = GeneralSaveActionsSettings(
                activateSaveActionsOnSave = true)))
        assertThat(storage.actions).contains(Action.activate)
    }

    @Test
    fun `Activate save actions on shortcut`() {
        settingsApplier.apply(SaveActionsSettings(
            general = GeneralSaveActionsSettings(
                activateSaveActionsOnShortcut = true)))
        assertThat(storage.actions).contains(Action.activateOnShortcut)
    }

    @Test
    fun `Activate save actions on batch`() {
        settingsApplier.apply(SaveActionsSettings(
            general = GeneralSaveActionsSettings(
                activateSaveActionsOnBatch = true)))
        assertThat(storage.actions).contains(Action.activateOnBatch)
    }

    @Test
    fun `Optimize imports`() {
        settingsApplier.apply(SaveActionsSettings(
            formattingActions = FormattingActionsSettings(
                optimizeImports = true)))
        assertThat(Action.organizeImports).isEnabled()
    }

    @Test
    fun `Reformat file`() {
        settingsApplier.apply(SaveActionsSettings(
            formattingActions = FormattingActionsSettings(
                reformatFile = true)))
        assertThat(Action.reformat).isEnabled()
    }

    @Test
    fun `Reformat only changed code`() {
        settingsApplier.apply(SaveActionsSettings(
            formattingActions = FormattingActionsSettings(
                reformatOnlyChangedCode = true)))
        assertThat(Action.reformatChangedCode).isEnabled()
    }

    @Test
    fun `Rearrange fields and methods`() {
        settingsApplier.apply(SaveActionsSettings(
            formattingActions = FormattingActionsSettings(
                rearrangeFieldsAndMethods = true)))
        assertThat(Action.rearrange).isEnabled()
    }

    @Test
    fun `Add final modifier to field`() {
        settingsApplier.apply(SaveActionsSettings(
            javaInspectionAndQuickFix = JavaInspectionAndQuickFixSettings(
                addFinalModifierToField = true)))
        assertThat(Action.fieldCanBeFinal).isEnabled()
    }

    @Test
    fun `Add final modifier to local variable or parameter`() {
        settingsApplier.apply(SaveActionsSettings(
            javaInspectionAndQuickFix = JavaInspectionAndQuickFixSettings(
                addFinalModifierToLocalVariableOrParameter = true)))
        assertThat(Action.localCanBeFinal).isEnabled()
    }

    @Test
    fun `Add final modifier to local variable or parameter except if it is implicit`() {
        settingsApplier.apply(SaveActionsSettings(
            javaInspectionAndQuickFix = JavaInspectionAndQuickFixSettings(
                addFinalModifierToLocalVariableOrParameterExecptIfItIsImplicit = true)))
        assertThat(Action.localCanBeFinalExceptImplicit).isEnabled()
    }

    @Test
    fun `Add static modifier to methods`() {
        settingsApplier.apply(SaveActionsSettings(
            javaInspectionAndQuickFix = JavaInspectionAndQuickFixSettings(
                addStaticModifierToMethods = true)))
        assertThat(Action.methodMayBeStatic).isEnabled()
    }

    @Test
    fun `Add this to field access`() {
        settingsApplier.apply(SaveActionsSettings(
            javaInspectionAndQuickFix = JavaInspectionAndQuickFixSettings(
                addThisToFieldAccess = true)))
        assertThat(Action.unqualifiedFieldAccess).isEnabled()
    }

    @Test
    fun `Add this to method access`() {
        settingsApplier.apply(SaveActionsSettings(
            javaInspectionAndQuickFix = JavaInspectionAndQuickFixSettings(
                addThisToMethodAccess = true)))
        assertThat(Action.unqualifiedMethodAccess).isEnabled()
    }

    @Test
    fun `Add class qualifier to static member access`() {
        settingsApplier.apply(SaveActionsSettings(
            javaInspectionAndQuickFix = JavaInspectionAndQuickFixSettings(
                addClassQualifierToStaticMemberAccess = true)))
        assertThat(Action.unqualifiedStaticMemberAccess).isEnabled()
    }

    @Test
    fun `Add class qualifier to static member access outside declaring class`() {
        settingsApplier.apply(SaveActionsSettings(
            javaInspectionAndQuickFix = JavaInspectionAndQuickFixSettings(
                addClassQualifierToStaticMemberAccessOutsideDeclaringClass = true)))
        assertThat(Action.customUnqualifiedStaticMemberAccess).isEnabled()
    }

    @Test
    fun `Add missing @Override annotations`() {
        settingsApplier.apply(SaveActionsSettings(
            javaInspectionAndQuickFix = JavaInspectionAndQuickFixSettings(
                addMissingOverrideAnnotations = true)))
        assertThat(Action.missingOverrideAnnotation).isEnabled()
    }

    @Test
    fun `Add blocks to if-while-for statements`() {
        settingsApplier.apply(SaveActionsSettings(
            javaInspectionAndQuickFix = JavaInspectionAndQuickFixSettings(
                addBlocksToIfWhileForStatements = true)))
        assertThat(Action.useBlocks).isEnabled()
    }

    @Test
    fun `Add serialVersionUID field for Serializable classes`() {
        settingsApplier.apply(SaveActionsSettings(
            javaInspectionAndQuickFix = JavaInspectionAndQuickFixSettings(
                addSerialVersionUidFieldForSerializableClasses = true)))
        assertThat(Action.generateSerialVersionUID).isEnabled()
    }

    @Test
    fun `Remove unnecessary this to field and method`() {
        settingsApplier.apply(SaveActionsSettings(
            javaInspectionAndQuickFix = JavaInspectionAndQuickFixSettings(
                removeUnnecessaryThisToFieldAndMethod = true)))
        assertThat(Action.unnecessaryThis).isEnabled()
    }

    @Test
    fun `Remove final from private method`() {
        settingsApplier.apply(SaveActionsSettings(
            javaInspectionAndQuickFix = JavaInspectionAndQuickFixSettings(
                removeFinalFromPrivateMethod = true)))
        assertThat(Action.finalPrivateMethod).isEnabled()
    }

    @Test
    fun `Remove unnecessary final to local variable or parameter`() {
        settingsApplier.apply(SaveActionsSettings(
            javaInspectionAndQuickFix = JavaInspectionAndQuickFixSettings(
                removeUnnecessaryFinalToLocalVariableOrParameter = true)))
        assertThat(Action.unnecessaryFinalOnLocalVariableOrParameter).isEnabled()
    }

    @Test
    fun `Remove explicit generic type for diamond`() {
        settingsApplier.apply(SaveActionsSettings(
            javaInspectionAndQuickFix = JavaInspectionAndQuickFixSettings(
                removeExplicitGenericTypeForDiamond = true)))
        assertThat(Action.explicitTypeCanBeDiamond).isEnabled()
    }

    @Test
    fun `Remove unused suppress warning annotation`() {
        settingsApplier.apply(SaveActionsSettings(
            javaInspectionAndQuickFix = JavaInspectionAndQuickFixSettings(
                removeUnusedSuppressWarningAnnotation = true)))
        assertThat(Action.suppressAnnotation).isEnabled()
    }

    @Test
    fun `Remove unnecessary semicolon`() {
        settingsApplier.apply(SaveActionsSettings(
            javaInspectionAndQuickFix = JavaInspectionAndQuickFixSettings(
                removeUnnecessarySemicolon = true)))
        assertThat(Action.unnecessarySemicolon).isEnabled()
    }

    @Test
    fun `Remove blocks from if-while-for statements`() {
        settingsApplier.apply(SaveActionsSettings(
            javaInspectionAndQuickFix = JavaInspectionAndQuickFixSettings(
                removeBlocksFromIfWhileForStatements = true)))
        assertThat(Action.singleStatementInBlock).isEnabled()
    }

    @Test
    fun `Change visibility of field or method to lower access`() {
        settingsApplier.apply(SaveActionsSettings(
            javaInspectionAndQuickFix = JavaInspectionAndQuickFixSettings(
                changeVisibilityOfFieldOrMethodToLowerAccess = true)))
        assertThat(Action.accessCanBeTightened).isEnabled()
    }

    private fun assertThat(action: Action) = ActionAssert(action)

    private inner class ActionAssert(actual: Action): AbstractAssert<ActionAssert, Action>(actual, ActionAssert::class.java) {

        fun isEnabled(): ActionAssert {
            if (!storage.isEnabled(actual)) {
                failWithMessage("Expected Action <%s> to be enabled, but was not enabled", actual.text)
            }
            return this
        }
    }
}
