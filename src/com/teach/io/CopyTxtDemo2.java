package com.teach.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 需求： 复制文本文件
 *  使用数组
 */
public class CopyTxtDemo2 {
	private final static int BUFFER_SIZE = 1024;
	
	public static void main(String[] args) {
		//1-获取文件流
		FileReader fr = null;
		FileWriter fw = null;
		//2-频繁的读写操作
		try {
			fr = new FileReader("test.txt");
			fw = new FileWriter("test_copy.txt");
			
			//创建临时存储容器
//			char[] chars = new char[1024];
			char[] chars = new char[BUFFER_SIZE];
			int len = 0;
			while((len = fr.read(chars)) != -1){
				fw.write(chars, 0, len);
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
