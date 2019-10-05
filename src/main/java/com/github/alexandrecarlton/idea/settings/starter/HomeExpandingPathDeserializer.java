package com.github.alexandrecarlton.idea.settings.starter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;

import java.io.IOException;
import java.nio.file.Path;

/**
 * A custom {@link Path} deserialiser that:
 *  - resolves the path relative to the project checkout.
 *  - expands {@code ~} to the user's home directory.
 * Note that this requires that the path exist on the user's filesystem.
 */
public class HomeExpandingPathDeserializer extends StdScalarDeserializer<Path> {

  private final Path basePath;

  public HomeExpandingPathDeserializer(Path basePath) {
    this(basePath, null);
  }

  private HomeExpandingPathDeserializer(Path basePath, Class<?> vc) {
    super(vc);
    this.basePath = basePath;
  }

  @Override
  public Path deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
    return basePath.resolve(jp.getValueAsString()
        .replace("~", System.getProperty("user.home")))
        .toRealPath();
  }
}
