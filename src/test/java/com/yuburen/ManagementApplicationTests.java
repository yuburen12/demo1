package com.yuburen;

import com.yuburen.dao.UserMapper;
import com.yuburen.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ManagementApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
    @Test
    void LogicDeleted() {
        userMapper.deleteById(3L);

        User user = userMapper.selectById(3L);
        System.out.println(user);
    }



}
