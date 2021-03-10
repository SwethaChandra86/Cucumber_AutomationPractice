package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	
	/* this method used to load properties from config properties file
	 * @return properties prop object
	 */
	public Properties init_prop() {
		prop = new Properties();

		String path = (System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties");
		System.out.println(path);
		try {
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

}
