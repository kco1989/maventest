package com.kco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/17.
 */
@Controller
@RequestMapping("/angluarAction")
public class AngularActionController {

    @RequestMapping("/test7_2.do")
    public String test7_2(String name, HttpServletResponse response) throws IOException {
        response.getWriter() .write("Hello " + name);
        return null;
    }
    @RequestMapping("/test7_3.do")
    public String test7_3(int n, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        if (n % 2 == 0){
            writer.write("even");
        }else {
            writer.write("odd");
        }
        return null;
    }
    private static List<Map<String, String>> test7_5ListMap = new ArrayList<>();
    static {
        Map<String, String> map1 = new HashMap<>();
        map1.put("code", "1001");
        map1.put("name", "Tom");
        map1.put("sex", "man");
        Map<String, String> map2 = new HashMap<>();
        map1.put("code", "1002");
        map1.put("name", "Tom2");
        map1.put("sex", "woman");
        test7_5ListMap.add(map1);
        test7_5ListMap.add(map2);
    }
    @RequestMapping(value = "/test7_5.do", params = "action=search")
    @ResponseBody
    public List<Map<String, String>>  test7_5_search() {
        return test7_5ListMap;
    }

    @RequestMapping(value = "/test7_5.do", params = "action=save")
    public String test7_5_save(String key, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        if (hasCode(key, test7_5ListMap)){
            writer.write("1");
        }else{
            writer.write("2");
        }
        return null;
    }

    private boolean hasCode(String key, List<Map<String, String>> test7_5ListMap) {
        for (Map<String, String> map : test7_5ListMap){
            if (key.equals(map.get("key"))){
                return true;
            }
        }
        return false;
    }
}
