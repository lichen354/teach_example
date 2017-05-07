package com.teach.proxy_dynamic;

public class ICalculatorImp implements Icalculator {

	@Override
	public int add(int i, int j) {
		System.out.println(i + " + " + j + " = " + (i+j));
		return i + j;
	}

}
