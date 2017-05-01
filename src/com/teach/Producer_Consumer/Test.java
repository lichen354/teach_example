package com.teach.Producer_Consumer;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		Producer p = new Producer();
		Consumer c = new Consumer();
		
		Thread.sleep(120);
		c.buy(p);
		c.buy(p);
		c.buy(p);
		Thread.sleep(120);
		c.buy(p);
		c.buy(p);
	}
}
