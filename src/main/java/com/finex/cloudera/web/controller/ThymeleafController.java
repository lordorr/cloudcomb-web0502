package com.finex.cloudera.web.controller;


import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "world") String name,
                           Model model) {
        model.addAttribute("xname", name);
        return "index";
    }


    @Controller
    public class JSONController {

        @ResponseBody
        @RequestMapping(value="/json", method = RequestMethod.GET)
        public  String getShopInJSON(HttpServletRequest httpRequest) {
            String username=httpRequest.getParameter("username");
            System.out.println(username);
            //测试数据
            String shop="1236789";
            return shop;
        }
    }
    @ResponseStatus
    @RequestMapping(value = "/ajax", method = RequestMethod.GET,produces ="application/json;charset=UTF-8" )
    public String ajax(@RequestParam(value = "username",required = false) String username) {
        System.out.println("开始进入ajax方法中。。。。。。");
        System.out.println(username);
        return username;
    }

    @RequestMapping(value = {"/update"},method =RequestMethod.POST)
    @ResponseBody//此注解不能省略 否则ajax无法接受返回值
    public Map<String,Object> update(Long num, Long id, Integer amount){

        System.out.println(num);
        Map<String,Object> resultMap = new HashMap<String, Object>();
        if(num == null || id == null || amount == null){
            resultMap.put("result", "参数不合法！");
            return resultMap;
        }
        //xxx逻辑处理
        resultMap.put("result", "SUCCESS");
        return resultMap;
    }

}