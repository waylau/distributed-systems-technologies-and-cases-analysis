/**
 * Welcome to https://waylau.com
 */
package com.waylau.zk.registry;

/**
 * 
 * @since 1.0.0 2018年5月16日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface ServiceRegistry {

	/**
	 * 注册服务.
	 * 
	 * @param serviceName
	 * @param serviceAddress
	 */
	void registry(String serviceName, String serviceAddress);
}
