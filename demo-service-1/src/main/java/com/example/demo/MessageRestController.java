package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {

    private static final String template = "Hello, %s! this is version 0.0.1";
    //private final ApplicationProperties applicationProperties;

    @Value("${welcome.message}")
    private String welcome;

    //public MessageRestController(ApplicationProperties applicationProperties) {
     //   this.applicationProperties = applicationProperties;
   // }

    @RequestMapping("/")
    public String getWelcomeMessage() {
        return this.welcome;
    }

    //@GetMapping("app-name-via-pojo")
    //public String getAppnameFromPojo() {
      //  return this.applicationProperties.getApplicationName();
    //}

    @RequestMapping("/version")
    public String version(@RequestParam(value = "name", defaultValue = "unknown user") String name) {
        return String.format(template, name);
    }
}


