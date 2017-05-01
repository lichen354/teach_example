package com.etc.demo.array;

public class Sort_ {
	public static void main(String[] args) {
		int[] array = new int[]{1,4,6,3,2,6,7,12,2,9};
	
		bubbleSort(array);
		
		for(int i : array){
			System.out.print(i + " ");
		}
	
	}
	
	
	//选择排序
	/**
	 * 原理   选出最小的元素  与第index位 交换
	 * 
	 * 选出最小
	 * 
	 * */
	public static void chooseSort(int[] arr){
		
		
		for(int i = 0; i < arr.length - 1; i++){ //第n趟排序
			int index = i;
			int min = arr[i];
			
			for(int j = i+1; j < arr.length-1; j++){
				if(min > arr[j]){
					index = j;
					min = arr[j];
				}
			}
			//遍历之后交换
			arr[index] = arr[i];
			arr[i] = min;
		}
		
	}
	
	
	/**
	 * 冒泡
	 * 重复比较相邻的两个元素，并在必要的时候交换双方位置
	 */
	public static void bubbleSort(int[] arr){
		int temp;
		
		for(int i = 0; i < arr.length; i++){
			
			for(int j = 0; j < arr.length-1; j++){
				if(arr[j] > arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * 插入排序
	 * 它跟我们牌扑克牌的方式相似。
	 * 每步将一个待排序的对象,按其排序码大小,插入到前面已经排好序的一组对象的适当位置上,直到对象全部插入为止
	 */
	
	
}
