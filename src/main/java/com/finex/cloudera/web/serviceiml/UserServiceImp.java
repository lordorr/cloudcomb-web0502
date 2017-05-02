package com.finex.cloudera.web.serviceiml;

import com.finex.cloudera.web.mapper.UserMapperTest;
import com.finex.cloudera.web.entity.User;
import com.finex.cloudera.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lordorr on 2017/3/27.
 */
@Service
public class UserServiceImp implements IUserService {

    @Autowired
    private UserMapperTest userMapper;

  /*  @Override
    public User findUserByNameAndPwd(User user) {
        return userMapper.findUserByNameAndPwd(user);
    }*/
  @Override
    public List<User> findAll() {
        return userMapper.queryList();
    }
}
