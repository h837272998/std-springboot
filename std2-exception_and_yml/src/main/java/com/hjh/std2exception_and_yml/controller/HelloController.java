package com.hjh.std2exception_and_yml.controller;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import com.hjh.std2exception_and_yml.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Permission;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model m) throws Exception {
//        if(true){
//            throw new Exception("some exception");
//        }
        int i = RandomUtil.randomInt();
        if (i % 2 == 2) {
            int t = 10 / 0;
        }
        List<Person> list = new ArrayList<>();
        Person xm = new Person("小明","男",20);
        list.add(new Person("小红","女",18));
        list.add(new Person("小黄","男",18));
        list.add(xm);
        m.addAttribute("currentPerson",xm);
        m.addAttribute("personList",list);
        m.addAttribute("htmlContent","<p style='color:red'> 红色文字</p>");
        m.addAttribute("thePerson", xm);
        m.addAttribute("testBoolean","TRUE");
        return "hello";
    }

}