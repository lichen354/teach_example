package com.teach.thread;
/**
 * 需求: 储户 两个 每个都到银存钱  共存3次
 * @author Administrator
 *
 */

/***
 * 同步函数 锁
 * 
 *同步函数使用的锁是this
 *
 *同步函数和同步代码块的区别
 *
 *建议使用同步代码块
 *
 *讲解 静态方法的锁  .class 对象
 */
public class Syn_method {
	
	public static void main(String[] args) {
		Cus c = new Cus();
		
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
	}
}
class Bank{
	private int sum;
	Object obj = new Object();
	
	public void add(int num){
		
		synchronized (obj) {
			sum = sum + num;
			System.out.println("sum="+sum);
		}
	}
}
class Cus implements Runnable{
	private Bank bank = new Bank();
	
	@Override
	public void run() {
		for(int i = 0; i < 3; i++){
			bank.add(100);
		}
	}
	
}