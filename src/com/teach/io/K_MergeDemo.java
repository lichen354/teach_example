package com.teach.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class K_MergeDemo {
	public static void main(String[] args) throws IOException {
		File dir = new File("D:\\temp");
		merge(dir);
	}
	
	
	/**
	 * 将多个文件合并到一个-----待测试
	 * @throws IOException 
	 */
	public static void merge(File dir) throws IOException{
		
		File[] files = dir.listFiles();
		if(files != null){
				
			//1-输出源
			File file = new File("D:\\out");
			if(!dir.exists())
				dir.mkdir();
			FileOutputStream out = new FileOutputStream(file);
			
			
			//2-输入源
			for(File f : files){
				FileInputStream fis = new FileInputStream(f);
				int len = 0;
				byte[] buf = new byte[1024];
				while((len = fis.read(buf)) != -1){
					out.write(buf, 0, len);
				}
				fis.close();
			}
			out.close();
		}
	}
}
