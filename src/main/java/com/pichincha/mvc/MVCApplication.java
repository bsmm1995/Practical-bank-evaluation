package com.pichincha.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({com.pichincha.mvc.configuration.ApplicationProperties.class})
public class MVCApplication {

  public static void main(String[] args) {
    SpringApplication.run(MVCApplication.class, args);
  }

}
