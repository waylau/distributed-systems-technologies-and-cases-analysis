package com.waylau.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志接收程序
 * 
 * @author <a href="http://waylau.com">Way Lau</a>
 * @date 2016年8月13日
 */
public class ReceiveLogsTopic {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReceiveLogsTopic.class);
	private static final String EXCHANGE_NAME = "topic_logs";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		// 声明一个 topic 类型的 exchange
		channel.exchangeDeclare(EXCHANGE_NAME, "topic");
		String queueName = channel.queueDeclare().getQueue();

		if (argv.length < 1) {
			LOGGER.error("Usage: ReceiveLogsTopic [binding_key]...");
			System.exit(1);
		}

		for (String bindingKey : argv) {
			channel.queueBind(queueName, EXCHANGE_NAME, bindingKey);
		}

		LOGGER.info(" [*] Waiting for messages. To exit press CTRL+C");

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				LOGGER.info(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
			}
		};
		channel.basicConsume(queueName, true, consumer);
	}
}