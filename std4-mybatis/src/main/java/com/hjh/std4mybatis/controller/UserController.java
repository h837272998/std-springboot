package com.hjh.std4mybatis.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjh.std4mybatis.mapper.UserMapper;
import com.hjh.std4mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserMapper userMapper;
       
    @RequestMapping("/addUser")
    public String listUser(User user) throws Exception {
        userMapper.save(user);
        return "redirect:listUser";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(User user) throws Exception {
        userMapper.delete(user.getId());
        return "redirect:listUser";
    }
    @RequestMapping("/updateUser")
    public String updateUser(User user) throws Exception {
        userMapper.update(user);
        return "redirect:listUser";
    }
    @RequestMapping("/editUser")
    public String listUser(int id, Model m) throws Exception {
        User c= userMapper.get(id);
        m.addAttribute("c", c);
        return "editUser";
    }
      
    @RequestMapping("/listUser")
    public String listUser(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size,"id desc");
        List<User> cs=userMapper.findAll();
        PageInfo<User> page = new PageInfo<>(cs);
        m.addAttribute("page", page);       
        return "listUser";
    }
      
}