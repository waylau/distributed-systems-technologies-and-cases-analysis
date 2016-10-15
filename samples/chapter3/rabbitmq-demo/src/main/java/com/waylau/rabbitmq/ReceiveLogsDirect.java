package com.waylau.rabbitmq;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * 日志接收程序
 * 
 * @author <a href="https://waylau.com">waylau.com</a>
 * @date 2016年8月13日
 */
public class ReceiveLogsDirect {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReceiveLogsDirect.class);

	private static final String EXCHANGE_NAME = "direct_logs";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME, "direct");
		String queueName = channel.queueDeclare().getQueue();

		if (argv.length < 1) {
			LOGGER.error("Usage: ReceiveLogsDirect [info] [warning] [error]");
			System.exit(1);
		}

		// 每一个我们感兴趣的 severity 创建一个新的绑定
		for (String severity : argv) {
			channel.queueBind(queueName, EXCHANGE_NAME, severity);
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