//package com.tims.bootframe.config;
//
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RedissonConfig {
//
//    @Value("${spring.redis.host}")
//    private String host;
//
//    @Value("${spring.redis.port}")
//    private String port;
//
//    @Bean
//    public RedissonClient redissonClient() {
//        // redis 地址为127.0.0.1:6379 时, 可以无需配置 一行代码搞定
////        RedissonClient redisson = Redisson.create();
//        Config config = new Config();
//
//        // "redis://" 要有
//        // 不用设置用户名密码，本地的默认没有
//        config.useSingleServer().setAddress("redis://" + host + ":" + port)
//                .setDatabase(0)
////                .setUsername("")
////                .setPassword("")
//                .setConnectionMinimumIdleSize(10)
//                .setConnectionPoolSize(50)
//                .setIdleConnectionTimeout(40000)
//                .setConnectTimeout(20000)
//                .setTimeout(10000);
//
//        return Redisson.create(config);
//    }
//
//}
