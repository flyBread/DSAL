package com.zlz.leetcode.numbers;

/**
 * @author zhailzh
 * 
 * @Date 2015111411:20:19
 * Median of Two Sorted Arrays
 * 
 */
public class L04MedianofTwoSortedArrays {

	
	/*There are two sorted arrays nums1 and nums2 of size m and n respectively.

	Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

	Example 1:
	nums1 = [1, 3]
	nums2 = [2]

	The median is 2.0
	Example 2:
	nums1 = [1, 2]
	nums2 = [3, 4]
	The median is (2 + 3)/2 = 2.5
	*/
	public static void main(String[] args) {

		L04MedianofTwoSortedArrays st = new L04MedianofTwoSortedArrays();
		
		int[] nums1 = new int[]{2,3,4,5,6};
		int[] nums2 = new int[]{1};
		double value1 = st.findMedianSortedArrays(nums1, nums2);
		System.out.println(value1);
		
		double value2 = st.findMedianSortedArrays2(nums1, nums2);
		System.out.println(value2);
		
	}

	/**
	 * 快速排序的变形的算法
	 * */
	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		
		    int m = nums1.length, n = nums2.length;
	        int l = (m + n + 1) / 2;
	        int r = (m + n + 2) / 2;
	        
	        //找到第一个中间值
	        double left = getkth(nums1, 0, nums2, 0, l);
	        //找到第二个中间值
	        double right = getkth(nums1, 0, nums2, 0, r);
	        return (left + right) / 2.0;
	}
	
	
	public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
	    if (aStart > A.length - 1) return B[bStart + k - 1];            
	    if (bStart > B.length - 1) return A[aStart + k - 1];                
	    if (k == 1) return Math.min(A[aStart], B[bStart]);

	    int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
	    if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1]; 
	    if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];        

	    if (aMid < bMid) 
	        return getkth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft 
	    else 
	        return getkth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
	}
	

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    double now=0;
	    double pre=0;
	    int n = (nums1.length+nums2.length)/2+1;
	    int i=0;
	    int j=0;
	    int k=0;
	    while(k<n){
	        pre = now;
	        if(i==nums1.length){
	            now = nums2[j++];
	        }
	        else if(j==nums2.length){
	            now = nums1[i++];
	        }
	        else{
	        	now = nums1[i]<nums2[j]?nums1[i++]:nums2[j++];
	        } 
	        k++;
	    }
	    return (nums1.length+nums2.length)%2==1?now:(pre+now)/2;
	}
	
	
	public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		int[] sum = new int[nums1.length+ nums2.length];
		for (int i = 0; i < sum.length; i++) {
			if(n > 0){
				if(i> n-1){
					sum[i] = nums2[i-n];
				}else{
					sum[i] = nums1[i];	
				}
			}else if(m > 0){
				if(i> m-1){
					sum[i] = nums2[i-m];
				}else{
					sum[i] = nums2[i];	
				}
			}else{
				return 0;
			}
		}
		
		quickSort(sum);
		
		double median=(double) ((n+m)%2 == 1? sum[(n+m)>>1]:(sum[(n+m-1)>>1]+sum[(n+m)>>1])/2.0); 
		return median;
	}

	public static void quickSort(int[] arrays) {
	    quickSort(arrays, 0, arrays.length - 1);
	  }

	  private static void quickSort(int[] arrays, int i, int j) {
	    if (i < 0 || j > arrays.length - 1) {
	      throw new IllegalArgumentException("ĲķΧ");
	    }

	    if (i < j) {
	      int index = quickSortContent(arrays, i, j);
	      quickSort(arrays, i, index - 1);
	      quickSort(arrays, index + 1, j);
	    }
	  }

	  private static int quickSortContent(int[] arrays, int i, int j) {
	    int key = arrays[i];
	    int ii = i + 1;
	    for (int k = i + 1; k <= j; k++) {
	      if (arrays[k] <= key) {
	        swap(arrays, ii, k);
	        ii++;
	      }
	    }
	    swap(arrays, ii - 1, i);
	    return ii - 1;
	  }

	  private static void swap(int[] arrays, int ii, int k) {
	    int temp = arrays[ii];
	    arrays[ii] = arrays[k];
	    arrays[k] = temp;
	  }

	
	
}


