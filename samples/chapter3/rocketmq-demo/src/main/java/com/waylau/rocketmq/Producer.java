package com.waylau.rocketmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

/**
 * 生产者，用于发送消息
 * 
 * @author <a href="http://waylau.com">waylau.com</a>
 * @date 2016年8月18日
 */
public class Producer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
	private static final String GROUP_NAME = "waylau_com_producer_gorup";
	private static final String NAME_SERVER = "10.30.22.108:9876";
	
	public static void main(String[] args) throws MQClientException, InterruptedException {
		
		// producerGroup 必须唯一
		DefaultMQProducer producer = new DefaultMQProducer(GROUP_NAME);

		// 设置 name server 地址
		producer.setNamesrvAddr(NAME_SERVER);
		
		// 在发送消息前，必须调用 start 方法来启动Producer，只需调用一次即可
		producer.start();

		// 模拟发送十条数据
		for (int i = 0; i < 10; i++) {
			try {
				Message msg = new Message( 
			             // Message Topic
			             "TopicTest",
			             // Message Tag,对消息进行再归类,方便Consumer指定过滤条件在MQ服务器过滤
			             "TagA",
			             // Message Body,任何二进制形式的数据,需要Producer与Consumer协商好一致的序列化和反序列化方式
			             ("Welcome to waylau.com! " + i).getBytes());
				
				// 发送消息
				SendResult sendResult = producer.send(msg);
 
				LOGGER.info(sendResult.toString());
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				Thread.sleep(1000);
			}
		}

		// 在应用退出前，可以销毁Producer对象
		producer.shutdown();
	}
}
