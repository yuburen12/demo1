package com.yuburen.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuburen.dao.UserMapper;
import com.yuburen.entity.User;
import com.yuburen.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Override
    public void deductMoney(Long id, Integer deductMoney) {
        //1.查询余额
        User user = getById(id);
        Integer queryMoney = user.getMoney();
        //2.查询余额是否充足
        if (deductMoney > queryMoney) {
            throw new RuntimeException("余额不足");
        }
        int remainMoney = user.getMoney() - deductMoney;
        lambdaUpdate()
                .set(User::getMoney,remainMoney)
                .eq(User::getId,id)
                .eq(User::getMoney,user.getMoney())  //乐观锁
                .update();

    }

    @Override
    public List<User> queryUsers(String name, Integer minMoney, Integer maxMoney) {
        return lambdaQuery()
                .like(name != null,User::getName,name)  //模糊查询
                .ge(minMoney != null,User::getMoney,minMoney)  //大于或等于
                .le(maxMoney != null,User::getMoney,maxMoney)  //小于或等于
                .list();
    }
}
