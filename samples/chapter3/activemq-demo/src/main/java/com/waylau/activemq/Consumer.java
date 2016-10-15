package com.waylau.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MQ 消费者
 * 
 * @author <a href="https://waylau.com">Way Lau</a> 
 * @date 2016年8月7日
 */
public class Consumer implements MessageListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final String SUBJECT = "waylau-queue";

    public static void main(String[] args) throws JMSException {
    	
        //初始化 ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);

        //创建 MQ 连接
        Connection conn = connectionFactory.createConnection();
        //启动连接
        conn.start();

        //创建会话
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //通过会话创建目标
        Destination dest = session.createQueue(SUBJECT);
        
        //创建 MQ 消息的消费者
        MessageConsumer consumer = session.createConsumer(dest);

        //初始化 MessageListener
        Consumer me = new Consumer();

        //给消费者设定监听对象
        consumer.setMessageListener(me);
    }

    @Override
    public void onMessage(Message message) {
        TextMessage txtMessage = (TextMessage)message;
        try {
            LOGGER.info ("get message " + txtMessage.getText());
        } catch (JMSException e) {
            LOGGER.error("error {}", e);
        }
    }
}
