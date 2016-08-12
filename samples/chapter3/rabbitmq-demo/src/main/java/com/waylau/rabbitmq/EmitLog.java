package com.waylau.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.Channel;

/**
 * 日志发送程序
 * 
 * @author <a href="http://waylau.com">waylau.com</a>
 * @date 2016年8月12日
 */
public class EmitLog {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmitLog.class);
	private static final String EXCHANGE_NAME = "logs";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		// 声明交换器和类型
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

		String message = getMessage(argv);

		// 往交换器上发送消息
		channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
		LOGGER.info(" [x] Sent '" + message + "'");

		channel.close();
		connection.close();
	}

	private static String getMessage(String[] strings) {
		if (strings.length < 1)
			return "info: Hello World!";
		return joinStrings(strings, " ");
	}

	private static String joinStrings(String[] strings, String delimiter) {
		int length = strings.length;
		if (length == 0)
			return "";
		StringBuilder words = new StringBuilder(strings[0]);
		for (int i = 1; i < length; i++) {
			words.append(delimiter).append(strings[i]);
		}
		return words.toString();
	}
}
