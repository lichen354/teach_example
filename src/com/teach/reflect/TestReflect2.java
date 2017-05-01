package com.etc.demo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestReflect2 {
	/**
	 * 获取属性
	 */
	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName("com.etc.demo.reflect.Person");
			//getFields() 获取不到private
			Field[] fields =  clazz.getFields();
			for(Field f : fields){
				System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType() + " " + f.getName());
			}
			
			
			//如何获取private属性
			Field[] dec_fields = clazz.getDeclaredFields();
			for(Field f : dec_fields){
				System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType() + " " + f.getName());
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
