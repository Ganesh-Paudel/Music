package com.senagh.music.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** Provides a basic HTTP liveness response; it does not probe database health. */
@RestController
public class HealthController {

  @GetMapping("/api/health")
  public String health() {
    return "Backend is running";
  }
}
