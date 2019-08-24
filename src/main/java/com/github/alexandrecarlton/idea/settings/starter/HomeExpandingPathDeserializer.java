package com.github.alexandrecarlton.idea.settings.starter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A custom {@link Path} deserialiser that expands {@code ~} to the user's home directory.
 */
public class HomeExpandingPathDeserializer extends StdScalarDeserializer<Path> {

  public HomeExpandingPathDeserializer() {
    this(null);
  }

  private HomeExpandingPathDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public Path deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
    return Paths.get(jp.getValueAsString()
        .replace("~", System.getProperty("user.home")));
  }
}
