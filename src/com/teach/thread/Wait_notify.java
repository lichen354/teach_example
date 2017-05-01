package com.teach.thread;

/**
 * 多线程通讯
 * 多个线程在处理同一资源   但是任务不同
 * 画图
 * 如何输出 john lili 间隔输出 ---ThreadCommunication2
 */

public class Wait_notify {
	public static void main(String[] args) {
		//创建资源
		Resource r = new Resource();
		//创建任务
		Input in = new Input(r);
		OutPut out = new OutPut(r);
		//创建线程
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		//开启线程
		t1.start();
		t2.start();
		
	}
}

class Resource{
	String name;
	String sex;
}
/**
 * 输入
 */
class Input implements Runnable{
	Resource r;
	
	public Input(Resource r){
		this.r = r;
	}
	
	@Override
	public void run() {
		int x = 0;
		while(true){
			
			if(x == 0){
				r.name = "john";
				r.sex = "men";
			}else{
				r.name = "lili";
				r.sex = "women";
			}
			x = (x+1) % 2;
		}
		
	}
	/*@Override
	public void run() {
		int x = 0;
		while(true){
			synchronized(r){
				if(x == 0){
					r.name = "john";
					r.sex = "men";
				}else{
					r.name = "lili";
					r.sex = "women";
				}
				x = (x+1) % 2;
			}
		}
		
	}*/
}

class OutPut implements Runnable{
	Resource r;
	
	public  OutPut(Resource r){
		this.r = r;
	}
	@Override
	public void run() {
		while(true){
			System.out.println(r.name + "         " + r.sex);
		}
	}
	/*@Override
	public void run() {
		while(true){
			synchronized(r){
				System.out.println(r.name + "         " + r.sex);
			}
		}
		
	}*/
	
}








