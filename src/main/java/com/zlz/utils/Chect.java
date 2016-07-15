package com.zlz.utils;

/**
 * @author zhailz
 *
 * 时间：2016年7月15日 ### 上午10:10:08<br/>
 * 
 * 参数校验工作
 */
public class Chect {

	//判断数组是否为空数组
	public static boolean isNullOrEmptyArray(int[] a){
		if(a == null || a.length <= 0){
			return true;
		}else{
			return false;
		}
	}
	
	//判断数组不为空数组
	public static boolean isNotNullOrEmptyArray(int[] a){
		return !isNullOrEmptyArray(a);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
