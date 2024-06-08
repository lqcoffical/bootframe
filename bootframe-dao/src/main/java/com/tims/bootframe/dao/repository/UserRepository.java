package com.tims.bootframe.dao.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tims.bootframe.dao.entity.User;
import com.tims.bootframe.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    UserMapper userMapper;

    public List<User> getAllUser(){
        return userMapper.selectList(new QueryWrapper<>());
    }

    /**
     * 手动分页
     * @param startIndex 起始记录数
     * @param pageSize 每页大小
     * @return
     */
    public List<User> getUsersByPage(Integer startIndex, Integer pageSize){
        return userMapper.selectUsersByPage(startIndex, pageSize);
    }

    public Long getTotal() {
        return userMapper.selectCount(new QueryWrapper<>());
    }
}
