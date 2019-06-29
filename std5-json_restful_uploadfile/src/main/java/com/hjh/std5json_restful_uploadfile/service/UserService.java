package com.hjh.std5json_restful_uploadfile.service;

import com.hjh.std5json_restful_uploadfile.pojo.User;

import java.util.List;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-06-28 21:50
 */
public interface UserService {
    public int add(User user);

    public void delete(int id);

    public User get(int id);

    public int update(User user);

    public List<User> list();
}
