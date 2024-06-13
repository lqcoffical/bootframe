package com.tims.bootframe.biz.service;

import com.tims.bootframe.common.front.PageResponse;
import com.tims.bootframe.dao.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface UserDemoService {

    List<User> selectAllUsers();


    PageResponse<List<User>> getUsersByPage(Integer pageNum, Integer pageSize);

    PageResponse<List<User>> getUsersByPageHelper(Integer pageNum, Integer pageSize);

    PageResponse<List<User>> getUsersByMbPlus(Integer pageNum, Integer pageSize);

    PageResponse<List<User>> getUsersByConditions(Integer pageNum, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
}
