package com.waylau.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 日志接收程序
 * 
 * @author <a href="https://waylau.com">waylau.com</a>
 * @date 2016年8月12日
 */
public class ReceiveLogs {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReceiveLogs.class);
	private static final String EXCHANGE_NAME = "logs";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
		
		// 不传递任何参数来创建一个非持久的、唯一的、动删除的队列，该队列名称由服务器随机产生。
		String queueName = channel.queueDeclare().getQueue();
		
		// 为交换器指定队列，设置 binding
		channel.queueBind(queueName, EXCHANGE_NAME, "");

		LOGGER.info(" [*] Waiting for messages. To exit press CTRL+C");

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				LOGGER.info(" [x] Received '" + message + "'");
			}
		};
		channel.basicConsume(queueName, true, consumer);
	}
}
