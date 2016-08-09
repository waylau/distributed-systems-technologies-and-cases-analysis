package com.waylau.rest;

 
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * REST 主应用
 * 
 * @author waylau.com
 * 2015年3月3日
 */
public class RestApplication extends ResourceConfig {

	public RestApplication() {
		// 资源类所在的包路径  
	    packages("com.waylau.rest.resource");
	    
	    // 注册 MultiPart
	    register(MultiPartFeature.class);
 
	}
}
