package com.teach.thread;

/**
 * 优化 --> 
 */

public class Wait_notify3 {
	public static void main(String[] args) {
		//创建资源
		Resource3 r = new Resource3();
		//创建任务
		Input3 in = new Input3(r);
		OutPut3 out = new OutPut3(r);
		//创建线程
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		//开启线程
		t1.start();
		t2.start();
		
	}
}

class Resource3{
	private String name;
	private String sex;
	
	private boolean flag;
	
	public synchronized void set(String name, String sex){
		if(flag){   //resource 中有没有值
			try {this.wait();} catch (InterruptedException e) {e.printStackTrace();}
		}
		this.name = name;
		this.sex = sex;
			
		flag = true;
		this.notify();
	}
	public synchronized void out(){
		if(!flag){
			try {this.wait();} catch (InterruptedException e) {e.printStackTrace();}
		}
		System.out.println(name + "         " +sex);
		flag = false;
		notify(); //查看aip
	}
}
/**
 * 输入
 */
class Input3 implements Runnable{
	Resource3 r;
	
	public Input3(Resource3 r){
		this.r = r;
	}
	
	
	@Override
	public void run() {
		int x = 0;
		while(true){
			if(x == 0){
				r.set("john", "man");
			}else{
				r.set("lili", "woman");
			}
			x = (x+1) % 2;
		}
		
	}
}

class OutPut3 implements Runnable{
	Resource3 r;
	
	public  OutPut3(Resource3 r){
		this.r = r;
	}
	
	@Override
	public void run() {
		while(true){
			r.out();
		}
		
	}
	
}








