package com.etc.demo.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
	public static void main(String[] args) throws IOException {
		readProp();
	}
	
	public static void propBase(){
		Properties prop = new Properties();
		
		prop.setProperty("zhangsan", "31");
		prop.setProperty("lisi", "29");
		prop.setProperty("wangwu", "18");
		
		
		String age_str = prop.getProperty("zhangsan");
		System.out.println(age_str);
	}
	
	public static void readProp() throws IOException{
		Properties prop = new Properties();
//		prop.load(new FileInputStream("demo.properties"));
		
		
		//加载字节码所在路径下
		prop.load(PropertiesDemo.class.getResourceAsStream("/demo.properties"));
		
		
		String sex = prop.getProperty("zhangsan.sex");
		System.out.println(sex);
	}
	
	
}
