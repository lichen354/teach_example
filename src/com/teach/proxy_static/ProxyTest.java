package com.teach.proxy_static;

public class ProxyTest {
	public static void main(String[] args) {
		int i = 1;
		int j = 2;
		
		Icalculator icalaulatorimp = new IcalculatorImp();
		
		CalculatorProxy c = new CalculatorProxy(icalaulatorimp);
		c.add(i, j);
	}
}
