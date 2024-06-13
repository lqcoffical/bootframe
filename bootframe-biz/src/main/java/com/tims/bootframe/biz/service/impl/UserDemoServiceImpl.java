package com.tims.bootframe.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tims.bootframe.biz.annotation.Match;
import com.tims.bootframe.biz.service.UserDemoService;
import com.tims.bootframe.common.front.PageResponse;
import com.tims.bootframe.dao.entity.User;
import com.tims.bootframe.dao.repository.UserRepository;
import com.tims.bootframe.dao.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class UserDemoServiceImpl implements UserDemoService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Match
    @Override
    public List<User> selectAllUsers() {
        return userRepository.getAllUser();
    }


    @Override
    public PageResponse<List<User>> getUsersByPage(Integer pageNum, Integer pageSize) {
        int startIndex = (pageNum - 1) * pageSize;
        List<User> userList = userRepository.getUsersByPage(startIndex, pageSize);
        Long total = userRepository.getTotal();
        PageResponse<List<User>> response = new PageResponse<>();
        response.setTotalCount(total);
        response.setData(userList);
        response.setPageNum(pageNum);
        response.setPageSize(pageSize);
        return response;
    }

    /**
     * pageHelper插件分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResponse<List<User>> getUsersByPageHelper(Integer pageNum, Integer pageSize) {
        // lambda写法，泛型不用再封装了，就是最基本的po对象，非lambda的写法是强转list对象到page。page就集成了list
        // 要执行mapper层的查询所有用户方法，深分页的话还得自己优化
        Page<User> page = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> userRepository.getAllUser());
        PageResponse<List<User>> response = new PageResponse<>();
        response.setTotalCount(page.getTotal());
        response.setPageSize(page.getPageSize());
        response.setPageNum(page.getPageNum());
        response.setData(page.getResult());
        return response;
    }

    /**
     * mybatis-plus分页插件
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResponse<List<User>> getUsersByMbPlus(Integer pageNum, Integer pageSize) {
        // 用mybatis-plus的代码生成器就行，已经有单表的增删改查操作了
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<User> page = userService.page(new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(pageNum,pageSize));
        PageResponse<List<User>> response = new PageResponse<>();
        response.setTotalCount(page.getTotal());
        response.setPageNum((int) page.getCurrent());
        response.setPageSize((int) page.getSize());
        response.setData(page.getRecords());
        return response;
    }

    @Override
    public PageResponse<List<User>> getUsersByConditions(Integer pageNum, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<User> page = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(pageNum, pageSize);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.likeRight(StringUtils.isNotBlank(name), User::getName, name)
                .eq(Objects.nonNull(gender), User::getGender, gender)
                .ge(Objects.nonNull(begin), User::getCreateTime, begin)
                .le(Objects.nonNull(end), User::getCreateTime, end);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<User> userPage = userService.page(page, queryWrapper);
        PageResponse<List<User>> response = new PageResponse<>();
        response.setTotalCount(userPage.getTotal());
        response.setPageNum((int) userPage.getCurrent());
        response.setPageSize((int) userPage.getSize());
        response.setData(userPage.getRecords());
        return response;
    }

}
