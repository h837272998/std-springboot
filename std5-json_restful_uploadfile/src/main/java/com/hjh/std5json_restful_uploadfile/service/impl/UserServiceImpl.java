package com.hjh.std5json_restful_uploadfile.service.impl;

import com.hjh.std5json_restful_uploadfile.mapper.UserMapper;
import com.hjh.std5json_restful_uploadfile.pojo.User;
import com.hjh.std5json_restful_uploadfile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-06-28 21:51
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }

    @Override
    public User get(int id) {
        return userMapper.get(id);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public List<User> list() {
        return userMapper.list();
    }
}
