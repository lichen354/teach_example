package com.etc.demo.io;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
/**
 * File的常用操作
 * 
 * 1-获取
 * 	1.1 获取文件名称
 *  1.2获取文件大小
 *  1.3获取文件路径
 *  1.4获取修改日期
 *  
 * 2-文件的创建和删除
 * 3-文件夹的创建 和 删除
 * 
 * 注意 delete不走回收站
 */
public class FileTest {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.getTime();
		System.out.println(calendar.DATE);
		filterDemo();
	}
	
	public static void getDemo(){
	File file = new File("a.txt");
		
		String path = file.pathSeparator;
		String separactor = file.separator;
		System.out.println(path);
		System.out.println(separactor);
		
		
		long size = file.length();
		long lastTime = file.lastModified();
		
		Date date = new Date(lastTime);
		String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		
		System.out.println(str);
	}
	
	public static void createAndDeleteDemo(){
		File file = new File("a\\b\\c\\d\\e");
		file.mkdirs();
	}
	/**
	 * .list 获取所有文件
	 * .list(FilenameFilter ) 根据规则获取文件
	 */
	public static void filterDemo(){
		File file = new File("C:\\");
		
		file.list(new SuffixFilter(".java"));
		
		
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		System.out.println(cal.getTime());
	}
	
}
