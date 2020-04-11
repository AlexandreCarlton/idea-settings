package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.nodejs_and_npm

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import java.io.File

class NodejsAndNpmSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<NodejsAndNpmSettings>

    @Before
    public override fun setUp() {
        settingsApplier = NodejsAndNpmSettingsApplier(platform.npmManager, platform.nodeJsInterpreterManager)
    }

    @Test
    fun nodeInterpreterApplied() {
        settingsApplier.apply(NodejsAndNpmSettings(
            nodeInterpreter = File(project.basePath!!).resolve("node")))
        assertThat(platform.nodeJsInterpreterManager.interpreterRef.referenceName).isEqualTo("${project.basePath}/node");
    }

    @Test
    fun packageManagerApplied() {
        settingsApplier.apply(NodejsAndNpmSettings(
            packageManager = File(project.basePath!!).resolve("npm")))
        assertThat(platform.npmManager.packageRef.referenceName).isEqualTo("${project.basePath}/npm");
    }


}
