package com.github.alexandrecarlton.idea.settings.applier.impl.editor.inspections.base

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.inspections.InspectionsSubcomponent
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base.BaseInspectionSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base.Scope.EVERYWHERE_ELSE
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base.Scope.IN_ALL_SCOPES
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base.Scope.OPEN_FILES
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base.Scope.PROBLEMS
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base.Scope.PRODUCTION
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base.Scope.PROJECT_FILES
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base.Scope.SCRATCHES_AND_CONSOLES
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base.Scope.TESTS
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base.Severity
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base.Severity.ERROR
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base.Severity.NO_HIGHLIGHTING_ONLY_FIX
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base.Severity.SERVER_PROBLEM
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base.Severity.TYPO
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base.Severity.WARNING
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.base.Severity.WEAK_WARNING
import com.intellij.codeHighlighting.HighlightDisplayLevel
import com.intellij.codeInspection.ex.ToolsImpl
import com.intellij.ide.scratch.ScratchesNamedScope
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.fileEditor.impl.OpenFilesScope
import com.intellij.psi.search.scope.ProblemsScope
import com.intellij.psi.search.scope.ProjectFilesScope
import com.intellij.psi.search.scope.ProjectProductionScope
import com.intellij.psi.search.scope.TestsScope
import javax.inject.Inject

/**
 * There are literally hundreds of inspections supported by IntelliJ IDEA, and while they all share the same methodology
 * for application, they differ ever so slightly through the options for the settings.
 * Rather than duplicate this code over and over again,
 * we parameterise over this options class and inherit this class to allow for different inspections to be applied.
 */
abstract class BaseInspectionSettingsApplier<Options>(private val toolsImpl: ToolsImpl) : SettingsApplier<BaseInspectionSettings<Options>> {

    private val LOG = Logger.getInstance(javaClass)

    // Avoid using a constructor parameter so subclasses don't have to declare it.
    @Inject
    lateinit var inspectionsSubcomponentBuilder: InspectionsSubcomponent.Builder

    override fun apply(settings: BaseInspectionSettings<Options>) {
        toolsImpl.removeAllScopes()
        val inspectionToolWrapper = toolsImpl.tool
        settings.enabled?.let { toolsImpl.isEnabled = it }
        settings.severityByScope?.forEach { scopedSeverity ->
            val highlightDisplayLevel = toHighlightDisplayLevel(scopedSeverity.severity)
            val scopeToolState = when(scopedSeverity.scope) {
                IN_ALL_SCOPES, EVERYWHERE_ELSE -> toolsImpl.defaultState
                PROJECT_FILES -> toolsImpl.addTool(ProjectFilesScope.INSTANCE, inspectionToolWrapper.createCopy(), toolsImpl.isEnabled, highlightDisplayLevel)
                SCRATCHES_AND_CONSOLES -> toolsImpl.addTool(ScratchesNamedScope(), inspectionToolWrapper.createCopy(), toolsImpl.isEnabled, highlightDisplayLevel)
                PRODUCTION -> toolsImpl.addTool(ProjectProductionScope.INSTANCE, inspectionToolWrapper.createCopy(), toolsImpl.isEnabled, highlightDisplayLevel)
                TESTS -> toolsImpl.addTool(TestsScope.INSTANCE, inspectionToolWrapper.createCopy(), toolsImpl.isEnabled, highlightDisplayLevel)
                PROBLEMS -> toolsImpl.addTool(ProblemsScope.INSTANCE, inspectionToolWrapper.createCopy(), toolsImpl.isEnabled, highlightDisplayLevel)
                OPEN_FILES -> toolsImpl.addTool(OpenFilesScope.INSTANCE, inspectionToolWrapper.createCopy(), toolsImpl.isEnabled, highlightDisplayLevel)
            }

            scopedSeverity.options?.let { options ->
                inspectionsSubcomponentBuilder
                    .scopeToolState(scopeToolState)
                    .build()
                    .settingsApplier()
                    .apply(options as Any)
            }
        }
    }

    // TODO: What if we translated to HighlightSeverity? Then we can call HighlightDisplayLevel.find
    private fun toHighlightDisplayLevel(severity: Severity): HighlightDisplayLevel =
        when(severity) {
            ERROR -> HighlightDisplayLevel.ERROR
            WARNING -> HighlightDisplayLevel.WARNING
            WEAK_WARNING -> HighlightDisplayLevel.WEAK_WARNING
            SERVER_PROBLEM -> HighlightDisplayLevel.GENERIC_SERVER_ERROR_OR_WARNING
            TYPO -> TODO() // Dunno where this one lives, maybe check HighlightSeverity?
            NO_HIGHLIGHTING_ONLY_FIX -> HighlightDisplayLevel.DO_NOT_SHOW
        }

}
