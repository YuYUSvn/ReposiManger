package com.sxt.system.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sxt.system.common.ActiveUser;
import com.sxt.system.common.MenuTreeNode;
import com.sxt.system.common.ResultObj;
import com.sxt.system.config.Constant;
import com.sxt.system.model.Menu;
import com.sxt.system.model.User;
import com.sxt.system.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Controller
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    private MenuService service;

    @RequestMapping("/doLogin")
    @ResponseBody
    public ResultObj doLogin(String loginName,String password){
        try {
            Subject subject= SecurityUtils.getSubject();
            UsernamePasswordToken loginToken=new UsernamePasswordToken(loginName,password);
            subject.login(loginToken);
            String token= (String) subject.getSession().getId();
            //写入登录日志
            return new ResultObj(200,"登录成功！",token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new ResultObj(-1,"用户名或密码不正确！");
        }
    }


   /*
   *
   * 验证当前token是否登录*/
    @RequestMapping("checkLogin")
    @ResponseBody
    public ResultObj checkLogin(){
        Subject subject=SecurityUtils.getSubject();
        if (subject.isAuthenticated()){
             return ResultObj.IS_LOGIN;
        }else {
             return ResultObj.UN_LOGIN;
        }
    }
    /*
    *
    * 加载所有Menu*/
    @ResponseBody
    @RequestMapping("loadIndexMenu")
    public Object loadIndexMenu(){
        //得到当前登录用户
        Subject subject=SecurityUtils.getSubject();
        ActiveUser activeUser= (ActiveUser)subject.getPrincipal();
        User user=activeUser.getUser();
        if (null==user) {
            return null;
        }
        List<Menu> menus=null;
        if (user.getType().equals(Constant.USER_TYPE_SUPER)){//超级管理员
            menus=service.queryAllMenuForList();
        }else {
            menus=service.queryAllMenuForListByUserId(user.getId());;
        }
        List<MenuTreeNode> treeNodes=new ArrayList<>();
        for (Menu m:menus){
            Boolean spread=m.getSpread()==Constant.SPREAD_TRUE?true:false;
            treeNodes.add(new MenuTreeNode(m.getId(),m.getPid(),m.getTitle(),m.getHref(),m.getIcon(),spread,m.getTarget(),m.getTypecode()));
        }
        List<MenuTreeNode> nodes=MenuTreeNode.MenuTreeNodeBuilder.build(treeNodes,0);
        Map<String,Object> res=new HashMap<>();
        for (MenuTreeNode n : nodes) {
            res.put(n.getTypecode(),n);
        }
        String json= JSON.toJSONString(res);
        return json.replace("\"child\":[],","");
    }
}
