package com.teach.proxy_dynamic;


public class ProxyTest {
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int c = 0;
		
		Icalculator icalculatorImp = new ICalculatorImp();
		c = icalculatorImp.add(a, b);
		System.out.println(c);
		
		Icalculator ic = new CalculatorProxy(icalculatorImp).getProxyInstance();
		ic.add(a, b);
	}
}
