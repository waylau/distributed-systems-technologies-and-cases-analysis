/**
 * Welcome to https://waylau.com
 */
package com.waylau.zk;

import org.junit.Test;

import com.waylau.zk.discovery.ZkServiceDiscovery;
import com.waylau.zk.registry.ZkServiceRegistry;


/**
 * Application Tests.
 * 
 * @since 1.0.0 2018年5月15日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public class ApplicationTests {

	private static final String SERVER_NAME = "waylau.com";
	private static final String SERVER_ADDRESS = "localhost:2181";
	
	@Test
	public void testClient() throws Exception {

		ZkServiceRegistry registry = new ZkServiceRegistry();
		registry.init();
		registry.registry(SERVER_NAME, SERVER_ADDRESS);
		
		ZkServiceDiscovery discovery = new ZkServiceDiscovery();
		discovery.init();
		discovery.discover(SERVER_NAME);
		
		// 永不停止
		while(true) {
		}
		
	}

}
