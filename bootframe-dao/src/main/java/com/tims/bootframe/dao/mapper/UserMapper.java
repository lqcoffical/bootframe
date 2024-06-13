package com.tims.bootframe.dao.mapper;
import java.time.LocalDateTime;
import java.util.Collection;

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
     * jpa风格方法生成xml文件使用方法：
     * 不写返回值，直接写方法名，写完之后方法名变红，然后option+enter提示，用mybatisX生成sql语句就可以了
     * 但是生成的不是带where、if test标签的动态查询
     * 如果想用第二个校验的，用提示的第二个选项
     * 查询条件多了可能会生成比较长的方法名，后面统一改回来就行。改完之后有对应的小鸟icon可以跳转
     * 这里不要再加@Repository注解，可以在上层再封装一个repository层，service——>repository——>mapper这样把对数据库的操作解耦，mapper只做原子性操作
     *
     */

    List<User> getByName(@Param("name") String name);

    List<User> selectByGender(@Param("gender") Integer gender);

    int updateSelective(User user);

    List<User> selectUsersByPage(@Param("startIndex")Integer startIndex, @Param("pageSize")Integer pageSize);

    int insertBatch(@Param("userCollection") Collection<User> userCollection);

    List<User> selectByNameStartWith(@Param("name") String name);

    List<User> selectByConditions(@Param("name") String name,
                                  @Param("gender") Integer gender,
                                  @Param("createTime") LocalDateTime createTime,
                                  @Param("oldCreateTime") LocalDateTime oldCreateTime);

    List<User> selectByNameStartWithAndGenderEqualsAndCreateTimeBetween(@Param("name") String name,
                                                                        @Param("gender") Integer gender,
                                                                        @Param("beginCreateTime") LocalDateTime beginCreateTime,
                                                                        @Param("endCreateTime") LocalDateTime endCreateTime);

    User selectOneByPasswordEquals(@Param("password") String password);

    List<User> selectByNameLike(@Param("name") String name);

    List<User> selectByGenderAndStatus(@Param("gender") Integer gender, @Param("status") Integer status);

    List<User> selectByNameLikeAndGenderEquals(@Param("name") String name, @Param("gender") Integer gender);

    /**
     * useGeneratedKeys="true" keyColumn="id" keyColumn标识主键的类名
     * 标签可以做到自增主键回填。自增主键回填在添加，然后修改的时候会用到
     * @param user
     * @return
     */
    int insertSelective(User user);

}




