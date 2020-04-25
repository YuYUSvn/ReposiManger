package com.sxt.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxt.system.dao.UserDao;
import com.sxt.system.model.User;
import com.sxt.system.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    private UserDao dao;

    private Log log= LogFactory.getLog(UserServiceImpl.class);
    @Override
    public User queryByName(String userName) {
        QueryWrapper<User> qp=new QueryWrapper<User>();
        if (StringUtils.isBlank(userName)){
             log.error("用户名不能为空！");
        }
        qp.eq("loginname",userName);
        User user=dao.selectOne(qp);
        return user;
    }
}
