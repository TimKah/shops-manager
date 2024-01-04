package com.study.shopsmanager.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.system.JavaVersion;
import org.springframework.core.SpringVersion;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
  @RequestMapping(value = "about", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public Map<String, String> about() {
    String springVersion = SpringVersion.getVersion();
    String javaVersion = JavaVersion.getJavaVersion().toString();

    Map<String, String> response = new HashMap<>(3);
    response.put("Spring version", springVersion);
    response.put("Java version", javaVersion);
    // DB info
    // Naming
    return response;
  }
}
