package com.finex.cloudera.web.service;

import com.finex.cloudera.web.entity.Menu;
import com.finex.cloudera.web.entity.SubMenu;

import java.util.List;

/**
 * Created by lordorr on 2017/4/13.
 */
public interface IUserMenuService {
     List<Menu> findMenuByUser(String username);
}
