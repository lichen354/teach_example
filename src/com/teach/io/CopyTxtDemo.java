package com.teach.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 需求： 复制文本文件
 *
 */
public class CopyTxtDemo {
	public static void main(String[] args) {
		//1-获取文件流
		FileReader fr = null;
		FileWriter fw = null;
		//2-频繁的读写操作
		try {
			fr = new FileReader("test.txt");
			fw = new FileWriter("test_copy.txt");
			
			int ch = 0;
			
			while((ch = fr.read()) != -1){
				fw.write(ch);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			//3-关闭流
			if( fr != null && fw != null){
				try {
					fr.close();
					fw.close();
				} catch (IOException e) {e.printStackTrace();}
			}
		}
	}
}
