package com.teach.io;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class CharSetTest {
	/**
	 * char  使用的是java默认的字符集编码表  unicode    
	 * unicode是对ascii的扩展
	 * ascii 采用的是一个字节   unicode使用两个字节(前128为就是ascii)    utf-8是unicode的改进版  有一个编码头  a 两个个字节  汉字三个字节 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String str = "abcdefg";
		
		System.out.println(str.codePointAt(0)); //unicode
		
		StringBuffer sb = new StringBuffer("abcdefg");
		System.out.println(str.contentEquals(sb));
		
		
		//eclipse 我们在编辑器写 字符的时候就已经制定了它的编码格式 即 str1 
		String str1 = "中国";//默认根据操作系统的字符集  gbk
		String str2 = new String(str1.getBytes(), "ascii");
		System.out.println(str2);
		
		
		
		
	
	}
}
