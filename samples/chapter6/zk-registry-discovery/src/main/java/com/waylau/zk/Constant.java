/**
 * Welcome to https://waylau.com
 */
package com.waylau.zk;

/**
 * Constant.
 * 
 * @since 1.0.0 2018年5月16日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface Constant {

	/**会话超时时间*/
    int ZK_SESSION_TIMEOUT = 5000;

    /**连接超时时间*/
    int ZK_CONNECTION_TIMEOUT = 1000;

    String ZK_REGISTRY = "/registry";
}
