package com.teach.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
	public static void main(String[] args) {
		Resources5 r5 = new Resources5();
		
		Productor5 p5 = new Productor5(r5);
		Consumer5 c5 = new Consumer5(r5);
		
		Thread t0 = new Thread(p5);
		Thread t1 = new Thread(p5);
		Thread t2 = new Thread(c5);
		Thread t3 = new Thread(c5);
		
		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}
	
}

class Resources5{
	private String name;
	private int count = 1;
	private List<String> list = new ArrayList<String>();
	Lock lock = new ReentrantLock();
	Condition con = lock.newCondition();
	
	public void produced(String name){
		lock.lock();
		try{
			while(list.size() > 10 ){   
				try {con.await();} catch (InterruptedException e) {e.printStackTrace();}
			}
			this.name = name + count;  //t0 馒头1   t1  wait  
			count ++;
			System.out.println(Thread.currentThread().getName() + " 生产了........." + this.name);
			list.add(this.name);
			con.signalAll();
		} finally{
			lock.unlock();
		}
	}
	
	public void customed(){ 
		lock.lock();
		try{
			while(list.size() < 1){    //t2
				try {con.await();} catch (InterruptedException e) {e.printStackTrace();}
			}
			String cus = list.get(list.size()-1);
			System.out.println(Thread.currentThread().getName() + " 消费了...." + cus);
			list.remove(cus);
			con.signalAll();
		} finally{
			lock.unlock();
		}
	}
	
}



class Productor5 implements Runnable{
	Resources5 r;
	
	public Productor5(Resources5 r){
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

class Consumer5 implements Runnable{
	private Resources5 r;
	public Consumer5(Resources5 r){
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