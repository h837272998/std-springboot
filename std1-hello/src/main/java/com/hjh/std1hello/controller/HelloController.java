package com.hjh.std1hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-06-27 13:59
 */
@Controller
public class HelloController {
    @RequestMapping("hello")
    public String getHello(Model model) {
        model.addAttribute("current", DateFormat.getDateTimeInstance().format(new Date()));
        return "hello";
    }
}
