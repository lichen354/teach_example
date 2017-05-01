package com.teach.thread;



class Resources{
	private String name;
	private int count = 1;
	private boolean flag = false;

	public synchronized void produced(String name){
		if(flag){   
			try {this.wait();} catch (InterruptedException e) {e.printStackTrace();}
		}
		this.name = name + count;  //t0 馒头1   t1  wait  
		count ++;
		System.out.println(Thread.currentThread().getName() + " 生产了........." + this.name);
		flag = true;
		notify();
	}
	
	public synchronized void customed(){ 
		if(!flag){    //t2
			try {this.wait();} catch (InterruptedException e) {e.printStackTrace();}
		}
		System.out.println(Thread.currentThread().getName() + " 消费了...." + this.name);
		flag = false;
		notify();
	}
	
}



class Productor implements Runnable{
	Resources r;
	
	public Productor(Resources r){
		this.r = r;
	}
	
	@Override
	public void run() {
		while(true){
			r.produced("馒头");
			try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
	
}

class Consumer implements Runnable{
	private Resources r;
	public Consumer(Resources r){
		this.r = r;
	}
	
	@Override
	public void run() {
		while(true){
			r.customed();
			try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
		}
		
	}
	
}
public class ProducterConsumer {
	public static void main(String[] args) {
		//创建资源
		Resources r = new Resources();
		//创建任务
		Productor p = new Productor(r);
		Consumer c = new Consumer(r);
		//创建线程
		Thread t0 = new Thread(p);
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		Thread t3 = new Thread(c);
		
		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}
}