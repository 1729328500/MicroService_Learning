package top.whyh.userservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String mobile;

    @JsonIgnore
    private String password;

    @TableField("user_name")  // 显式指定字段映射
    private String userName;

    @TableField("avatar_url")
    private String avatarUrl;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}