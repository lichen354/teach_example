package com.teach.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class K_MergeDemo {
	public static void main(String[] args) {
		
	}
	
	/**
	 * 将多个文件合并到一个-----待测试
	 * @throws IOException 
	 */
	public static void merge(File dir) throws IOException{
		int fileNums = dir.list().length;
		if(fileNums > 0){
			FileInputStream[] fis = new FileInputStream[fileNums];
			
			FileOutputStream out = new FileOutputStream(new File("out"));
			
			for(int i = 0; i < fileNums; i++){
				fis[i] = new FileInputStream(new File(dir, ++i + ".part"));
				int len = 0;
				byte[] buf = new byte[1024];
				while((len = fis[i].read(buf)) != -1){
					out.write(buf, 0, len);
				}
				fis[i].close();
			}
			out.close();
		}
	}
}
