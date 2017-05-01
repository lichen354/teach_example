package com.etc.demo.reflect;
/**
 * ���������������״̬�У���������һ���࣬���ܹ�֪���������������Ժͷ�������������һ�����󣬶��ܹ�������������һ�����������ԣ�
 * ���ֶ�̬��ȡ����Ϣ�Լ���̬���ö���ķ����Ĺ��ܳ�Ϊjava���Եķ�����ơ�
 */
public class TestReflect {
	public static void main(String[] args) {
		String name1;
		String name2;
		String name3;
		Person person = new Person();
//		person.study();
		
		//ʵ����Class�����
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
