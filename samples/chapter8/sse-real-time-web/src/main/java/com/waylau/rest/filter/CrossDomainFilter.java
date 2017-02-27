package com.waylau.rest.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

/**
 * 说明：支持 Cross-domain 请求
 *
 * @author <a href="http://www.waylau.com">waylau.com</a> 2015年8月22日 
 */
public class CrossDomainFilter implements ContainerResponseFilter {

	/**
	 * 
	 */
	public CrossDomainFilter() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see javax.ws.rs.container.ContainerResponseFilter#filter(javax.ws.rs.container.ContainerRequestContext, javax.ws.rs.container.ContainerResponseContext)
	 */
	@Override
	public void filter(ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) throws IOException {
		
		// 响应头添加了对允许访问的域，* 代表是全部域
		responseContext.getHeaders().add("Access-Control-Allow-Origin", "*"); 

	}

}
