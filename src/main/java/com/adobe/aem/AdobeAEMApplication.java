package com.adobe.aem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Spring boot main application.
 *
 * @author ravi shanker katta
 * @since 2021 Aug
 * @version 1.0
 */
@SpringBootApplication
@PropertySources({@PropertySource("classpath:application-aem.properties")})
public class AdobeAEMApplication {

  public static void main(String[] args) {
    SpringApplication.run(AdobeAEMApplication.class, args);
  }
}
