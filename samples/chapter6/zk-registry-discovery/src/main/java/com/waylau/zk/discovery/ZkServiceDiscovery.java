/**
 * Welcome to https://waylau.com
 */
package com.waylau.zk.discovery;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.I0Itec.zkclient.ZkClient;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;
import com.waylau.zk.Constant;

/**
 * ZooKeeper Service Discovery.
 * 
 * @since 1.0.0 2018年5月16日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class ZkServiceDiscovery implements ServiceDiscovery {

	/**
	 * ZK 地址.
	 */
	private String zkAddress = "localhost";

	/**
	 * 缓存所有的服务 IP 和 端口.
	 */
	private final List<String> addressCache = Lists.newCopyOnWriteArrayList();

	/**
	 * ZK 客户端.
	 */
	private ZkClient zkClient;

	public void init() {
		zkClient = new ZkClient(zkAddress, 
				Constant.ZK_SESSION_TIMEOUT, 
				Constant.ZK_CONNECTION_TIMEOUT);
		
		System.out.println(">>>connect to zookeeper");
	}

	@Override
	public String discover(String name) {
		try {
			String servicePath = Constant.ZK_REGISTRY + "/" + name;
			
			// 获取服务节点
			if (!zkClient.exists(servicePath)) {
				throw new RuntimeException(
						String.format(">>>can't find any service node on path {}",
								servicePath));
			}

			// 从本地缓存获取某个服务地址
			String address;
			int addressCacheSize = addressCache.size();
			if (addressCacheSize > 0) {
				if (addressCacheSize == 1) {
					address = addressCache.get(0);
				} else {
					address = addressCache.get(ThreadLocalRandom.current().nextInt(addressCacheSize));
					
					System.out.println(">>>get only address node:" + address);
				}

				// 从zk服务注册中心获取某个服务地址
			} else {
				List<String> addressList = zkClient.getChildren(servicePath);
				addressCache.addAll(addressList);
				
				// 监听servicePath下的子文件是否发生变化
				zkClient.subscribeChildChanges(servicePath, (parentPath, currentChilds) -> {
					System.out.println(">>>servicePath is changed:" + parentPath);
					
					addressCache.clear();
					addressCache.addAll(currentChilds);
				});
				
				if (CollectionUtils.isEmpty(addressList)) {
					throw new RuntimeException(
							String.format(">>>can’t find any address node on path {}", servicePath));
				}
				
				int nodes = addressList.size();
				if (nodes == 1) {
					address = addressList.get(0);
				} else {
					
					// 如果多个，随机取一个
					address = addressList.get(ThreadLocalRandom.current().nextInt(nodes));
				}
				
				System.out.println(">>>get address node:" + address);
			}

			// 获取ip和端口号
			String addressPath = servicePath + "/" + address;
			String hostAndPort = zkClient.readData(addressPath);
			return hostAndPort;
		} catch (Exception e) {
			
			System.out.println(">>>service discovery exception" + e.getMessage());
			
			zkClient.close();
		}
		return null;
	}

}
