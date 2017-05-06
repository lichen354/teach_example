package com.teach.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOTest {
	public static void main(String[] args) throws IOException {
		key2File();
	}
	
	/**
	 * 1-键盘到控制台
	 * 源：键盘   字节   FileInputSream
	 * 目的： 控制台 字节 FileOutPutStream
	 * 
	 * 需要转换吗？
	 * 不
	 * 
	 * 需要高效吗？
	 * BufferedInputStream
	 * BufferedOutPutStream
	 * 
	 */
	public static void key2Console(){
		
	}
	/**
	 * 2-键盘到文件
	 * 源: 键盘  字节流 InputStream
	 * 目的: 文件 字符流 Writer FileWriter
	 * 
	 * 需要转换么
	 * InPutStreamReader 
	 * 
	 * 想要高效么 bufferedReader bufferedWriter
	 * @throws IOException 
	 * 
	 * 
	 */
	public static void key2File() throws IOException{
		InputStream is = System.in;
		FileWriter fw = new FileWriter("key2file.txt");
		
		InputStreamReader isr = new InputStreamReader(is);
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufw = new BufferedWriter(fw);
		
		
		String str;
		while(true){
			str = bufr.readLine();
			if("over".equals(str)){
				break;
			}else{
				bufw.write(str.toUpperCase());
				bufw.newLine();
				bufw.flush();
			}
		}
		bufr.close();
		bufw.close();
	}
	/**
	 * 3- 读取文件内容到 控制台
	 * 源： 文件 fileReader fileInputeStream
	 * 目的： 控制台
	 * 
	 * 是文本文件么   fileReader
	 * 
	 * 需要转换么 inputStreamWriter
	 * 
	 * 需要高效么 buffered
	 */
	
	/**
	 * 4- copy
	 * 字节流干
	 * 是文本文件么  ？   中间需要做一些操作么   替换啊   统计字符个数啊    需要  字符流  而且是 缓冲字符流 bufferedR bufferedW
	 */
	
	
	/**
	 * 5- copy
	 * 是字符流么 ?
	 * 是 但是需要编码
	 * 这是 必须 使用桥梁  因为 这两个流有制定字符集转换的功能
	 */
	
}
