package com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks.sql_dialects

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.sql_dialects.SqlDialect
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.sql_dialects.SqlDialectsSettings
import com.intellij.sql.dialects.SqlDialectMappings
import com.intellij.sql.dialects.postgres.PgDialect
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

class SqlDialectsSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<SqlDialectsSettings>
    private lateinit var sqlDialectMappings: SqlDialectMappings

    @Before
    public override fun setUp() {
        sqlDialectMappings = SqlDialectMappings.getInstance(project)
        settingsApplier = SqlDialectsSettingsApplier(project, sqlDialectMappings)
    }

    @Test
    @Ignore("Light fixture fails on project.getProjectFile() access.")
    fun projectSqlDialectApplied() {
        settingsApplier.apply(SqlDialectsSettings(projectSqlDialect = SqlDialect.POSTGRESQL))
        assertThat(sqlDialectMappings.getMapping(project.projectFile)).isEqualTo(PgDialect.INSTANCE)
    }
}
