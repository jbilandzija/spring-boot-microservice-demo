package com.example.service1;

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



