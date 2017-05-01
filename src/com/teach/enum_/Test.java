package com.teach.enum_;

public class Test {
	static enum Color {RED, BULE, GRAY};
	
	
	public static void main(String[] args) {
		Color color = Color.RED;
		switch (color) {
		case RED:
			System.out.println("read");
			break;
		case BULE:
			System.out.println("blue");
			break;
				
		default:
			break;
		}
		
		//遍历
		for(Color c : Color.values()){
			System.out.println(c);
		}
	}
}
