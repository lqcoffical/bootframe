package com.tims.bootframe.dao;

import com.tims.bootframe.dao.entity.User;
import com.tims.bootframe.dao.mapper.UserMapper;
import com.tims.bootframe.dao.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BootframeDaoApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testMybatisX(){
        List<User> list = userService.list();
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectByName(){
        List<User> list = userMapper.getByName("詹姆斯");
        list.forEach(System.out::println);
    }

}
