package com.hjh.std3jpa.dao;

import com.hjh.std3jpa.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-06-28 13:38
 */
public interface UserDao extends JpaRepository<User,Integer> {
    //利用反射原理。自动生成条件查询、、具体google
    public Page<User> findByName(Pageable pageable, String name);
}
