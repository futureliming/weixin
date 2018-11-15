package com.liming.weixin.util;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import redis.clients.jedis.Jedis;

public class TestRedis {
    private Jedis jedis;
    
    /**
     * 连接redis服务器
     */
    public void connectRedis() {
    	jedis=RedisUtil.getJedis();
    }
    
    /**
     * redis操作字符串
     */
    
    public void testString() {
        //添加数据
        jedis.set("name", "youcong");
        System.out.println(jedis.get("name"));
    }
    public static void main(String[] args) {
    	TestRedis testRedis =new TestRedis();
    	testRedis.connectRedis();
	}
}
