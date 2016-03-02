package com.algprithm.letcode;

import java.util.Arrays;

/**
 * @author zhailzh
 * 
 * @Date 2015年11月17日——下午3:22:27
 * 
 */
public class DP {

	/*某国为了防御敌国的导弹袭击，发展出一种导弹拦截系统。但是这种导弹拦截系统有一个缺陷：
	  虽然它的第一发炮弹能够到达任意的高度，但是以后每一发炮弹都不能高于前一发的高度。某天，
	  雷达捕捉到敌国的导弹来袭。由于该系统还在试用阶段，所以只有一套系统，因此有可能不能拦截所有的导弹。
	  输入导弹依次飞来的高度（雷达给出的高度数据是不大于30000的正整数），计算这套系统最多能拦截多少导弹，
	如果要拦截所有导弹最少要配备多少套这种导弹拦截系统。
	输入格式
	　　一行，为导弹依次飞来的高度
	输出格式
	　　两行，分别是最多能拦截的导弹数与要拦截所有导弹最少要配备的系统数
	样例输入
	389 207 155 300 299 170 158 65
	样例输出
	6
	2
	题目分析：

	导弹拦截是一个经典问题：求一个序列的最长不上升子序列，以及求能最少划分成几组不上升子序列。第一问是经典动态规划，第二问直接的方法是最小路径覆盖，但是二分图匹配的复杂度较高，我们可以将其转化成求最长上升子序列，其最大值即等于不上升子序列的最小划分数。这就涉及到组合数学中偏序集的Dilworth定理。
	*/
	/**
	 * 最长不上升子序列
	 * 例如数组：a1,a2,a3,....,an 的最长的不上升子序列的  (ak,....,aj)
	 * 那么数组：a1,a2,a3,....,an,an+1 的最长的不上升子序列  an+1 如果比aj小，那么就是原来的
	 * (ak,...aj,an+1)
	 * */
	

    public static void intercept(int[] array) {  
        int n = array.length;  
        //最经典的地方，在这里d[] 代表的是发射了i枚导弹以后，还能拦截的导弹数（包括第i枚导弹）
        //所以说d[n] =1
        int[] d = new int[n];  
        int dmax, xh;  
        for (int i = n - 1; i >= 0; i--) { // 从后往前计算d[i]值  
            for (int j = i; j < n; j++) {
            	// array[j] <= array[i] 中的等于号，就表示包含了第i个导弹
                if ((array[j] <= array[i]) && (d[i] < d[j] + 1)) {  
                    d[i] = d[j] + 1;  
                    System.out.println("d[ "+i+"] :" + d[i]);
                }  
            }  
        }  
        dmax = 0;  
        xh = 1;  
        for (int i = 0; i < n; i++) { // 求出dmax  
            if (d[i] > dmax) {  
                dmax = d[i];  
                xh = i;  
            }  
        }  
        System.out.println(dmax); // 输出结果  ，最大的导弹数
        System.out.print(array[xh] + " ");
//        xh 表示的开始的位置，好巧妙的思考
        int temp = xh;  
        for (int i = xh + 1; i < n; i++) {  
            if (d[i] == d[temp] - 1) {  
                temp = i;  
                System.out.print(array[i] + " ");  
            }  
        }  
        System.out.println();  
    }  
    
    
    
//    问题描述
//    N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。   合唱队形是指这样的一种队形：
//    设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK， 
//    则他们的身高满足T1<...<Ti>Ti+1>…>TK(1<=i<=K)。   你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，
//    可以使得剩下的同学排成合唱队形。 
//    输入格式 Input Format      
//    输入的第一行是一个整数N(2<=N<=100)，表示同学的总数。第一行有n个整数，用空格分隔，第i个整数Ti(130<=Ti<=230)是第i位同学的身高(厘米)。 
//    输出格式 Output Format      输出包括得到的最优队列的同学个数 以及最终同学的身高排列
    
   /**
    * 关键在于定义子问题，问题是一个数组的，最长的升序子序列和最长的降序子序列
    * 我们可以定义一个m[i] 表示a[0,1,....,i]中 最长的升序子序列l[i] 和 最长的降序子序列的r[i]的长度 的和。
    * 然后求出m[i]的最大值，我们就能够算出最小的出队人数
    * */
    
    public static void makeQueue(int[] array){
    	// d 前置的序列 不包括当前的元素
    	int[] aid = new int[array.length];
    	int n = array.length;
    	
    	int[] bid = new int[array.length];
    	
    	
    	for (int i =0; i < n; i++) { // 从前向后计算d[i]的值
            for (int j = 0; j <= i; j++) {
                if ((array[j] < array[i]) && (aid[i] < aid[j] + 1)) {  
                    aid[i] = aid[j] + 1;  
                    System.out.println("前置[ "+i+"] :" + aid[i]);
                }  
            }  
        }
    	
    	
    	 for (int i = n - 1; i >= 0; i--) { // 从后往前计算d[i]值  
             for (int j = i; j < n; j++) {
                 if ((array[j] < array[i]) && (bid[i] < bid[j] + 1)) {  
                	 bid[i] = bid[j] + 1;  
                     System.out.println("后置[ "+i+"] :" + bid[i]);
                 }  
             }  
         } 
    	
    	  int max = 0;int midle = 0;
    	  for(int i = 0; i < n; i++)
    	  {
    	    if(max < aid[i] + bid[i]){
    	    	 max = aid[i] + bid[i]+1 ;  // 寻找最多合唱人数
    	    	    midle = i;
    	    }
    	     
    	  }
    	
    	  System.out.println("最多合唱的人是："+ max + "中间的位置： "+ midle );
    }

    
    
    public static void main(String[] args) {  
    	makeQueue(new int[] { 186 ,186, 150, 200, 160, 130, 197, 220});  
    } 
}
