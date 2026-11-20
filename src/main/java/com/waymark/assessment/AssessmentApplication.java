package com.waymark.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Cosmic Assessment Spring Boot application.
 */
@SpringBootApplication
public class AssessmentApplication {

  /**
   * Protected constructor to satisfy Checkstyle while allowing Spring Boot proxy instantiation.
   */
  protected AssessmentApplication() {
  }

  /**
   * Starts the Spring Boot application.
   *
   * @param args command-line arguments passed to the application
   */
  public static void main(final String[] args) {
    SpringApplication.run(AssessmentApplication.class, args);
  }
}
