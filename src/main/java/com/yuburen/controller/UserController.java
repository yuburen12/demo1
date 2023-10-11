package com.yuburen.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuburen.entity.User;
import com.yuburen.query.UserQuery;
import com.yuburen.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("{id}")  //查询单个用户
    public User SelectOneUser(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @DeleteMapping("{id}")   //删除单个用户
    public void DeleteUserById(@PathVariable("id") Long id) {
        userService.removeById(id);
    }

    @PostMapping    //保存单个用户
    public void SaveUser(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping   //查询多个用户
    public List<User> SelectUserByIds(@RequestParam List<Long> ids) {
        return userService.listByIds(ids);
    }

    @PutMapping("/{id}/deduction/{money}")  //扣减money余额
    public void DeductMoneyById(@PathVariable("id") Long id,@PathVariable("money") Integer deductMoney) {
        userService.deductMoney(id,deductMoney);
    }

    @GetMapping("/list")   //根据复杂条件查询用户信息
    public List<User> SelectUsers(UserQuery userQuery) {
        return userService.queryUsers(userQuery.getName(),userQuery.getMinMoney(),userQuery.getMaxMoney());
    }

    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam String name) {
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> QueryWrapper = new QueryWrapper<>();
        QueryWrapper.like("name",name);
        return userService.page(page,QueryWrapper);


    }
}
