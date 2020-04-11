package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.sql.dialects.postgres.PgDialect
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

class SqlDialectsSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<SqlDialectsSettings>

    @Before
    public override fun setUp() {
        settingsApplier = SqlDialectsSettingsApplier(project, platform.sqlDialectMappings)
    }

    @Test
    @Ignore("Light fixture fails on project.getProjectFile() access.")
    fun projectSqlDialectApplied() {
        settingsApplier.apply(SqlDialectsSettings(projectSqlDialect = SqlDialect.POSTGRESQL))
        assertThat(platform.sqlDialectMappings.getMapping(project.projectFile)).isEqualTo(PgDialect.INSTANCE)
    }
}
