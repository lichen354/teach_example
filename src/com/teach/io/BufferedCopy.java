package com.teach.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedCopy {
	public static void main(String[] args) {
		//1-获取文件流
				FileReader fr = null;
				FileWriter fw = null;
				BufferedReader buffReader = null;
				BufferedWriter buffWriter = null;
				
				//2-频繁的读写操作
				try {
					fr = new FileReader("test.txt");
					fw = new FileWriter("test_copy.txt");
					
					buffReader = new BufferedReader(fr);
					buffWriter = new BufferedWriter(fw);
					
					/*int ch = 0;
					
					while((ch = fr.read()) != -1){
						fw.write(ch);
					}*/
					String line = null;
					while((line = buffReader.readLine()) != null){
						//这里可以对这行的字符进行操作  例如把a替换为b 或者添加字符  都可以
						buffWriter.write(line);
					}
					
					
				} catch (IOException e) {
					e.printStackTrace();
				} finally{
					//3-关闭流   关闭buffer 就已经关闭了流。因为bufferreader对
					if( fr != null && fw != null){
						try {
							fr.close();
							fw.close();
						} catch (IOException e) {e.printStackTrace();}
					}
				}
		
		
		
	}
}
