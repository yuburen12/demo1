package com.yuburen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuburen.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository //告诉容器你是持久层的 @Repository是spring提供的注释，能够将该类注册成Bean
public interface UserMapper extends BaseMapper<User> {

    void deductMoney(@Param("id")Long id, @Param("deductMoney")Integer deductMoney);

}
