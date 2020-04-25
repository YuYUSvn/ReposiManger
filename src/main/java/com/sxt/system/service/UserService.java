package com.sxt.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxt.system.model.User;

public interface UserService extends IService<User> {
    User queryByName(String userName);
}
