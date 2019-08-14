package com.adoptgoat.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() {
		
		File src = new File("./Configuration/Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Error while looking for Config.properties file");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Error in reading / writing in Config.properties file");
			System.exit(0);
		}
		
	}
	
	public String getValue(String key) {
		 
		return pro.getProperty(key);
	}

}
