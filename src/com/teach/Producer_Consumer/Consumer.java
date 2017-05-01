package com.teach.Producer_Consumer;

public class Consumer {
	public void buy(Producer p){
		Bread b = p.saleBread();
		if(b != null){
			System.out.println("^ ^ 买到了一个面包");
			p.saled();
		}else{
//			System.out.println("T_T 没有买到");
		}
	}
}
