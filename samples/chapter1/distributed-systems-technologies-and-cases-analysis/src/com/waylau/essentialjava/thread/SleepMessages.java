package com.waylau.essentialjava.thread;

/**
 * Thread.sleep 可以让当前线程执行暂停一个时间段
 * 
 * @author <a href="http://waylau.com">waylau.com</a>
 * @date 2016年7月28日
 */
public class SleepMessages {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		String importantInfo[] = { 
				"Mares eat oats",
				"Does eat oats", 
				"Little lambs eat ivy",
				"A kid will eat ivy too" };

		for (int i = 0; i < importantInfo.length; i++) {

			// Pause for 4 seconds
			Thread.sleep(4000);

			// Print a message
			System.out.println(importantInfo[i]);
		}
	}

}
