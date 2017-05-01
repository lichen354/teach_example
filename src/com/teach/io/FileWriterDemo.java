package com.teach.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterDemo {
	public static void main(String[] args) {
		/**
		 * 创建一个可以往文件中写入 字符 数据的字符输出流对象
		 * 
		 * 既然是往一个文件中写入数据，那么在创建对象的时候，必须明确该文件（数据存储到哪儿）
		 * 
		 * 如果文件不存在，则会 自动创建
		 * 如果文件存在，则会 覆盖
		 * 
		 * 如果在构造函数中 加入 true ， 可以实现文件续写
		 */
		Writer writer = null;
		try {
//			Writer writer = new FileWriter("test.txt");
			writer = new FileWriter("test.txt",true);
			writer.write("haha");
			
			writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(writer != null){
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
