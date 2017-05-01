package com.teach.thread;

/**
 * 等待唤醒机制
 * 涉及的方法
 * wait()  让线程处于冻结状态， 被wait的线程会被存储到线程池中
 * notify()
 * notifyAll()
 */

public class Wait_notify2 {
	public static void main(String[] args) {
		//创建资源
		Resource2 r = new Resource2();
		//创建任务
		Input2 in = new Input2(r);
		OutPut2 out = new OutPut2(r);
		//创建线程
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		//开启线程
		t1.start();
		t2.start();
		
	}
}

class Resource2{
	String name;
	String sex;
	
	boolean flag;
}
/**
 * 输入
 */
class Input2 implements Runnable{
	Resource2 r;
	
	public Input2(Resource2 r){
		this.r = r;
	}
	
	
	@Override
	public void run() {
		int x = 0;
		while(true){
			synchronized(r){
				if(r.flag){   //resource 中有没有值
					try {r.wait();} catch (InterruptedException e) {e.printStackTrace();}
				}
				if(x == 0){
					r.name = "john";
					r.sex = "men";
				}else{
					r.name = "lili";
					r.sex = "women";
				}
				r.flag = true;
				r.notify();
				
			}
			x = (x+1) % 2;
		}
		
	}
}

class OutPut2 implements Runnable{
	Resource2 r;
	
	public  OutPut2(Resource2 r){
		this.r = r;
	}
	
	@Override
	public void run() {
		while(true){
			synchronized(r){
				if(!r.flag){
					try {r.wait();} catch (InterruptedException e) {e.printStackTrace();}
				}
				System.out.println(r.name + "         " + r.sex);
				r.flag = false;
				r.notify(); //查看aip
			}
		}
		
	}
	
}








