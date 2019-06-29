package com.hjh.std5json_restful_uploadfile.mapper;

import com.hjh.std5json_restful_uploadfile.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-06-28 21:45
 */
@Mapper
public interface UserMapper {
    public int add(User user);
    
    public void delete(int id);

    public User get(int id);

    public int update(User User);

    public List<User> list();
}
