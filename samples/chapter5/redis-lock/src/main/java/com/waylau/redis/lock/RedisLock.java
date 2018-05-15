/**
 * Welcome to https://waylau.com
 */
package com.waylau.redis.lock;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import redis.clients.jedis.Jedis;

/**
 * Redis Lock.
 * 
 * @since 1.0.0 2018年5月15日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Component
public class RedisLock implements IRedisLock {

	private static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(RedisLock.class);

	/**
	 * 当前机器节点锁标识。
	 */
	private static String redisIdentityKey = UUID.randomUUID().toString();

	/**
	 * 获取当前机器节点在锁中的标示符。
	 */
	public static String getRedisIdentityKey() {
		return redisIdentityKey;
	}

	/**
	 * 等待获取锁的时间，可以根据当前任务的执行时间来设置。
	 */
	private static final long WaitLockTimeSecond = 2000;

	/**
	 * 重试获取锁的次数,可以根据当前任务的执行时间来设置。
	 * 需要时间=RetryCount*(WaitLockTimeSecond/1000)
	 */
	private static final int RetryCount = 10;

	@Autowired
	private Jedis jedis;

	@Override
	public Boolean lock(int lockNameExpireSecond, String lockName, Boolean isWait) throws Exception {
		if (StringUtils.isEmpty(lockName))
			throw new Exception("lockName is empty.");

		int retryCounts = 0;
		while (true) {
			Long status, expire = 0L;
			status = jedis.setnx(lockName, redisIdentityKey);
			if (status > 0) {
				expire = jedis.expire(lockName, lockNameExpireSecond);
			}
			if (status > 0 && expire > 0) {
				logger.info(String.format("t:%s,当前节点：%s,获取到锁：%s", 
						Thread.currentThread().getId(), 
						getRedisIdentityKey(),
						lockName));
				return true;/** 获取到lock */
			}

			try {
				if (isWait && retryCounts < RetryCount) {
					retryCounts++;
					synchronized (this) {
						logger.info(String.format("t:%s,当前节点：%s,尝试等待获取锁：%s", 
								Thread.currentThread().getId(),
								getRedisIdentityKey(), 
								lockName));

						// 未能获取到lock，进行指定时间的wait再重试.
						this.wait(WaitLockTimeSecond);
					}
				} else if (retryCounts == RetryCount) {
					logger.info(String.format("t:%s,当前节点：%s,指定时间内获取锁失败：%s", 
							Thread.currentThread().getId(),
							getRedisIdentityKey(), 
							lockName));
					return false;
				} else {
					return false;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Boolean unlock(String lockName) throws Exception {
		if (StringUtils.isEmpty(lockName))
			throw new Exception("lockName is empty.");

		long status = jedis.del(lockName);
		if (status > 0) {
			logger.info(String.format("t:%s,当前节点：%s,释放锁：%s 成功。", 
					Thread.currentThread().getId(), 
					getRedisIdentityKey(),
					lockName));
			return true;
		}
		logger.info(String.format("t:%s,当前节点：%s,释放锁：%s 失败。", 
				Thread.currentThread().getId(), 
				getRedisIdentityKey(),
				lockName));
		return false;
	}

}
