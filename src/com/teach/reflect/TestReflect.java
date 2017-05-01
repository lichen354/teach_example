package com.etc.demo.reflect;
/**
 * 反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；
 * 这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。
 */
public class TestReflect {
	public static void main(String[] args) {
		String name1;
		String name2;
		String name3;
		Person person = new Person();
//		person.study();
		
		//实例化Class类对象
		try {
			Class<?> clazz1 = Class.forName("com.etc.demo.reflect.Person");
			name1 = clazz1.getName();
			
			Class<?> clazz2 = person.getClass(); 
			name2 = clazz2.getName();
			
			Class<?> clazz3 = Person.class;
			name3 = clazz3.getName();
			
			System.out.println(name1);
			System.out.println(name2);
			System.out.println(name3);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
