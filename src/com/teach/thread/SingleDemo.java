package com.teach.thread;
/**
 * 多线程下的单例
 * @author liqi
 *
 */
public class SingleDemo {


}
//饿汉式
class Single{
	private static final Single  s = new Single();
	private Single(){}
	
	public static Single getInstance(){
		return s;
	}
}


//懒汉
/*class Single1{
	private static Single1 s = null;
	private Single1(){}
	public Single1 getInstance(){
		if(s == null){
			s = new Single1();
		}
		return s;
	}
}*/
class Single1{
	private static Single1 s = null;
	private Single1(){}
//	public Single1 synchronized getInstance(){
	public Single1 getInstance(){
		//效率高
		if(s == null){
			synchronized (Single1.class) {
				if(s == null){
					s = new Single1();
				}
			}
		}
		return s;
	}
}