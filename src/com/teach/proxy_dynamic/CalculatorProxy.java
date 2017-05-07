package com.teach.proxy_dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

public class CalculatorProxy{
	private Icalculator target;
	
	public CalculatorProxy(Icalculator target){
		this.target = target;
	}
	
	
	public Icalculator getProxyInstance(){
		
		ClassLoader loader = target.getClass().getClassLoader();
		Class<?>[] interfaces = target.getClass().getInterfaces();
		InvocationHandler h = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("----- before -----");  
		        Object result = method.invoke(target, args);  
		        System.out.println("----- after -----");  
		        return result; 
			}
		};
		return (Icalculator) Proxy.newProxyInstance(loader, interfaces, h);
	}
	
	
	

}
