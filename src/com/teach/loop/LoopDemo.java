package com.etc.demo.loop;

public class LoopDemo {
	public static void main(String[] args) {
		int sum = getSum(100);
		int sum1 = getSumLoop(100);
		System.out.println(sum1);
	}
	
	//循环求和
	public static int getSumLoop(int n){
		int sum = 0;
		for(int i = 0; i <= n; i ++){
			sum = sum + i;
		}
		return sum;
	}
	
	//递归 求和
	//方法的不断调用   
	//效率  和  内存占用
	public static int getSum(int n){
		if(n == 1){
			return 1;
		}else{
			return n + getSum(n-1);
		}
		
		
	}
}
