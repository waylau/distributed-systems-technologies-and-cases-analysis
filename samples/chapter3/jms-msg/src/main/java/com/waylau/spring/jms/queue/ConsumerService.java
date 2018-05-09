package com.waylau.spring.jms.queue;

import javax.jms.Destination;

/**
 * Consumer Service.
 * 
 * @since 1.0.0 2018年4月15日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public interface ConsumerService {
  public void receive(Destination queueDestination);
}
