package com.waylau.spring.jms.queue;

import javax.jms.Destination;

/**
 * Producer Service.
 * 
 * @since 1.0.0 2018年4月15日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public interface ProducerService {

	/**
	 * 发消息，向默认的 destination
	 * 
	 * @param msg
	 *            String 消息内容
	 */
	public void sendMessage(String msg);

	/**
	 * 发消息，向指定的 destination
	 * 
	 * @param destination
	 *            目的地
	 * @param msg
	 *            String 消息内容
	 */
	public void sendMessage(Destination destination, String msg);

	/**
	 * 向指定的destination发送消息，消费者接受消息后，把回复的消息写到response队列
	 * 
	 * @param destination
	 *            目的地
	 * @param msg
	 *            String 消息内容
	 * @param response
	 *            回复消息的队列
	 */
	public void sendMessage(Destination destination, String msg, Destination response);

}
