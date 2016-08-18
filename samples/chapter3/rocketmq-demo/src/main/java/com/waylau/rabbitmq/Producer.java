package com.waylau.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.LocalTransactionExecuter;
import com.alibaba.rocketmq.client.producer.LocalTransactionState;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

/**
 * 生产者
 * 
 * @author <a href="http://waylau.com">waylau.com</a>
 * @date 2016年8月18日
 */
public class Producer {
	private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
	private static final String GROUP_NAME = "waylau_com_producer_gorup";
	public static void main(String[] args) throws MQClientException, InterruptedException {
		DefaultMQProducer producer = new DefaultMQProducer(GROUP_NAME);

		producer.start();

		for (int i = 0; i < 1000; i++) {
			try {
				Message msg = new Message("TopicTest", // topic
						"TagA", // tag
						("Hello RocketMQ " + i).getBytes()// body
				);
				SendResult sendResult = producer.send(msg);
				/*
				LocalTransactionExecuter tranExecuter = new LocalTransactionExecuter() {

					@Override
					public LocalTransactionState executeLocalTransactionBranch(Message msg, Object arg) {
						return null;
					}
				};*/
				// producer.sendMessageInTransaction(msg, tranExecuter, arg)
				LOGGER.info(sendResult.toString());
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				Thread.sleep(1000);
			}
		}

		producer.shutdown();
	}
}
