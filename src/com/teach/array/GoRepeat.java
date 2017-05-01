package com.etc.demo.array;
/**
 * 数组去重
 * @author Administrator
 *
 */
public class GoRepeat {
	public static void main(String[] args) {
		int[] array = new int[]{1,4,6,3,2,6,7,2,4};
		
		int[] after = quchong(array);
		for(int i : after){
			System.out.print(i + " ");
		}
	}
	
	
	public static int[] quchong(int[] arr){
		int[] temp = new int[arr.length];
		int index = 1;
		temp[0] = arr[0];
		
		
		for(int i = 1; i < arr.length; i++){
		boolean isSame = false;	
			for(int j = i; j < arr.length-1; j++){
				if(arr[i] == arr[j+1]){
					isSame = true;
					break;
				}
			}
			if(!isSame){
				temp[index] = arr[i];
				index ++;
			}
		
		}
		
		return temp;
	}
}
