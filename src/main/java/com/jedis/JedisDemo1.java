package com.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis连接Redis数据源
 */
public class JedisDemo1 {

    /**
     * 单实例测试
     */
    public void demo1() {
        // 1.连接到redis服务器
        Jedis jedis = new Jedis("192.168.109.218", 6379);
        // 2.保存数据
        jedis.set("name", "chengy");
        // 3.获取数据
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();
    }

    public void demo2() {
        //获取连接池
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(30);
        //设置最大空闲连接数
        config.setMaxIdle(10);
        //获得连接池
        JedisPool jedisPool = new JedisPool(config, "192.168.109.218", 6379);
        Jedis jedis = null;
        try {
            //通过连接池获取jedis对象
            jedis = jedisPool.getResource();
            jedis.set("name1", "chengy1");
            //获取数据
            String name2 = jedis.get("name1");
            System.out.println(name2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
            if (jedisPool != null) {
                jedisPool.close();
            }
        }


    }

    public static void main(String[] args) {
//        new JedisDemo1().demo1();
        new JedisDemo1().demo2();
    }
}
