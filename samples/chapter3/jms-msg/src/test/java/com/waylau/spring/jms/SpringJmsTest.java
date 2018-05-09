package com.waylau.spring.jms;

import javax.jms.Destination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.waylau.spring.jms.queue.ConsumerService;
import com.waylau.spring.jms.queue.ProducerService;
import com.waylau.spring.jms.topic.TopicProvider;

/**
 * Spring JMS Test.
 * 
 * @since 1.0.0 2018年4月15日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
public class SpringJmsTest {

	/**
	 * 队列名queue1
	 */
	@Autowired
	private Destination queueDestination;

	/**
	 * 队列名queue2
	 */
	@Autowired
	private Destination queueDestination2;

	/**
	 * 队列名sessionAwareQueue
	 */
	@Autowired
	private Destination sessionAwareQueue;

	/**
	 * 队列名adapterQueue
	 */
	@Autowired
	private Destination adapterQueue;

	/**
	 * 主题 guo_topic
	 */
	@Autowired
	@Qualifier("topicDestination")
	private Destination topic;

	/**
	 * 主题消息发布者
	 */
	@Autowired
	private TopicProvider topicProvider;

	/**
	 * 队列消息生产者
	 */
	@Autowired
	@Qualifier("producerService")
	private ProducerService producer;

	/**
	 * 队列消息生产者
	 */
	@Autowired
	@Qualifier("consumerService")
	private ConsumerService consumer;

	/**
	 * 测试生产者向queue1发送消息
	 */
	@Test
	public void testProduce() {
		String msg = "Hello world!";
		producer.sendMessage(msg);
	}

	/**
	 * 测试消费者从queue1接受消息
	 */
	@Test
	public void testConsume() {
		consumer.receive(queueDestination);
	}

	/**
	 * 测试消息监听
	 * 1.生产者向队列queue2发送消息
	 * 2.ConsumerMessageListener监听队列，并消费消息
	 */
	@Test
	public void testSend() {
		producer.sendMessage(queueDestination2, "Hello R2");
	}

	/**
	 * 测试主题监听
	 * 1.生产者向主题发布消息
	 * 2.ConsumerMessageListener监听主题，并消费消息
	 */
	@Test
	public void testTopic() {
		topicProvider.publish(topic, "Hello Topic!");
	}

	/**
	 * 测试SessionAwareMessageListener
	 * 1. 生产者向队列sessionAwareQueue发送消息
	 * 2. SessionAwareMessageListener接受消息，并向queue1队列发送回复消息
	 * 3. 消费者从queue1消费消息
	 * 
	 */
	@Test
	public void testAware() {
		producer.sendMessage(sessionAwareQueue, "Hello sessionAware");
		consumer.receive(queueDestination);
	}

	/**
	 * 测试MessageListenerAdapter
	 * 1. 生产者向队列adapterQueue发送消息
	 * 2. MessageListenerAdapter使ConsumerListener接受消息，并向queue1队列发送回复消息
	 * 3. 消费者从queue1消费消息
	 * 
	 */
	@Test
	public void testAdapter() {
		producer.sendMessage(adapterQueue, "Hello adapterQueue", queueDestination);
		consumer.receive(queueDestination);
	}

}
