package com.etc.demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestReflect1 {
	
	public static void main(String[] args) {
		//��ȡ��ĸ�����ʵ�ֵĽӿ�
		try {
			Class<?> clazz = Class.forName("com.etc.demo.reflect.Person");
			Class<?>[] clazzs = clazz.getInterfaces();
			for(Class<?> claz : clazzs){
				System.out.println(claz.getName());;
			}
			
			Class<?> super_clazzs = clazz.getSuperclass();
			System.out.println(super_clazzs.getName());
			
			
			//�÷���ķ��� �������� һ  
			//ͨ��ʹ�� Class�����newInstance() ����
			Person person = (Person) clazz.newInstance();
			person.eat();
			System.out.println("--------------------------------------------------------");
			//�÷���ķ��� �������� ��
			//��ȡ ���캯��
			Constructor<?>[] cons = clazz.getConstructors();
			for(Constructor<?> con : cons){
				System.out.print(con.getName());
				Class<?>[] con_clazzs = con.getParameterTypes();
					System.out.print("(");
					for(Class<?> c : con_clazzs){
						System.out.print(c.getName()+", ");
					}
					System.out.println(")");
			}
			Person person1 = (Person)cons[0].newInstance();
			person1.eat();
			Person person2 = (Person)cons[1].newInstance("xiaoqiang","men");
			System.out.println(person2);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
