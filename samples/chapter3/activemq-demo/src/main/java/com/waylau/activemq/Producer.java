package com.waylau.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MQ 生产者
 * 
 * @author <a href="https://waylau.com">Way Lau</a> 
 * @date 2016年8月7日
 */
public class Producer {

	private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final String SUBJECT = "waylau-queue";

    public static void main(String[] args) throws JMSException {
    	
        // 初始化连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        
        // 获得连接
        Connection conn = connectionFactory.createConnection();
        
        // 启动连接
        conn.start();

        // 创建Session，第一个参数表示会话是否在事务中执行，第二个参数设定会话的应答模式
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 创建队列
        Destination dest = session.createQueue(SUBJECT);
        
        //createTopic方法用来创建Topic
        //session.createTopic("TOPIC");

        // 通过 session 可以创建消息的生产者
        MessageProducer producer = session.createProducer(dest);
        for (int i=0;i<10;i++) {
        	
            //初始化一个 MQ 消息
            TextMessage message = session.createTextMessage("Welcome to waylau.com " + i);
            
            //发送消息
            producer.send(message);
            
            LOGGER.info("send message {}", i);
        }

        //关闭 MQ 连接
        conn.close();
    }
}