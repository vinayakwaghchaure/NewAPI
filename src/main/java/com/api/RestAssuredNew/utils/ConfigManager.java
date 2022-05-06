package com.api.RestAssuredNew.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

	private static ConfigManager manager;
	private static final Properties prop=new Properties();


	private ConfigManager() throws IOException
	{
		//InputStream inputStream=ConfigManager.class.getResourceAsStream("../resource/config.properties");
		//prop.load(inputStream);
		
	//	prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/resource/config.properties");
		prop.load(ip);
		
	}


	public static ConfigManager getInstance() {

		if(manager==null)
		{
			synchronized (ConfigManager.class)
			{
				try {
					manager =new ConfigManager();

				} catch (IOException e) {
					e.printStackTrace();				}
			}
		}
		return manager;

	}
	
	
	public String getString(String key)
	{
		return System.getProperty(key, prop.getProperty(key));
	}
}
