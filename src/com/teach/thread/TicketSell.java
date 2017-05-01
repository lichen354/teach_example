package com.teach.thread;
/***
 * 线程安全---卖票
 * @author Administrator
 *
 */
public class TicketSell {
	/***
	 * 线程安全问题产生的原因
	 * 1.多个线程在操作共享数据
	 * 
	 * 当一个线程操作这个数据时   其他线程也参与进运算
	 */
	
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		
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
class Ticket implements Runnable{
	int num = 100;
	@Override
	public void run() {
		
		while(num > 0){
			try {Thread.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}
			System.out.println(Thread.currentThread().getName()+"...."+num);
			num--;
		}
		
	}
	
}
