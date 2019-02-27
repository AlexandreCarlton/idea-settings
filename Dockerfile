# Temporary docker file made until we can get this built by bazel itself.
FROM alexandrecarlton/bazel:0.23.0

COPY . /idea-settings
WORKDIR /idea-settings
RUN bazel build //:idea-settings

ENTRYPOINT ["bazel", "run" "//:idea-settings"]
