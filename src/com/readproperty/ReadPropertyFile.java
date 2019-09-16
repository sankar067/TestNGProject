/**
 * 
 */
package com.readproperty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author SANKAR
 *
 */
public class ReadPropertyFile {
	Properties pro;
	public ReadPropertyFile()
	{
		try {
			File src = new File("../MyLearningProject/Config/config.property");
			FileInputStream propertyfile= new FileInputStream(src);
			pro =new Properties();
			pro.load(propertyfile);
		}catch (Exception e) {
		System.out.println("Exception is : "+e.getMessage());
		}
	}
	
	public String GetPropertyData(String sKey)
	{
		return  pro.getProperty(sKey);
	}

}
