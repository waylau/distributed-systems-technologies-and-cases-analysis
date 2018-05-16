/**
 * Welcome to https://waylau.com
 */
package com.waylau.zk.discovery;

/**
 * Service Discovery.
 * 
 * @since 1.0.0 2018年5月16日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public interface ServiceDiscovery {

	/**
	 * 服务发现.
	 * 
	 * @param name
	 * @return
	 */
	String discover(String name);
}
