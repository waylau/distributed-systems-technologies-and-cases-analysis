package com.waylau.rabbitmq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消费者，接收和处理消息
 * 
 * @author <a href="http://waylau.com">waylau.com</a>
 * @date 2016年8月18日
 */
public class Consumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
	private static final String GROUP_NAME = "waylau_com_consumer_gorup";
	private static final String NAME_SERVER = "10.30.22.108:9876";
	
	public static void main(String[] args) throws InterruptedException, MQClientException {
		
		// consumerGroup 必须唯一
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(GROUP_NAME);

		// 设置 Consumer 第一次启动是从队列头部开始消费还是队列尾部开始消费
		// 如果非第一次启动，那么按照上次消费的位置继续消费
		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

		// 设置 name server 地址
		consumer.setNamesrvAddr(NAME_SERVER);
		
		// 订阅 topic
		consumer.subscribe("TopicTest", "*");

		// 监听消息
		consumer.registerMessageListener(new MessageListenerConcurrently() {

			@Override
			public ConsumeConcurrentlyStatus consumeMessage(
					List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
				LOGGER.info(Thread.currentThread().getName() + " Receive New Messages: " + msgs);
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});

		consumer.start();

		LOGGER.info("Consumer Started.");
	}
}
