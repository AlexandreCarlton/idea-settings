package com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks.sql_dialects;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.sql_dialects.SqlDialect;
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.sql_dialects.SqlDialectsSettings;
import com.intellij.openapi.project.Project;
import com.intellij.sql.dialects.SqlDialectMappings;
import com.intellij.sql.dialects.SqlLanguageDialect;
import com.intellij.sql.dialects.cassandra.CassandraDialect;
import com.intellij.sql.dialects.clickhouse.CHouseDialect;
import com.intellij.sql.dialects.db2.Db2ISDialect;
import com.intellij.sql.dialects.db2.Db2LUWDialect;
import com.intellij.sql.dialects.db2.Db2ZOSDialect;
import com.intellij.sql.dialects.derby.DerbyDialect;
import com.intellij.sql.dialects.exasol.ExasolDialect;
import com.intellij.sql.dialects.generic.GenericDialect;
import com.intellij.sql.dialects.greenplum.GPlumDialect;
import com.intellij.sql.dialects.h2.H2Dialect;
import com.intellij.sql.dialects.hive.HiveDialect;
import com.intellij.sql.dialects.hsql.HsqlDialect;
import com.intellij.sql.dialects.mariadb.MariaDialect;
import com.intellij.sql.dialects.mssql.MssqlDialect;
import com.intellij.sql.dialects.mysql.MysqlDialect;
import com.intellij.sql.dialects.oracle.OracleDialect;
import com.intellij.sql.dialects.oraplus.OraPlusDialect;
import com.intellij.sql.dialects.postgres.PostgresDialect;
import com.intellij.sql.dialects.redshift.RedshiftDialect;
import com.intellij.sql.dialects.snowflake.SFlakeDialect;
import com.intellij.sql.dialects.spark.SparkDialect;
import com.intellij.sql.dialects.sql92.Sql92Dialect;
import com.intellij.sql.dialects.sqlite.SqliteDialect;
import com.intellij.sql.dialects.sybase.SybaseDialect;
import com.intellij.sql.dialects.vertica.VerticaDialect;

public class SqlDialectsSettingsApplier implements SettingsApplier<SqlDialectsSettings> {

  private final Project project;
  private final SqlDialectMappings sqlDialectMappings;

  public SqlDialectsSettingsApplier(Project project, SqlDialectMappings sqlDialectMappings) {
    this.project = project;
    this.sqlDialectMappings = sqlDialectMappings;
  }

  @Override
  public void apply(SqlDialectsSettings settings) {
    settings.projectSqlDialect()
      .map(SqlDialectsSettingsApplier::toSqlLanguageDialect)
      .ifPresent(dialect -> sqlDialectMappings.setMapping(project.getProjectFile(), dialect));
  }

  private static SqlLanguageDialect toSqlLanguageDialect(SqlDialect sqlDialect) {
    switch (sqlDialect) {
      case AMAZON_REDSHIFT: return RedshiftDialect.INSTANCE;
      case APACHE_CASSANDRA: return CassandraDialect.INSTANCE;
      case APACHE_DERBY: return DerbyDialect.INSTANCE;
      case APACHE_HIVE: return HiveDialect.INSTANCE;
      case APACHE_SPARK: return SparkDialect.INSTANCE;
      case CLICKHOUSE: return CHouseDialect.INSTANCE;
      case EXASOL: return ExasolDialect.INSTANCE;
      case GENERIC_SQL: return GenericDialect.INSTANCE;
      case GREENPLUM: return GPlumDialect.INSTANCE;
      case H2: return H2Dialect.INSTANCE;
      case HSQLDB: return HsqlDialect.INSTANCE;
      case IBM_DB2_ISERIES: return Db2ISDialect.INSTANCE;
      case IBM_DB2_LUW: return Db2LUWDialect.INSTANCE;
      case IBM_DB2_Z_OS: return Db2ZOSDialect.INSTANCE;
      case MARIADB: return MariaDialect.INSTANCE;
      case MICROSOFT_SQL_SERVER: return MssqlDialect.INSTANCE;
      case MYSQL: return MysqlDialect.INSTANCE;
      case ORACLE: return OracleDialect.INSTANCE;
      case ORACLE_SQL_PLUS: return OraPlusDialect.INSTANCE;
      case POSTGRESQL: return PostgresDialect.INSTANCE;
      case SNOWFLAKE: return SFlakeDialect.INSTANCE;
      case SQL92: return Sql92Dialect.INSTANCE;
      case SQLITE: return SqliteDialect.INSTANCE;
      case SYBASE_ASE: return SybaseDialect.INSTANCE;
      case VERTICA: return VerticaDialect.INSTANCE;
      default:
        throw new IllegalArgumentException("Unhandled SQL Dialect for conversion: " + sqlDialect);
    }
  }
}
