package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects

import com.fasterxml.jackson.annotation.JsonProperty

enum class SqlDialect {

    @JsonProperty("Amazon Redshift")
    AMAZON_REDSHIFT,

    @JsonProperty("Apache Cassandra")
    APACHE_CASSANDRA,

    @JsonProperty("Apache Derby")
    APACHE_DERBY,

    @JsonProperty("Apache Hive")
    APACHE_HIVE,

    @JsonProperty("Apache Spark")
    APACHE_SPARK,

    @JsonProperty("ClickHouse")
    CLICKHOUSE,

    @JsonProperty("Exasol")
    EXASOL,

    @JsonProperty("Generic SQL")
    GENERIC_SQL,

    @JsonProperty("Greenplum")
    GREENPLUM,

    @JsonProperty("H2")
    H2,

    @JsonProperty("HSQLDB")
    HSQLDB,

    @JsonProperty("IBM Db2 iSeries")
    IBM_DB2_ISERIES,

    @JsonProperty("IBM Db2 LUW")
    IBM_DB2_LUW,

    @JsonProperty("IBM Db2 z/OS")
    IBM_DB2_Z_OS,

    @JsonProperty("MariaDB")
    MARIADB,

    @JsonProperty("Microsoft SQL Server")
    MICROSOFT_SQL_SERVER,

    @JsonProperty("MySQL")
    MYSQL,

    @JsonProperty("Oracle")
    ORACLE,

    @JsonProperty("Oracl SQL*Plus")
    ORACLE_SQL_PLUS,

    @JsonProperty("PostgreSQL")
    POSTGRESQL,

    @JsonProperty("Snowflake")
    SNOWFLAKE,

    @JsonProperty("SQL92")
    SQL92,

    @JsonProperty("SQLite")
    SQLITE,

    @JsonProperty("Sybase ASE")
    SYBASE_ASE,

    @JsonProperty("Vertica")
    VERTICA
}
