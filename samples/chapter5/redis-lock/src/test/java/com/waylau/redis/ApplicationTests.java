/**
 * Welcome to https://waylau.com
 */
package com.waylau.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.waylau.redis.lock.RedisLock;

/**
 * Application Tests.
 * 
 * @since 1.0.0 2018年5月15日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	
	@Autowired
	private RedisLock redisLock;
	
	@Test
	public void contextLoads() throws Exception {
		String lockName = "waylau.com";
		int lockNameExpireSecond = 10;
		
		for (int i = 0; i < 4; i++) {
			redisLock.lock(lockNameExpireSecond, lockName, true);
			
			Thread.sleep(3000);
			
			redisLock.unlock(lockName);
		}
	}
}
