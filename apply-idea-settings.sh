#!/bin/bash

# vim:foldmethod=marker:

# Do NOT invoke this directly - apply this via `bazel run apply_settings`

set -euo pipefail

# RUNFILES_LIB_DEBUG=1
# set -x

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

plugins_tar=$(rlocation 'idea_settings/plugins.tar')
idea_sh=$(rlocation 'idea-IC/bin/idea.sh')
idea_sh=${idea_sh:-$(rlocation 'idea-IU/bin/idea.sh')}
idea64_vmoptions=$(rlocation 'idea-IC/bin/linux/idea64.vmoptions')
idea64_vmoptions=${idea64_vmoptions:-$(rlocation 'idea-IU/bin/linux/idea64.vmoptions')}

idea_config_path=${IDEA_CONFIG_PATH:-$(mktemp -d)}
idea_system_path=${IDEA_SYSTEM_PATH:-$(mktemp -d)}
idea_properties_file=$(mktemp)
idea_vmoptions_file=$(mktemp)

mkdir -p "${idea_config_path}/plugins"
mkdir -p "${idea_system_path}"

# We clean up all generated files by default, unless we specified
# IDEA_CONFIG_PATH or IDEA_SYSTEM_PATH, in case we want to inspect or capture
# things like log files.
trap_statement="rm -rf ${idea_properties_file} ${idea_vmoptions_file}"
if [ -z "${IDEA_CONFIG_PATH-}" ]; then
  trap_statement="${trap_statement} ${idea_config_path}"
fi
if [ -z "${IDEA_SYSTEM_PATH-}" ]; then
  trap_statement="${trap_statement} ${idea_system_path}"
fi
trap '${trap_statement}' INT TERM EXIT

{
  echo "idea.config.path=${idea_config_path}"
  echo "idea.system.path=${idea_system_path}"
} > "${idea_properties_file}"
export IDEA_PROPERTIES="${idea_properties_file}"

cat "${idea64_vmoptions}" > "${idea_vmoptions_file}"
echo '-Djava.awt.headless=true' >> "${idea_vmoptions_file}"
export IDEA_VM_OPTIONS="${idea_vmoptions_file}"

tar -xf "${plugins_tar}" -C "${idea_config_path}/plugins"

"${idea_sh}" applyIdeaSettings "$@"
