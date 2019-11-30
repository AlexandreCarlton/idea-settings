package com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.LanguagesFrameworksSettings
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.JavascriptSettings
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.sql_dialects.SqlDialectsSettings

import javax.inject.Inject

class LanguagesFrameworksSettingsApplier @Inject
constructor(private val javascriptSettingsApplier: SettingsApplier<JavascriptSettings>,
            private val sqlDialectsSettingsApplier: SettingsApplier<SqlDialectsSettings>) : SettingsApplier<LanguagesFrameworksSettings> {

    override fun apply(settings: LanguagesFrameworksSettings) {
        settings.javascript().ifPresent { javascriptSettingsApplier.apply(it) }
        settings.sqlDialects().ifPresent { sqlDialectsSettingsApplier.apply(it) }
    }
}
