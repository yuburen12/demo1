package com.yuburen.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_user")
public class User {
    @TableId(value = "id")
    private Long id;
    private String name;

    private String password;

    private String address;

    private Integer money;
    @TableLogic
    private Integer deleted;

}
