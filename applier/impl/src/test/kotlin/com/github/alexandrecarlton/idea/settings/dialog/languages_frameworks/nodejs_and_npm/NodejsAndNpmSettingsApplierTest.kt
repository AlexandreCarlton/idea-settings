package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.nodejs_and_npm

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.javascript.nodejs.interpreter.NodeJsInterpreterManager
import com.intellij.javascript.nodejs.npm.NpmManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import java.io.File

class NodejsAndNpmSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<NodejsAndNpmSettings>
    private lateinit var npmManager: NpmManager
    private lateinit var nodeJsInterpreterManager: NodeJsInterpreterManager

    @Before
    public override fun setUp() {
        npmManager = NpmManager.getInstance(project)
        nodeJsInterpreterManager = NodeJsInterpreterManager.getInstance(project)
        settingsApplier = NodejsAndNpmSettingsApplier(npmManager, nodeJsInterpreterManager)
    }

    @Test
    fun nodeInterpreterApplied() {
        settingsApplier.apply(NodejsAndNpmSettings(
            nodeInterpreter = File(project.basePath!!).resolve("node")))
        assertThat(nodeJsInterpreterManager.interpreterRef.referenceName).isEqualTo("${project.basePath}/node");
    }

    @Test
    fun packageManagerApplied() {
        settingsApplier.apply(NodejsAndNpmSettings(
            packageManager = File(project.basePath!!).resolve("npm")))
        assertThat(npmManager.packageRef.referenceName).isEqualTo("${project.basePath}/npm");
    }


}
