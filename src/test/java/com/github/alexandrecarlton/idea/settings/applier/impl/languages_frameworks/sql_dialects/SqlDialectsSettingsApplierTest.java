package com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks.sql_dialects;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.sql_dialects.ImmutableSqlDialectsSettings;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.sql_dialects.SqlDialect;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.sql_dialects.SqlDialectsSettings;
import com.intellij.sql.dialects.SqlDialectMappings;
import com.intellij.sql.dialects.postgres.PostgresDialect;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class SqlDialectsSettingsApplierTest extends IdeaSettingsTestFixture {

  private SettingsApplier<SqlDialectsSettings> settingsApplier;
  private SqlDialectMappings sqlDialectMappings;

  @Before
  public void setUp() {
    sqlDialectMappings = SqlDialectMappings.getInstance(project);
    settingsApplier = new SqlDialectsSettingsApplier(project, sqlDialectMappings);
  }

  @Test
  @Ignore("Light fixture fails on project.getProjectFile() access.")
  public void projectSqlDialectApplied() {
    settingsApplier.apply(ImmutableSqlDialectsSettings.builder()
      .projectSqlDialect(SqlDialect.POSTGRESQL)
      .build());
     assertThat(sqlDialectMappings.getMapping(project.getProjectFile()))
       .isEqualTo(PostgresDialect.INSTANCE);
  }

}
