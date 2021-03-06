package com.dockdev.duckclicker;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class Config {

	public static Properties prop = new Properties();

	public void set(String title, String value) {
		try {
			prop.setProperty(title, value);
			prop.store(new FileOutputStream("config.file"), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String get(String title) {
		String value = "";

		try {
			prop.load(new FileInputStream("config.file"));
			value = prop.getProperty(title);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}
