package com.algprithm.letcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhailzh
 * 
 * @Date 2016年1月22日——上午9:29:02
 * 
 * 一个已知的数组，找出所有的四个数字一组的和为某一个值得数组。
 */
public class Lettcode4Sum18 {

public List<List<Integer>> fourSum(int[] nums, int target) {
	List<List<Integer>>  res = new ArrayList<List<Integer>>();
	if(nums == null || nums.length < 4){
		return res;
	}
	
	//开始排序
	Arrays.sort(nums);
	
	int fir = 0; 
	int sec = 1;
	
	int thi =  nums.length-2 ;
	int thu =  nums.length -1 ;

	for (; fir < nums.length-3; fir++) {
		int temp = nums[fir]+nums[sec]+nums[thi]+nums[thu];
		if(temp == target){
			List<Integer> restemp = new ArrayList<Integer>();
			restemp.addAll(Arrays.asList(nums[fir],nums[sec],nums[thi],nums[thu]));
			res.add(restemp);
		}else if( temp < target){
			//相加的值比目标值要小，说明需要增加相加值，也就说需要增加fir 或者 sec
//			分为几种的情况，
//			1：sec+1 fir 不变
//			2 fir+1，sec+1 
//			 
//			总体就是sec必须加1，fir是否加1 ，需要看情况
			
			while(fir+1 < nums.length -3 && nums[fir+1] == nums[fir]) fir++;
			while(sec+1 < nums.length -3 && nums[sec+1] == nums[sec]) sec++;
		}
	}
	
	
	return null;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
