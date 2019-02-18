# IDEA Settings

An application that can be used to generate both `.idea` and `*.iml` files for
use by IntelliJ IDEA from a YAML settings file.

## Motivation

When importing a project, IntelliJ IDEA will create a number of `*.iml` files
and an `.idea` folder containing metadata about the project.
On large projects, this will consume a non-trivial amount of time.
If we can pre-compute these files, developers can instead download and extract
them and commence developing more quickly.

## Generating `*.iml` files

To generate iml files for a given project:

```sh
bazel run //:iml-generator <project-directory>
```

## Future goals

Add ability to configure options like excluded folders via a `.yml` file.

## Development

### Updating dependencies

This projects uses [bazel-deps](https://github.com/johnynek/bazel-deps).
To update a maven dependency, modify [`third_party/dependencies.yaml`].
Then, checkout the aforementioned repo and run:

```sh
bazel run //:parse -- generate --repo-root <iml-generator-checkout> --sha-file
third_party/package-lock.bzl --deps third_party/dependencies.yaml
```
