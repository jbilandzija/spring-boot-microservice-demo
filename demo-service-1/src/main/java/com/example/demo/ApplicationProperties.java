package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@Configuration
//@PropertySource("file:/path/to/application.properties")
//@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {

	private String applicationName = "defaultAppname";

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	// ...

}



