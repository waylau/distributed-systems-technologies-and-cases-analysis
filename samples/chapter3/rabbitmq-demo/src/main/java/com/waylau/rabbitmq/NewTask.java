package com.waylau.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * 发送消息的任务发送程序
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @date 2016年8月12日
 */
public class NewTask {

	private static final Logger LOGGER = LoggerFactory.getLogger(NewTask.class);
	private static final String TASK_QUEUE_NAME = "waylau_queue";

	public static void main(String[] argv) throws Exception {

		// 初始化连接工厂
		ConnectionFactory factory = new ConnectionFactory();

		// 设置连接的地址
		factory.setHost("localhost");

		// 获得连接
		Connection connection = factory.newConnection();

		// 创建 Channel
		Channel channel = connection.createChannel();

		// 声明队列
		channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

		// 从控制台参数中，获取消息
		String message = getMessage(argv);

		// 发送消息。发送10条
		for (int i = 0; i < 10; i++) {
			String msg = message + " " + i;
			channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,
					(msg).getBytes("UTF-8"));

			LOGGER.info(" [x] Sent '" + msg + "'");
		}

		channel.close();
		connection.close();
	}

	private static String getMessage(String[] strings) {
		if (strings.length < 1)
			return "Hello World!";
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
