package com.citibank.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigData {

	public Properties prop;
	
	public ReadConfigData() throws IOException {
		File file=new File("./Configuration/config.properties");
		FileInputStream fi=new FileInputStream(file);
		prop=new Properties();
		prop.load(fi);
		
	}
	
	public String getUrl() {
		
		
		String url= prop.getProperty("url");
		return url;
	}
	
}
