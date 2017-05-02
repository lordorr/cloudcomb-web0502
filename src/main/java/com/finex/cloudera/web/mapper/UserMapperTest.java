package com.finex.cloudera.web.mapper;

import com.finex.cloudera.web.entity.User;
import com.finex.cloudera.web.entity.UserInfo;
import com.sun.tools.corba.se.idl.StringGen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface UserMapperTest {
    List<User> queryList();
    User findById(int id);
    //User findUserByNameAndPwd(User user);
    User findByNameAndPassword(HashMap<String,String> map);

    List<UserInfo> findUserInfo();

    UserInfo findUserByNameAndPswd(HashMap<String,String> map);

    HashMap findUserById(int id);
}
