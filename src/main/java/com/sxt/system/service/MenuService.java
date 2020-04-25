package com.sxt.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxt.system.config.Constant;
import com.sxt.system.model.Menu;

import java.util.List;

public interface MenuService extends IService<Menu> {
    List<Menu> queryAllMenuForList();

    List<Menu> queryAllMenuForListByUserId(Integer id);;

}
