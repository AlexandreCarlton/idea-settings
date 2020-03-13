package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript.JavascriptSettings
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.nodejs_and_npm.NodejsAndNpmSettings
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialectsSettings
import javax.inject.Inject

class LanguagesFrameworksSettingsApplier @Inject
constructor(
    private val javascriptSettingsApplier: SettingsApplier<JavascriptSettings>,
    private val nodejsAndNpmSettingsApplier: SettingsApplier<NodejsAndNpmSettings>,
    private val sqlDialectsSettingsApplier: SettingsApplier<SqlDialectsSettings>
) : SettingsApplier<LanguagesFrameworksSettings> {

    override fun apply(settings: LanguagesFrameworksSettings) {
        settings.javascript?.let(javascriptSettingsApplier::apply)
        settings.nodejsAndNpm?.let(nodejsAndNpmSettingsApplier::apply)
        settings.sqlDialects?.let(sqlDialectsSettingsApplier::apply)
    }
}
