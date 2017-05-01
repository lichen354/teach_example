package com.etc.demo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestReflect2 {
	/**
	 * ��ȡ����
	 */
	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName("com.etc.demo.reflect.Person");
			//getFields() ��ȡ����private
			Field[] fields =  clazz.getFields();
			for(Field f : fields){
				System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType() + " " + f.getName());
			}
			
			
			//��λ�ȡprivate����
			Field[] dec_fields = clazz.getDeclaredFields();
			for(Field f : dec_fields){
				System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType() + " " + f.getName());
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
