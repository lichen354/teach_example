package com.teach.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
	/**
	 * read
	 * read(char[])
	 * @param args
	 */
	public static void main(String[] args) {
		FileReader fr = null;		
		try {
			fr = new FileReader("test.txt");
			
//			int ch = fr.read();
			
			char[] chars = new char[4];//suggest 1024 * n
			/*int num = fr.read(chars);
			System.out.println("num: " + num + " " + new String(chars));
			
			int num1 = fr.read(chars);
			System.out.println("num1: " + num1 + " " + new String(chars));
			
			int num2 = fr.read(chars);
			System.out.println("num2: " + num2 + " " + new String(chars));
			
			int num3 = fr.read(chars);
			System.out.println("num3: " + num3 + " " + new String(chars));
			*/
			int nums;
			while((nums = fr.read(chars)) != -1){
				System.out.println("num: " + nums + " " + new String(chars, 0, nums));
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
