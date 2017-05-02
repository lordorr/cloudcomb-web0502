package com.finex.cloudera.web.service;

import com.finex.cloudera.web.entity.User;

import java.util.List;

/**
 * Created by lordorr on 2017/3/27.
 */
public interface IUserService  {
    public List<User> findAll();
   // public User findUserByNameAndPwd(User user);
}
