#!/bin/bash

# vim:foldmethod=marker:

# Do NOT invoke this directly - apply this via `bazel run apply_settings`

set -euo pipefail

# --- begin runfiles.bash initialization --- {{{
if [[ ! -d "${RUNFILES_DIR:-/dev/null}" && ! -f "${RUNFILES_MANIFEST_FILE:-/dev/null}" ]]; then
    if [[ -f "$0.runfiles_manifest" ]]; then
      export RUNFILES_MANIFEST_FILE="$0.runfiles_manifest"
    elif [[ -f "$0.runfiles/MANIFEST" ]]; then
      export RUNFILES_MANIFEST_FILE="$0.runfiles/MANIFEST"
    elif [[ -f "$0.runfiles/bazel_tools/tools/bash/runfiles/runfiles.bash" ]]; then
      export RUNFILES_DIR="$0.runfiles"
    fi
fi
if [[ -f "${RUNFILES_DIR:-/dev/null}/bazel_tools/tools/bash/runfiles/runfiles.bash" ]]; then
  # shellcheck disable=SC1090
  source "${RUNFILES_DIR}/bazel_tools/tools/bash/runfiles/runfiles.bash"
elif [[ -f "${RUNFILES_MANIFEST_FILE:-/dev/null}" ]]; then
  # shellcheck disable=SC1090
  source "$(grep -m1 "^bazel_tools/tools/bash/runfiles/runfiles.bash " \
            "$RUNFILES_MANIFEST_FILE" | cut -d ' ' -f 2-)"
else
  echo >&2 "ERROR: cannot find @bazel_tools//tools/bash/runfiles:runfiles.bash"
  exit 1
fi
# --- end runfiles.bash initialization --- }}}

idea_settings_jar=$(rlocation 'idea_settings/idea-settings.jar')
checkstyle_jar=$(rlocation 'CheckStyle-IDEA/lib/checkstyle-idea-.*.jar')
idea_sh=$(rlocation 'idea-IC/bin/idea')

idea_config_path=$(mktemp -d)
idea_system_path=$(mktemp -d)
idea_plugins_path=$(mktemp -d)
idea_properties_file=$(mktemp)
trap 'rm -rf ${idea_config_path} ${idea_system_path} ${idea_plugins_path} ${idea_properties_file}' INT TERM EXIT

{
  echo "idea.config.path=${idea_config_path}"
  echo "idea.system.path=${idea_system_path}"
  echo "idea.plugins.path=${idea_plugins_path}"
  echo "java.awt.headless=true"
} > "${idea_properties_file}"
export IDEA_PROPERTIES=$idea_properties_file

cp --force --target-directory "${idea_plugins_path}" \
  "${idea_settings_jar}" \
  "${checkstyle_jar}"

"${idea_sh}" applyIdeaSettings "$@"
