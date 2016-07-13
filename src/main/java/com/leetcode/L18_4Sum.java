package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhailz
 *
 * 时间：2016年5月20日 ### 上午11:18:18
 */
public class L18_4Sum {

	/*Given an array S of n integers, are there elements a, b, c, and d in S 
	 * such that a + b + c + d = target? Find all unique quadruplets in the 
	 * array which gives the sum of target.
	
			Note:
			Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
			The solution set must not contain duplicate quadruplets.
			    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
	
			    A solution set is:
			    (-1,  0, 0, 1)
			    (-2, -1, 1, 2)
			    (-2,  0, 0, 2)
	
	*/

	//	where is the road,what do you want?what do you have? what will you spend?
	public List<List<Integer>> fourSum(int[] nums, int target) {
		//特殊情况判定
		if(nums.length < 4){
			return null;
		}
		List<List<Integer>> value = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				for (int j2 = j+1; j2 < nums.length; j2++) {
					for (int k = j2+1; k < nums.length; k++) {
						if(num(i,j,j2,k,nums,target)){
							value.add(Arrays.asList(i,j,j2,k));
						}
					}
				}
			}
		}
		
		return null;
	}

	private boolean num(int i, int j, int j2, int k, int[] nums, int target) {
		if(nums[i]+nums[j]+nums[j2]+nums[k] == target){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		L18_4Sum sun = new L18_4Sum();
		int[] nums  = new int[]{-495,-482,-455,-447,-400,-388,-381,-360,-350,-340,-330,-317,-308,-300,-279,-235,-209,-206,-188,-186,-171,-145,-143,-141,-137,-129,-121,-115,-97,-56,-47,-28,-20,-19,8,11,35,41,46,50,69,84,85,86,88,91,135,160,171,172,177,190,226,234,238,244,249,253,254,272,281,284,294,296,300,303,307,313,320,320,327,334,355,362,367,401,426,436,456,467,473,473,484};
		sun.fourSum(nums, -7178);

	}

}
