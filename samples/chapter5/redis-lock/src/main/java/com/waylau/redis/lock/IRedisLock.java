package com.waylau.redis.lock;
/**
 * Welcome to https://waylau.com
 */

/**
 * Redis Lock.
 * 
 * @since 1.0.0 2018年5月15日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public interface IRedisLock {

	Boolean lock(int lockKeyExpireSecond, String lockName, Boolean isWait) throws Exception;

	Boolean unlock(String lockName) throws Exception;
}
