package com.teach.Producer_Consumer;

import java.util.List;

public class Producer{
//	private List<Bread> list;
	private Bread bread;
	
	public Producer(){
		new Thread(new Bake()).start();
		
	}
	
	public Bread saleBread(){
		if(bread == null){
			System.out.println("不好意思，没有面包了");
		}
		
		return bread;
	}
	public void saled(){
		this.bread = null;
	}
	
	class Bake implements Runnable{

		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Producer.this.bread = new Bread();
			}
			
		}
		
	}
}
