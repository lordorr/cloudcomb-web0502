package com.finex.cloudera.web.shiro;


import com.finex.cloudera.web.mapper.UserRolePrmsMapper;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by lordorr on 2017/3/30.
 */
public class ShiroRealm extends AuthorizingRealm {

    protected  final Logger log=Logger.getLogger(ShiroRealm.class);

    @Autowired
    UserRolePrmsMapper prmsMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("--AuthorizationInfo");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken) token;
        String name=usernamePasswordToken.getUsername();

        log.info("开始认证中........,用户名称："+name);
        HashMap<String,String> map=new HashMap<>();
        map.put("name",name);
        Map user=new HashMap();
        user=prmsMapper.findUserByName(map);
        if(user!=null){
            log.info("输入的用户名相关的信息是："+user.toString());
            Object pricple=user.get("userName");
            Object credential = user.get("password");
            ByteSource credentialsSalt= ByteSource.Util.bytes("123");
            log.info("user:"+pricple +" password:"+credential);

            SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(pricple,credential,credentialsSalt,getName());
            return info;
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        String algorithmName = "MD5";
        String source = "root";
        ByteSource salt = ByteSource.Util.bytes("123");
        int hashIterations = 1024;

        Object result = new SimpleHash(algorithmName, source, salt, hashIterations);
        System.out.println(result);
    }
}
