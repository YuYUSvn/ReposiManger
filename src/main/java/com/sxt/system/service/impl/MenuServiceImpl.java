package com.sxt.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxt.system.config.Constant;
import com.sxt.system.dao.MenuDao;
import com.sxt.system.model.Menu;
import com.sxt.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

@Service
@Transactional
public class MenuServiceImpl extends ServiceImpl<MenuDao, Menu> implements MenuService {

    @Autowired
    private MenuDao dao;
    @Override
    public List<Menu> queryAllMenuForList() {
        QueryWrapper<Menu> qp=new QueryWrapper<Menu>();
        qp.eq("available", Constant.AVAILABLE_TRUE);
        qp.and(new Consumer<QueryWrapper<Menu>>() {
            @Override
            public void accept(QueryWrapper<Menu> menuQueryWrapper) {
                menuQueryWrapper.eq("type",Constant.MENU_TYPE_TOP)
                        .or().eq("type",Constant.MENU_TYPE_LEFT);
            }
        });
        qp.orderByAsc("ordernum");
        return this.dao.selectList(qp);
    }

    @Override
    public List<Menu> queryAllMenuForListByUserId(Integer id) {
        QueryWrapper<com.sxt.system.model.Menu> qp=new QueryWrapper<Menu>();
        qp.eq("available",Constant.AVAILABLE_TRUE);
        qp.and(new Consumer<QueryWrapper<Menu>>() {
            @Override
            public void accept(QueryWrapper<Menu> menuQueryWrapper) {
                menuQueryWrapper.eq("type",Constant.MENU_TYPE_TOP)
                        .or().eq("type",Constant.MENU_TYPE_LEFT);
            }
        });
        qp.orderByAsc("ordernum");
        return this.dao.selectList(qp);
    }
}
