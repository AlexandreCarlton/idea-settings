# IML Generator

Can be used to generate `*.iml` files for use by IntelliJ IDEA.

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
