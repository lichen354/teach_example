package com.teach.thread;
/***
 * 线程安全---卖票
 * @author Administrator
 *
 */
public class TicketSell2 {
	
	/**
	 * 解决思路  讲共享数据的代码封装起来  当有线程执行这些代码的时候其他线程不可以参与运算
	 * 
	 * 同步的好处和弊端
	 * 
	 * 弊端 ： 相对降低了效率 因为同步外的线程都会判断同步锁 
	 * 
	 * 画图  cup 切换
	 * 
	 */
	public static void main(String[] args) {
		Ticket1 ticket = new Ticket1();
		
		Thread t1 = new Thread(ticket);
		Thread t2 = new Thread(ticket);
		Thread t3 = new Thread(ticket);
		Thread t4 = new Thread(ticket);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
	
}
class Ticket2 implements Runnable{
	int num = 100;
	Object obj = new Object();
	@Override
	public void run() {
		
		while(true){
			synchronized (obj) {
				if(num > 0){
					try {Thread.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}
					System.out.println(Thread.currentThread().getName()+"...."+num);
					num--;
				}
			}
		}
		
	}
	
}
