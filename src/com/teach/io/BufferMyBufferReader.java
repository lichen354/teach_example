package com.teach.io;

import java.io.FileReader;
import java.io.IOException;

/**
 * 模拟一个bufferedReader
 *
 * 分析
 * 缓冲区其实就是封装了一个数组
 * 并对外提供更多的方法对数组进行访问
 * 其实这些方法最终都是操作这个数组的下标 
 *
 * 缓冲的原理
 * 其实就是从源中获取一批数据装进缓冲区中
 * 再从缓冲区中不断的取出一个一个数据
 * 
 * 去完以后，再从源中继续区下一批数据进缓冲区
 * 当源中取完时 用 -1 作为结束标记
 */
public class BufferMyBufferReader {
	private FileReader r;
	
	//定义一个数组缓冲区
	private char[] buf = new char[1024];
	
	//定义一个计数器 记录缓冲区数据个数。当数据减到 0 时 从源中继续读取数据进 缓冲区
	private int index = 0;
	
	private int count = 0;
	
	//从缓冲区获取一个字符
	public int myRead() throws IOException{
		char ch;
		
		if(count == 0){
			count = r.read(buf);
			index = 0;
		}
		ch = buf[index];//先取数据  再操作角标
		index ++;
		count --;
		
		return ch;
	}
	
	public String myReadline() throws IOException{
		//存字符的容器
		StringBuffer sb = new StringBuffer();
		
		int ch;
		
		while((ch = myRead()) != -1){
			if(ch == '\r') continue;
			if(ch == '\n') return sb.toString();
			
			sb.append(ch);
		}
		//演示以后加以下代码 test.txt 文件最后一行不回车 则最后一行丢失 应为没有回车符
		//if(sb.length() != 0) return sb.toString();
		
		return null;
	}
	
	
	public static void main(String[] args) {
		System.out.println('a' == 97);
	}
}
