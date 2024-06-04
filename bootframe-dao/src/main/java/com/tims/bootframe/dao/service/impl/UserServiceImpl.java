package com.tims.bootframe.dao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tims.bootframe.dao.entity.User;
import com.tims.bootframe.dao.service.UserService;
import com.tims.bootframe.dao.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author ChrisLee
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2024-06-03 09:03:38
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




