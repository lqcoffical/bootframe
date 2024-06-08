package com.tims.bootframe;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tims.bootframe.dao.entity.User;
import com.tims.bootframe.dao.mapper.UserMapper;
import com.tims.bootframe.dao.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = BootframeDaoApplication.class)
class BootframeDaoApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    /**
     * springboot的测试方法必须无参数、无返回值、public修饰
     * 必须有assert断言
     */
    @Test
    void testMybatisX(){
        List<User> list = userService.list();
        list.forEach(System.out::println);
    }

    @Test
    void testSelectByName(){
        List<User> list = userMapper.getByName("詹姆斯");
        list.forEach(System.out::println);
    }

    @Test
    void testWrapper(){
        List<Integer> list = Arrays.asList(1, 2, 8, 9, 10);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.in("id",list);
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

}
