package com.finex.cloudera.web.controller;


import com.finex.cloudera.web.entity.Menu;
import com.finex.cloudera.web.entity.SubMenu;
import com.finex.cloudera.web.mapper.UserMapperTest;
import com.finex.cloudera.web.entity.User;
import com.finex.cloudera.web.mapper.UserMenuMapper;
import com.finex.cloudera.web.mapper.UserRolePrmsMapper;
import com.finex.cloudera.web.serviceiml.UserMenuServiceImp;
import com.finex.cloudera.web.serviceiml.UserServiceImp;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by lordorr on 2017/3/27.
 */
@RestController
@EnableAutoConfiguration
public class LoginController {

    public static final Logger log = Logger.getLogger(LoginController.class);

    public static final int USER_IS_NOT_EXISTED = 401;
    public static final int USER_IS_LOCKED = 402;
    public static final int PASSWORD_IS_INCORRENT = 403;
    public static final int USER_IS_OTHER_EXCEPTION = 409;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public Object login(@RequestParam(value = "username") String username,
                              @RequestParam(value = "password") String password) throws  Exception {

        int msgType = 0;

        Subject current = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            if (!current.isAuthenticated()) {
                current.login(token);
            }
        } catch (UnknownAccountException e) {
            log.info("登录用户在数据库中不存在：" + username);
            msgType = USER_IS_NOT_EXISTED;
            e.printStackTrace();
        } catch (LockedAccountException ex) {
            log.info("登录用户被锁定：" + username);
            msgType = USER_IS_LOCKED;
        } catch (IncorrectCredentialsException e) {
            log.info("登录用户密码错误：" + username);
            msgType = PASSWORD_IS_INCORRENT;
            e.printStackTrace();
        } catch (AuthenticationException e) {
            msgType = USER_IS_OTHER_EXCEPTION;
            log.info("登录用户有其他错误，请检查用户名/密码：" + username);
            e.printStackTrace();
        }

        ModelMap map = new ModelMap();
        if (msgType!=0) {
            map.addAttribute("msg", msgType);
            ModelAndView modelAndView = new ModelAndView("index", map);
            return modelAndView;
        } else {
            List<Menu> menuList=userMenuServiceImp.findMenuByUser(username);
            System.out.println(menuList);
            map.addAttribute("menuLists",menuList);
            map.addAttribute("username",username);
            ModelAndView modelAndView = new ModelAndView("/main/index",map);
            return modelAndView;
           // return "redirect:test.html";
        }
    }

    @RequestMapping("/login")
    public ModelAndView index() {
        System.out.println("-------进入（login）---------");
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
        //return "forward:/index";
    }

    public List<Menu> MenuService(){
        List<Menu> list=new ArrayList<>();

       /* //第一个一级菜单
        String parentMeneLevelZero="LevelZero";
        SubMenu menu1=new SubMenu(1001,"quan_mana","权限管理","1","/","1","glyphicon glyphicon-comment","2");
        SubMenu menu2=new SubMenu(1002,"log_mana","日志管理","1","/","2","glyphicon glyphicon-comment","2");
        List<SubMenu> subList=new ArrayList<>();
        subList.add(menu1);
        subList.add(menu2);
        Menu menu0=new Menu(1,"sys","系统管理","0","/","1","glyphicon glyphicon-user","1",subList);

        //
        //Menu menu1=new Menu(1001,"quan_mana","权限管理","1","/","1","glyphicon glyphicon-tag","2");

        //
        //Menu menu2=new Menu(1002,"log_mana","日志管理","1","/","2","glyphicon glyphicon-comment","2");
        //第一个一级菜单
        String parentMeneLevelOne="LevelOne";
        SubMenu menu21=new SubMenu(2001,"quan_mana","容器参数","2","/","1","glyphicon glyphicon-comment","2");
        SubMenu menu22=new SubMenu(2002,"log_mana","设备参数","2","/","2","glyphicon glyphicon-comment","2");
        List<SubMenu> subList2=new ArrayList<>();
        subList2.add(menu21);
        subList2.add(menu22);
        Menu menu20=new Menu(2,"sys","参数管理","0","/","1","glyphicon glyphicon-home","1",subList2);

        list.add(menu0);
        list.add(menu20);
*/
        //return  list;
        return  null;
    }

    @Autowired
    public UserMenuServiceImp userMenuServiceImp;

}
