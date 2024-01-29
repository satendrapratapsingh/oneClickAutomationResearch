package org.example;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;

	private final String configFilePath = "configs//config.properties";

	public ConfigFileReader() {

		File ConfigFile = new File(configFilePath);

		try {

			FileInputStream configFileReader = new FileInputStream(ConfigFile);

			properties = new Properties();

			try {

				properties.load(configFileReader);

				configFileReader.close();

			} catch (IOException e)

			{

				System.out.println(e.getMessage());

			}

		} catch (FileNotFoundException e)

		{

			System.out.println(e.getMessage());

			throw new RuntimeException("config.properties not found at config file path " + configFilePath);

		}

	}

	public String getApplicationUrl() {

		String applicationurl = properties.getProperty("catalyst.url.base");

		if (applicationurl != null)

			return applicationurl;

		else

			throw new RuntimeException("Application url not specified in the config.properties file.");

	}

	public String getTitle() {

		String title = properties.getProperty("catalyst.title");

		if (title != null)

			return title;

		else

			throw new RuntimeException("title not specified in the config.properties file.");

	}
	
	public String getUserName() {

		String username = properties.getProperty("username");

		if (username != null) {

			return username;
		}
	
		else

			throw new RuntimeException("username not specified in the config.properties file.");

	}
	
	public String getSignedUserName() {

		String signedin_username = properties.getProperty("signedin.username");
		
		if (signedin_username != null) {
			return signedin_username;
		}
		
		else

			throw new RuntimeException("signedin username not specified in the config.properties file.");

	}
	

	public String getPassword() {

		String password = properties.getProperty("password");

		if (password != null)

			return password;

		else

			throw new RuntimeException("password not specified in the config.properties file.");

	}

	public String getBrowser() {

		String browser = properties.getProperty("browser");

		if (browser != null)

			return browser;

		else

			throw new RuntimeException("browser not specified in the config.properties file.");

	}

	public long getTimeout() {

		String timeout = properties.getProperty("timeout");

		if (timeout != null)

			return Long.parseLong(timeout);

		else

			throw new RuntimeException("Timeout not specified in the config.properties file.");

	}

	public String getEnvironment() {

		String environment = properties.getProperty("environment");

		if (environment != null)

			return environment;

		else
			throw new RuntimeException("Environment not specified in the config.properties file.");

	}
}
