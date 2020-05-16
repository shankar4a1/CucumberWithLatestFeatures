package com.demo.framework.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class ConfigurationReader {

	 private Logger log = Log.getLogger(ConfigurationReader.class);
	    private Properties properties;
	    private String path = "config//ApplicationConfig.properties";
	    public ConfigurationReader()
	    {
	        BufferedReader reader;
	        try {
	            reader = new BufferedReader(new FileReader(path));
	            properties = new Properties();
	            try {
	                properties.load(reader);
	                reader.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            throw new RuntimeException("ApplicationConfig.properties not found at " + path);
	        }
	    }

	    public String getApplicationURL()
	    {
	        String URL = properties.getProperty("appURL");
	        if(URL!= null)
	            return URL;
	        else
	            throw new RuntimeException("Application URL not specified in the ApplicationConfig.properties file.");
	    }

	    public String getChromeDriverPath(){
	        String path = properties.getProperty("chromeDriverpath");
	        if(path!= null) {
	            String osname = System.getProperty("os.name").toLowerCase();
	            if(osname.contains("mac"))
	                return path;
	            else
	                return path+".exe";
	        }
	        else
	            throw new RuntimeException("Chrome driver path not specified in the ApplicationConfig.properties file.");
	    }

	    public String getGeckoDriverPath(){
	        String path = properties.getProperty("geckoDriverpath");
	        if(path!= null)
	        {
	            String osname = System.getProperty("os.name").toLowerCase();
	            if(osname.contains("mac"))
	                return path;
	            else
	                return path+".exe";
	        }
	        else
	            throw new RuntimeException("Gecko driver path not specified in the ApplicationConfig.properties file.");
	    }

	    public String getSecurityKey()
	    {
	        String securityKey = properties.getProperty("securityKey");
	        if(securityKey!= null)
	            return securityKey;
	        else
	            throw new RuntimeException("Security Key not specified in the ApplicationConfig.properties file.");
	    }

	    public String getPIN()
	    {

	        String pin = properties.getProperty("PIN");
	        if(pin!= null)
	            return pin;
	        else
	            throw new RuntimeException("PIN not specified in the ApplicationConfig.properties file.");

	    }

	    public String getBrowserName()
	    {

	        String browserName = properties.getProperty("browserName");
	        if(browserName!= null)
	            return browserName;
	        else
	            return "";

	    }

	    public String get(String key)
	    {
	        String value = properties.getProperty(key);
	        if(value!= null)
	            return value;
	        else
	            throw new RuntimeException(key + " not specified in the ApplicationConfig.properties file.");
	    }

	    /*public List<String> getNavigationButtonList()
	    {
	        String navigationButtons = properties.getProperty("navigationButtonList");
	        List<String> navigationButtonList = Arrays.asList(navigationButtons.split(","));
	        return navigationButtonList;
	    }*/
}