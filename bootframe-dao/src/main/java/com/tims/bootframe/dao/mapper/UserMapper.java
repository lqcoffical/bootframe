package com.tims.bootframe.dao.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tims.bootframe.dao.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author ChrisLee
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2024-06-03 09:03:38
* @Entity com.tims.bootframe.dao.entity.User
*/
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    List<User> getByName(@Param("name") String name);

    List<User> selectByGender(@Param("gender") Integer gender);

    int updateSelective(User user);

}




