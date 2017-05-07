package com.teach.proxy_static;

public class IcalculatorImp implements Icalculator{

	@Override
	public int add(int i, int j) {
		System.out.println(i + " + " + j + " = " + (i+j));
		return i + j;
	}

}
