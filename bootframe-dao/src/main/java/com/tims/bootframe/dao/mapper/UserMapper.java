package com.tims.bootframe.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tims.bootframe.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author ChrisLee
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2024-06-03 09:03:38
* @Entity com.tims.bootframe.dao.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     *
     * baseMapper中直接封装了挺多方法，到时候直接拿来用就行
     * mybatisX生成的是mybatis-plus风格代码，也可以自己加方法，用jpa命名方式有提示，可以自动生成方法和xml动态sql
     * 这里不要再加@Repository注解，可以在上层再封装一个repository层，service——>repository——>mapper这样把对数据库的操作解耦，mapper只做原子性操作
     *
     */

    List<User> getByName(@Param("name") String name);

    List<User> selectByGender(@Param("gender") Integer gender);

    int updateSelective(User user);

    List<User> selectUsersByPage(@Param("startIndex")Integer startIndex, @Param("pageSize")Integer pageSize);

}




