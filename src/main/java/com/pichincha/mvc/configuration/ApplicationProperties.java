package com.pichincha.mvc.configuration;

import static lombok.AccessLevel.PRIVATE;

import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@FieldDefaults(level = PRIVATE)
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

  Header header;

  @Data
  @FieldDefaults(level = PRIVATE)
  public static class Header {

    String channel;
    String medium;
  }
}
