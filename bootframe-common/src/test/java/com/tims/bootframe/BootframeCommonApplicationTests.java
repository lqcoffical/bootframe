package com.tims.bootframe;

//import com.tims.bootframe.common.utils.redis.RedissonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BootframeCommonApplication.class)
class BootframeCommonApplicationTests {

    @Test
    void contextLoads() {
    }

    /*@Test
    void testRedissonUtil(){
        RedissonUtil.setStr("123","hahahaha",20000L);
    }*/

}
