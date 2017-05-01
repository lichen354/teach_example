package com.etc.demo.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestReflect3 {
	public static void main(String[] args) {
		//获取方法  学生自己练习 然后在讲
		try {
			Class<?> clazz = Class.forName("com.etc.demo.reflect.Person");
			
			Method[] methods = clazz.getDeclaredMethods();
			for(Method m : methods){
				m.getReturnType();
				Modifier.toString(m.getModifiers());
				m.getName();
				
				System.out.print(Modifier.toString(m.getModifiers())+" "+m.getReturnType()+" "+m.getName()+"");

				Class<?>[] clazzTpye = m.getParameterTypes();
				
				/*for(Class<?> c : clazzTpye){
					System.out.println(c.getName());;
				}*/
				
				System.out.print("(");
				for(int i = 0; i < clazzTpye.length; i++){
					if(i != clazzTpye.length-1){
						System.out.print(clazzTpye[i].getName()+", ");
					}else{
						System.out.print(clazzTpye[i].getName());
					}
				}
				System.out.println(")");
				
			}
		
		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
