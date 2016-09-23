package com.zlz.utils;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhailz
 *
 * 时间：2016年9月23日 ### 上午9:48:48
 */
public class PrintUtil {
	private static Logger logger = LoggerFactory.getLogger("log");

	public static void printArray(int[] a) {
		logger.info(Arrays.toString(a));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
