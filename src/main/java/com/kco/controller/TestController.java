package com.kco.controller;

import com.kco.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by pc on 2017/4/11.
 */
@Controller
@RequestMapping("/main")
public class TestController {
    @Resource
    private TestService testService;
    @RequestMapping("/index")
    public String index(){
        System.out.println(testService.test());
        return "index";
    }
}
