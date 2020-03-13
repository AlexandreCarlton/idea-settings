package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.nodejs_and_npm

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.intellij.javascript.nodejs.interpreter.NodeJsInterpreterManager
import com.intellij.javascript.nodejs.interpreter.NodeJsInterpreterRef
import com.intellij.javascript.nodejs.npm.NpmManager
import com.intellij.javascript.nodejs.util.NodePackageRef
import javax.inject.Inject

class NodejsAndNpmSettingsApplier @Inject constructor(
    private val npmManager: NpmManager,
    private val nodeJsInterpreterManager: NodeJsInterpreterManager
): SettingsApplier<NodejsAndNpmSettings> {
    override fun apply(settings: NodejsAndNpmSettings) {
        settings.nodeInterpreter
            ?.toString()
            ?.let(NodeJsInterpreterRef::create)
            ?.let(nodeJsInterpreterManager::setInterpreterRef)
        settings.packageManager
            ?.toString()
            ?.let(NodePackageRef::create)
            ?.let { npmManager.packageRef = it }
    }
}
