package com.etc.demo.loop;

public class Fibonacci {
	public static void main(String[] args) {
		System.out.println("斐波那契数列的前10项为：");
		  for (int j = 1; j <= 10; j++) {
		   System.out.print(getFibo(j) + "\t");
		   }
	}
	
	
	public static int getFibo(int i) {
	  if (i == 1 || i == 2){
		  return 1;
		  
	  }else{
		  return getFibo(i - 1) + getFibo(i - 2);
	  }
	}
}
