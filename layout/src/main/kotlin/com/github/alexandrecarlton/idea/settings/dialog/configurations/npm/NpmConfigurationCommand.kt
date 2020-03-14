package com.github.alexandrecarlton.idea.settings.dialog.configurations.npm

import com.fasterxml.jackson.annotation.JsonProperty

enum class NpmConfigurationCommand {

    @JsonProperty("access")
    ACCESS,

    @JsonProperty("add")
    ADD,

    @JsonProperty("adduser")
    ADDUSER,

    @JsonProperty("audit")
    AUDIT,

    @JsonProperty("bin")
    BIN,

    @JsonProperty("bugs")
    BUGS,

    @JsonProperty("build")
    BUILD,

    @JsonProperty("cache")
    CACHE,

    @JsonProperty("ci")
    CI,

    @JsonProperty("completion")
    COMPLETION,

    @JsonProperty("config")
    CONFIG,

    @JsonProperty("dedupe")
    DEDUPE,

    @JsonProperty("deprecate")
    DEPRECATE,

    @JsonProperty("dist-tag")
    DIST_TAG,

    @JsonProperty("docs")
    DOCS,

    @JsonProperty("edit")
    EDIT,

    @JsonProperty("explore")
    EXPLORE,

    @JsonProperty("help")
    HELP,

    @JsonProperty("help-search")
    HELP_SEARCH,

    @JsonProperty("init")
    INIT,

    @JsonProperty("install")
    INSTALL,

    @JsonProperty("info")
    INFO,

    @JsonProperty("link")
    LINK,

    @JsonProperty("logout")
    LOGOUT,

    @JsonProperty("ls")
    LS,

    @JsonProperty("npm")
    NPM,

    @JsonProperty("outdated")
    OUTDATED,

    @JsonProperty("owner")
    OWNER,

    @JsonProperty("pack")
    PACK,

    @JsonProperty("ping")
    PING,

    @JsonProperty("prefix")
    PREFIX,

    @JsonProperty("prune")
    PRUNE,

    @JsonProperty("publish")
    PUBLISH,

    @JsonProperty("rebuild")
    REBUILD,

    @JsonProperty("repo")
    REPO,

    @JsonProperty("restart")
    RESTART,

    @JsonProperty("root")
    ROOT,

    @JsonProperty("run")
    RUN,

    @JsonProperty("search")
    SEARCH,

    @JsonProperty("shrinkwrap")
    SHRINKWRAP,

    @JsonProperty("star")
    STAR,

    @JsonProperty("stars")
    STARS,

    @JsonProperty("start")
    START,

    @JsonProperty("stop")
    STOP,

    @JsonProperty("tag")
    TAG,

    @JsonProperty("team")
    TEAM,

    @JsonProperty("test")
    TEST,

    @JsonProperty("uninstall")
    UNINSTALL,

    @JsonProperty("unpublish")
    UNPUBLISH,

    @JsonProperty("update")
    UPDATE,

    @JsonProperty("version")
    VERSION,

    @JsonProperty("view")
    VIEW,

    @JsonProperty("whoami")
    WHOAMI;
}
