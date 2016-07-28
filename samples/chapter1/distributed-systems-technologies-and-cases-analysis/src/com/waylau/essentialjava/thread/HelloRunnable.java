package com.waylau.essentialjava.thread;

/**
 * 实现 Runnable 定义和启动一个线程
 * 
 * @author <a href="http://waylau.com">waylau.com</a>
 * @date 2016年7月28日
 */
public class HelloRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Hello from runnable!");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		(new Thread(new HelloRunnable())).start();
	}
}
