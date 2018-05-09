package com.waylau.spring.jms.topic;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * Topic Provider.
 * 
 * @since 1.0.0 2018年4月15日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class TopicProvider {

	private JmsTemplate topicJmsTemplate;

	/**
	 * 向指定的topic发布消息
	 * 
	 * @param topic
	 * @param msg
	 */
	public void publish(final Destination topic, final String msg) {

		topicJmsTemplate.send(topic, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				System.out.println("TopicProvider 发布了主题：\t" 
						+ topic.toString() + "，发布消息内容为:\t" + msg);
				return session.createTextMessage(msg);
			}
		});
	}

	public void setTopicJmsTemplate(JmsTemplate topicJmsTemplate) {
		this.topicJmsTemplate = topicJmsTemplate;
	}

}
