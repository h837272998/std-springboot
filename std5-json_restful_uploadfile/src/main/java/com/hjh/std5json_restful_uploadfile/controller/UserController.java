package com.hjh.std5json_restful_uploadfile.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjh.std5json_restful_uploadfile.pojo.User;
import com.hjh.std5json_restful_uploadfile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-06-28 21:53
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    /*restful 部分*/
    @GetMapping("/users")
    public PageInfo<User> list(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size,"id desc");
        List<User> hs=userService.list();
        System.out.println(hs.size());

        PageInfo<User> page = new PageInfo<>(hs,5); //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样

        return page;
    }
    @GetMapping("/users/{id}")
    public User get(@PathVariable("id") int id) throws Exception {
        System.out.println(id);
        User user=userService.get(id);
        System.out.println(user);
        return user;
    }

    @PostMapping("/users")
    public String add(@RequestBody User user) throws Exception {
        userService.add(user);
        return "success";
    }
    @DeleteMapping("/users/{id}")
    public String delete(User user) throws Exception {
        userService.delete(user.getId());
        return "success";
    }
    @PutMapping("/users/{id}")
    public String update(@RequestBody User user) throws Exception {
        userService.update(user);
        return "success";
    }

    /*页面跳转 部分*/
    @RequestMapping(value="/listUser", method=RequestMethod.GET)
    public ModelAndView listUser(){
        ModelAndView mv = new ModelAndView("listUser");
        return mv;
    }

    @RequestMapping(value="/editUser", method=RequestMethod.GET)
    public ModelAndView editUser(){
        ModelAndView mv = new ModelAndView("editUser");
        return mv;
    }

    @PostMapping("/upload")
    public String upload(HttpServletRequest req, @RequestParam("file") MultipartFile file, @RequestParam("id") int id , Model m) throws Exception {
        try {
//            String fileName = System.currentTimeMillis()+file.getOriginalFilename();
//            String destFileName=req.getServletContext().getRealPath("")+"uploaded"+ File.separator+fileName;
            String fileName = String.valueOf(id)+".png";
            String destFileName=req.getServletContext().getRealPath("")+"uploaded"+ File.separator+fileName;
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            file.transferTo(destFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }
        return "success";
    }
}