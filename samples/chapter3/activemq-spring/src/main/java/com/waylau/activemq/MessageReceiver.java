package com.waylau.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;

/**
 * 
 * @author <a href="http://waylau.com">Way Lau</a>
 * @date 2016年8月7日
 */
public class MessageReceiver implements MessageListener {

	static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);

	@Autowired
	MessageConverter messageConverter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	@Override
	public void onMessage(Message message) {
		try {
			LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
			InventoryResponse response = (InventoryResponse) messageConverter.fromMessage(message);
			LOG.info("Application : order response received : {}", response);
			LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		} catch (JMSException e) {
			LOG.error(e.getMessage());
		}
	}

}
