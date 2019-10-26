# IDEA Settings

[![CircleCI](https://circleci.com/gh/AlexandreCarlton/idea-settings.svg?style=svg)](https://circleci.com/gh/AlexandreCarlton/idea-settings)

An application that can be used to generate both `.idea` and `*.iml` files for
use by [IntelliJ IDEA](https://www.jetbrains.com/idea/) from a
`.IDEA-settings.yml` file in a given project.

## Motivation

When importing a project, IntelliJ IDEA will create a number of `*.iml` files
and an `.idea` folder containing metadata about the project.
On large projects, this will consume a non-trivial amount of time.
If we can pre-compute these files, developers can instead download and extract
them and commence developing more quickly.

Furthermore, taking the time to set up a project can be costly and error prone.
Instead, we can store the configuration in a single file that all developers
can use to generate their settings, ensuring a standardised environment.

## What can be configured?

See the [example .IDEA-settings.yml](IDEA-settings-exampl.yml) which provides
an example of all possible settings that can currently be configured.

## Generating IDEA files

This project uses the [Bazel](https://bazel.build/) build tool to both build
and run this project. Please follow [the installation
instructions](https://docs.bazel.build/versions/master/install.html) to obtain
it.

To generate IDEA files for a given project, run the following from this
checkout:

```sh
bazel run //:apply-idea-settings <project-directory>
```

By default, this will run with the Community edition of IDEA.
To run the application with IDEA Ultimate:

```sh
bazel run --define product=ultimate //:apply-idea-settings <project-directory>
```

## Development

### Exposing configuration

The `.IDEA-settings.yml` configuration file is designed to mimic the
[Settings / Preferences Dialog](https://www.jetbrains.com/help/idea/settings-preferences-dialog.html).
The link provided will allow developers using the Community Edition of IDEA to
expose configuration that is exclusive to the Ultimate edition.

### Discovering configuration

Locating the classes that control IDEA configuration can be tricky, especially
in the Ultimate edition of IntelliJ IDEA (as the source is not available).
A process to locate the relevant classes is as follows:

 1. Configure the setting to be exposed in a sample project.
 1. Discover the file modified as a result of this (perhaps by grepping `.idea`).
 1. `zipgrep` the component/filename in the relevant plugin jar.

### Configuring IDEA configuration/system paths

By default, `//:apply-idea-settings` will create random temporary directories
for its configuration and system paths, which are cleaned up on exit.
To force it to use a fixed directory (to drop in useful configuration prior to
importing the project), one can set the following variables:

 - `IDEA_CONFIG_PATH`
 - `IDEA_SYSTEM_PATH`

If set, the corresponding directories will not be cleaned up for inspection.

### Inspecting logs

While warning logs are displayed when running `//:apply-idea-settings`, this is
not enough to diagnose issues.
IDEA will log all useful information to `log/idea.log` in its system path.
If `IDEA_SYSTEM_PATH` is set, one can use:

```sh
tail -f ${IDEA_SYSTEM_PATH}/log/idea.log
```

Otherwise, the following may be handy:

```sh
tail -f /tmp/*/log/idea.log
```

### Troubleshooting

#### `error: cannot access <class>`

Occasionally a compile error will reveal itself of the above form - add the
following library to ensure it continues compiling:

| Class | Dependency |
| ----- | ---------- |
| `AreaInstance` | `idea-IC//:lib/extensions` |
| `PersistentStateComponent` | `idea-IC//:lib/platform-api` |

### Updating dependencies

This projects uses [`bazel-deps`](https://github.com/johnynek/bazel-deps).
To update a Maven dependency, modify [`third_party/dependencies.yaml`](third_party/dependencies.yaml).
Then, checkout the aforementioned repository and run:

```sh
bazel run //:parse -- generate --repo-root <iml-generator-checkout> --sha-file third_party/package-lock.bzl --deps third_party/dependencies.yaml
```
