package com.finex.cloudera.web.mapper;

import com.finex.cloudera.web.entity.User;
import org.hibernate.mapping.Map;

import java.util.HashMap;

/**
 * Created by lordorr on 2017/3/30.
 */
public interface UserRolePrmsMapper {
    HashMap findUserByName(HashMap<String,String> map);
}
