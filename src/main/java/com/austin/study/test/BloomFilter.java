package com.austin.study.test;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;

/**
 * @author Austin
 * @since 2019/11/27 11:35   Wed
 */
public class BloomFilter {

    public static double size = Math.pow(2, 32);

    //第一次加载的时候将数据加载到redis中
    public static void saveDataToRedis(Jedis jedis) {

        List<String> baseList = new ArrayList<String>();
        baseList.add("000");
        baseList.add("111");
        baseList.add("222");

        for (int i = 0; i < baseList.size(); i++) {
            long index = hashIndex(baseList.get(i));  // 只做一次hash，实际中会计算多个hash位置
            jedis.setbit("orderId", index, true);
        }
    }

    private static long hashIndex(String target) {
        return Math.abs((long) (target.hashCode() % size));
    }

    //判断传入的数据是否在redis中
    public static boolean checkEleIsContainBloomFilter(String target, Jedis jedis) {
        long index = hashIndex(target);
        System.out.println("index: " + index + " size: " + size);
        boolean checkResult = jedis.getbit("orderId", index);
        return checkResult;
    }

    public static void main(String[] args) {
        //获取redis链接
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("xxxx");

        //第一次运行的时候调用，只运行一次
        saveDataToRedis(jedis);

        //获取比较后的值
        System.out.println(checkEleIsContainBloomFilter("000", jedis));

        //释放redis链接
        jedis.close();

    }
}
