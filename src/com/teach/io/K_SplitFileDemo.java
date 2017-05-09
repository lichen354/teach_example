package com.etc.demo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class K_SplitFileDemo {
	private static final int SIZE = 1024*1024;
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * 文件切割的方式
	 * 	|- 指定文大小
	 * 	|- 均分为多个文件
	 */
	public static void split(File file) throws IOException{
		//1-确定流对象
		InputStream is = new FileInputStream(file);
		
		OutputStream out = null;
		
		//2-按照 1M 切割
		byte[] buff = new byte[SIZE];
		
		int len = 0;
		int count = 1;
		while((len = is.read(buff)) != -1){
			out = new FileOutputStream( ++count + ".part");
			out.write(buff, 0, len);
		}
		
		is.close();
		out.close();
		
		
		//那么文件切好以后放在哪里呢;我们需要指定 文件夹下的文件
		File dir = new File("C:\\temp");
		if(!dir.exists())
			dir.createNewFile();
		out = new FileOutputStream( new File(dir,  ++count + ".part") );
	}
}
