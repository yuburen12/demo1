package com.yuburen.service.Impl;

import com.yuburen.entity.User;
import com.yuburen.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;
    @Test
    void testSelectUser() {
        User one = userService.getById(1);
        System.out.println(one);
    }

}