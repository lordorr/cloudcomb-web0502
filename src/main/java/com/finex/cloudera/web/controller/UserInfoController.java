package com.finex.cloudera.web.controller;

import com.finex.cloudera.web.mapper.UserMapperTest;
import com.finex.cloudera.web.entity.UserInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lordorr on 2017/3/30.
 */
@Controller
public class UserInfoController {

    private Logger logger = Logger.getLogger(UserInfoController.class);

    @Autowired
    UserMapperTest userMapper;

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public String getUserInfo() {
        List<UserInfo> userInfo = userMapper.findUserInfo();
        for (UserInfo userInfo1:userInfo){
            System.out.println("user.getName():"+userInfo1.getName());
            logger.info("user.getAge():"+userInfo1.getAge());
        }
        return userInfo.toString();
    }

    @RequestMapping("/getUserInfo2")
    @ResponseBody
    public String getUserInfo2() {
        HashMap<String,String> info=new HashMap<>();
        info.put("name","hlhdidi");
        info.put("password","123");

        UserInfo user=userMapper.findUserByNameAndPswd(info);
        return user.toString();
    }

    @RequestMapping("/getUserInfo3")
    @ResponseBody
    public String getUserInfo3() {
        Map map=new HashMap();
        map=userMapper.findUserById(1);

        String name=(String) map.get("userName");
        String password=(String) map.get("password");
        return name+password;
    }
}