package com.hjh.std3jpa.controller;

import com.hjh.std3jpa.dao.UserDao;
import com.hjh.std3jpa.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-06-28 13:41
 */
@Controller
public class UserController {
    @Autowired
    UserDao userDao;

    @RequestMapping("/listUser")
    public String listUser(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;

        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<User> page =userDao.findAll(pageable);
        m.addAttribute("page", page);
        return "listUser";
    }

    @RequestMapping("/addUser")
    public String addCategory(User user) throws Exception {
        userDao.save(user);
        return "redirect:listUser";
    }
    @RequestMapping("/deleteUser")
    public String deleteCategory(User user) throws Exception {
        userDao.delete(user);
        return "redirect:listUser";
    }
    @RequestMapping("/updateUser")
    public String updateCategory(User user) throws Exception {
        userDao.save(user);
        return "redirect:listUser";
    }
    @RequestMapping("/editUser")
    public String ediitCategory(int id,Model m) throws Exception {
        User user= userDao.getOne(id);
        m.addAttribute("user", user);
        return "editUser";
    }
    @RequestMapping("findUser")
    public String findUser(Model m,
                           @RequestParam(value = "name") String  name,
                           @RequestParam(value = "start", defaultValue = "0") int start,
                           @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;

        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<User> page =userDao.findByName(pageable,name);
        m.addAttribute("page", page);
        m.addAttribute("name",name);
        return "findUser";
    }
}
