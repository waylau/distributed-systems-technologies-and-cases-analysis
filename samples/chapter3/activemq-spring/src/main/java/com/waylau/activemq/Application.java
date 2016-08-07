package com.waylau.activemq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 主程序入口
 * 
 * @author <a href="http://waylau.com">Way Lau</a> 
 * @date 2016年8月7日
 */
public class Application {
 
	public static void main(String[] args) {
		ApplicationContext context = 
		          new AnnotationConfigApplicationContext(Application.class);
		
	}

}
