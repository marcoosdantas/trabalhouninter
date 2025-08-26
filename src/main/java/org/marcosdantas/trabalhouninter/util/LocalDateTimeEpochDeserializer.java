package org.marcosdantas.trabalhouninter.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class LocalDateTimeEpochDeserializer extends JsonDeserializer<LocalDateTime> {
  @Override
  public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    long value = p.getLongValue();
    if (value < 1_000_000_000_000L) {
      value = value * 1000;
    }
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(value), ZoneId.systemDefault());
  }
}