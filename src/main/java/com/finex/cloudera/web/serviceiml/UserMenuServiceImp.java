package com.finex.cloudera.web.serviceiml;

import com.finex.cloudera.web.entity.Menu;
import com.finex.cloudera.web.entity.SubMenu;
import com.finex.cloudera.web.mapper.UserMenuMapper;
import com.finex.cloudera.web.service.IUserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lordorr on 2017/4/13.
 */
@Service
public class UserMenuServiceImp implements IUserMenuService {

    @Autowired
    protected UserMenuMapper userMenuMapper;

    @Override
    public List<Menu> findMenuByUser(String username) {
        List<Menu> menuList=new ArrayList<>();

        List<SubMenu> subMenus=new ArrayList<>();
        subMenus=userMenuMapper.findMenus();
        for (int i=0;i<subMenus.size();i++ ) {
            SubMenu sub=subMenus.get(i);
            int pid=sub.getMenuId();
            Menu menu=new Menu(sub.getMenuId(),sub.getMenuName(),sub.getpId(),sub.getMenuUrl(),sub.getMenuOrder(),sub.getMenuIcon(),sub.getMenuType(),sub.getMenuState(),userMenuMapper.findMenusByPid(pid));
            menuList.add(menu);
        }
        return menuList;
    }
}
