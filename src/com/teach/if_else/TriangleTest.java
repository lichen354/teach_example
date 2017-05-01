package com.etc.demo.if_else;

public class TriangleTest{
	public static void main(String[] args) {
		Triangle t = new Triangle();
		t.whichTriangle(3, 4, 5);
	}
}

class Triangle {
	private int a;
	private int b;
	private int c;
	
	public void whichTriangle(int a, int b, int c){
		if(  a < b+c &  b < a+c & c < a+b ){
			if(a==b & b==c){
				System.out.println("正三角形");
			}else if(a*a == b*b + c*c || b*b == a*a + c*c || c*c == a*a + b*b){  //直角
				if(a == b || a == c || b == c){
					System.out.println("等腰直角三角形");
				}else{
					System.out.println("直角三角形");
				}
			}
			
		}else{
			System.out.println("不是三角形");
		}
		
	}
	
	
	
}
