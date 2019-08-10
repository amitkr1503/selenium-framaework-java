package com.selenium_framworknew.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.selenium_framworknew.common.ExcelReader;

public class AbstractSelenium {
	
	@BeforeTest
	public  void callCreateWebDriverInstanceMethod() 
	{
		WebDriverFactory.createWebDriverInstance();
	}

	@DataProvider(name="LoginData")
	public String[][] getDataLogin() {
		String myData[][] = { { "admin", "admin" }, { "amit", "amit" }, { "sharayu", "sharayu" } };
		return myData;
	}


@DataProvider(name="getCSVData")
public String[][] getCSVData() {
	File file = new File("C:\\Users\\amit\\Desktop\\LoginData.txt");
	String myData[][]=new String[5][2];
	
	try
	{
	FileReader fr= new FileReader(file);
	
	BufferedReader br= new BufferedReader(fr);
	
	String line="";
	
	
	int i=0;
	while ((line=br.readLine())!=null) {
//		System.out.println(line);
		myData[i]=line.split(",");
		i=i+1;
		
		
		
		
	}
}catch(Exception e)
	{
		e.printStackTrace();
	}
	return myData;
	}

	@DataProvider(name="ExcelData")
	public String[][] getExcelData(Method m) throws Throwable
	{
		return ExcelReader.getExcelTableArray(getFilePath(m.getDeclaringClass()), m.getName());
		
	}
	
	private static String getFilePath(Class<?> cls){
		System.out.println("******** getFilePath for class "+cls.getName());
		String strSourceClassName = cls.getResource(cls.getSimpleName()+".class").getPath();
		System.out.println("*************** resource path is "+strSourceClassName);
		try {
			strSourceClassName = URLDecoder.decode(strSourceClassName,"UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer strFilePath = new StringBuffer();
		strFilePath.append(strSourceClassName.subSequence(1, strSourceClassName.indexOf("com")));
		strFilePath.append(cls.getName().replace(".","/"));
		strFilePath.append(".xlsx");
		System.out.println("Class path is - "+strFilePath);
		//return strFilePath.toString();
		return strSourceClassName.replace(".class", ".xlsx");
	}
}
	

