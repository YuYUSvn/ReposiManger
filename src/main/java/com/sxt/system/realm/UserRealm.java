package com.sxt.system.realm;

import com.sxt.system.common.ActiveUser;
import com.sxt.system.model.User;
import com.sxt.system.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthenticatingRealm {


    @Autowired
    private UserService service;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String name=authenticationToken.getPrincipal().toString();
        User user=service.queryByName(name);
        if (null!=user){
            ActiveUser user1=new ActiveUser();
            user1.setUser(user);
            SimpleAuthenticationInfo simpleAuthenticationInfo=new
                    SimpleAuthenticationInfo(user1,user.getPwd(), ByteSource.Util.bytes(user.getSalt()),this.getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
