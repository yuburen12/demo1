package com.yuburen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuburen.entity.User;

import java.util.List;

public interface UserService extends IService<User> {

    void deductMoney(Long id, Integer deductMoney);

    List<User> queryUsers(String name, Integer minMoney, Integer maxMoney);
}
