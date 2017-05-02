package com.finex.cloudera.web.mapper;

import com.finex.cloudera.web.entity.SubMenu;

import java.util.List;

/**
 * Created by lordorr on 2017/4/13.
 */
public interface UserMenuMapper {
    List<SubMenu> findMenus();
    List<SubMenu>  findMenusByPid(int pid);
}
