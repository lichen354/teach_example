package com.etc.demo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect4 {
	public static void main(String[] args) {
		try {
			//������÷���
			Class<?> clazz = Class.forName("com.etc.demo.reflect.Person");
			Method method = clazz.getDeclaredMethod("study",String.class, String.class);
			
			method.invoke(clazz.newInstance(), "a","b");
			
			
			//��������
			Object obj = clazz.newInstance();
			Field field = clazz.getDeclaredField("name");
			field.setAccessible(true);
			field.set(obj, "����");
			System.out.println(field.get(obj));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		
		
	}
}
