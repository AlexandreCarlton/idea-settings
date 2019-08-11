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

## Why not the IntelliJ Configuration Script?

This is a plugin bundled with the default IntellIJ installation. It allows the
user to add run configurations via a YAML file in the repository. This project
has a similar goal, but with a much wider set of configuration in mind.

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

## Future goals

 - Maven configuration.

## Development

### Updating dependencies

This projects uses [`bazel-deps`](https://github.com/johnynek/bazel-deps).
To update a Maven dependency, modify [`third_party/dependencies.yaml`](third_party/dependencies.yaml).
Then, checkout the aforementioned repository and run:

```sh
bazel run //:parse -- generate --repo-root <iml-generator-checkout> --sha-file third_party/package-lock.bzl --deps third_party/dependencies.yaml
```
