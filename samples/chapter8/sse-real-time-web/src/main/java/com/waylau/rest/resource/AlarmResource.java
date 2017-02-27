package com.waylau.rest.resource;

import java.io.IOException;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

import com.waylau.rest.bean.Alarm;

/**
 * 说明：告警 SSE 
 *
 * @author <a href="http://www.waylau.com">waylau.com</a> 2015年9月8日 
 */
@Path("alarm-events")
public class AlarmResource {

    private EventOutput eventOutput = new EventOutput();
    private OutboundEvent.Builder eventBuilder;
    private OutboundEvent event ;
    
    /**
     * 提供 SSE 事件输出通道的资源方法
     * @return eventOutput
     */
 	@GET
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput getServerSentEvents() {

 		// 不断循环执行
        while (true) {
        	Alarm message = new Alarm(new Date(),Short.valueOf("11"), "10", "锅炉砸掉了");
        	 
        	eventBuilder = new OutboundEvent.Builder();
        	eventBuilder.id(message.getId()+"");
            eventBuilder.name("message");;
            eventBuilder.mediaType(MediaType.APPLICATION_JSON_TYPE);
            eventBuilder.data(Alarm.class,
            		message );  // 推送服务器时间的信息给客户端
            event = eventBuilder.build();
            try {
				eventOutput.write(event);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					eventOutput.close();
			        return eventOutput;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
        }
    }
}
