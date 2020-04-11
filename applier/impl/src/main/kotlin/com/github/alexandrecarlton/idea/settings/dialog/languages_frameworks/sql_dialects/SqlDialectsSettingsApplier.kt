package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.AMAZON_REDSHIFT
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.APACHE_CASSANDRA
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.APACHE_DERBY
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.APACHE_HIVE
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.APACHE_SPARK
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.CLICKHOUSE
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.EXASOL
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.GENERIC_SQL
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.GREENPLUM
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.H2
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.HSQLDB
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.IBM_DB2_ISERIES
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.IBM_DB2_LUW
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.IBM_DB2_Z_OS
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.MARIADB
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.MICROSOFT_SQL_SERVER
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.MYSQL
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.ORACLE
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.ORACLE_SQL_PLUS
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.POSTGRESQL
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.SNOWFLAKE
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.SQL92
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.SQLITE
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.SYBASE_ASE
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialect.VERTICA
import com.intellij.openapi.project.Project
import com.intellij.sql.dialects.SqlDialectMappings
import com.intellij.sql.dialects.cassandra.CassDialect
import com.intellij.sql.dialects.clickhouse.CHouseDialect
import com.intellij.sql.dialects.db2.Db2LUWDialect
import com.intellij.sql.dialects.db2.iseries.Db2ISDialect
import com.intellij.sql.dialects.db2.zos.Db2ZOSDialect
import com.intellij.sql.dialects.derby.DerbyDialect
import com.intellij.sql.dialects.exasol.ExaDialect
import com.intellij.sql.dialects.generic.GenericDialect
import com.intellij.sql.dialects.greenplum.GPlumDialect
import com.intellij.sql.dialects.h2.H2Dialect
import com.intellij.sql.dialects.hive.HiveDialect
import com.intellij.sql.dialects.hsql.HsqlDialect
import com.intellij.sql.dialects.maria.MariaDialect
import com.intellij.sql.dialects.mssql.MsDialect
import com.intellij.sql.dialects.mysql.MysqlDialect
import com.intellij.sql.dialects.oracle.OraDialect
import com.intellij.sql.dialects.oraplus.OraPlusDialect
import com.intellij.sql.dialects.postgres.PgDialect
import com.intellij.sql.dialects.redshift.RsDialect
import com.intellij.sql.dialects.snowflake.SFlakeDialect
import com.intellij.sql.dialects.spark.SparkDialect
import com.intellij.sql.dialects.sql92.Sql92Dialect
import com.intellij.sql.dialects.sqlite.SqliteDialect
import com.intellij.sql.dialects.sybase.AseDialect
import com.intellij.sql.dialects.vertica.VertDialect
import javax.inject.Inject

class SqlDialectsSettingsApplier @Inject
constructor(private val project: Project, private val sqlDialectMappings: SqlDialectMappings) : SettingsApplier<SqlDialectsSettings> {

    override fun apply(settings: SqlDialectsSettings) {
        settings.projectSqlDialect?.let { sqlDialectMappings.setMapping(project.projectFile, toSqlLanguageDialect(it)) }
    }

    private fun toSqlLanguageDialect(sqlDialect: SqlDialect) =
        when (sqlDialect) {
            AMAZON_REDSHIFT -> RsDialect.INSTANCE
            APACHE_CASSANDRA -> CassDialect.INSTANCE
            APACHE_DERBY -> DerbyDialect.INSTANCE
            APACHE_HIVE -> HiveDialect.INSTANCE
            APACHE_SPARK -> SparkDialect.INSTANCE
            CLICKHOUSE -> CHouseDialect.INSTANCE
            EXASOL -> ExaDialect.INSTANCE
            GENERIC_SQL -> GenericDialect.INSTANCE
            GREENPLUM -> GPlumDialect.INSTANCE
            H2 -> H2Dialect.INSTANCE
            HSQLDB -> HsqlDialect.INSTANCE
            IBM_DB2_ISERIES -> Db2ISDialect.INSTANCE
            IBM_DB2_LUW -> Db2LUWDialect.INSTANCE
            IBM_DB2_Z_OS -> Db2ZOSDialect.INSTANCE
            MARIADB -> MariaDialect.INSTANCE
            MICROSOFT_SQL_SERVER -> MsDialect.INSTANCE
            MYSQL -> MysqlDialect.INSTANCE
            ORACLE -> OraDialect.INSTANCE
            ORACLE_SQL_PLUS -> OraPlusDialect.INSTANCE
            POSTGRESQL -> PgDialect.INSTANCE
            SNOWFLAKE -> SFlakeDialect.INSTANCE
            SQL92 -> Sql92Dialect.INSTANCE
            SQLITE -> SqliteDialect.INSTANCE
            SYBASE_ASE -> AseDialect.INSTANCE
            VERTICA -> VertDialect.INSTANCE
        }
}
