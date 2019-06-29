package com.hjh.std4mybatis.mapper;

import com.hjh.std4mybatis.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-06-28 15:00
 */
@Mapper
public interface UserMapper {
    @Select("select * from user_ ")
    List<User> findAll();

    @Insert(" insert into user_ ( name ) values (#{name}) ")
    public int save(User user);

    @Delete(" delete from user_ where id= #{id} ")
    public void delete(int id);

    @Select("select * from user_ where id= #{id} ")
    public User get(int id);

    @Update("update user_ set name=#{name} where id=#{id} ")
    public int update(User user);
}
