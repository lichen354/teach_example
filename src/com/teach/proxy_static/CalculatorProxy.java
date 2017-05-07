package com.teach.proxy_static;

public class CalculatorProxy implements Icalculator{
	private Icalculator target;
	
	public CalculatorProxy(Icalculator target){
		this.target = target;
	}
	
	@Override
	public int add(int i, int j) {
		System.out.println("befor...");
		int result = target.add(i, j);
		System.out.println("after...");
		return result;
	}

}
