package com.amp.user.model.bo;

import com.amp.common.annotion.QueryDesc;
import com.amp.common.annotion.QueryRuleEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "t_user")
public class UserInfo implements Serializable {

    @TableId(type = IdType.AUTO)
    @QueryDesc(op = QueryRuleEnum.EQ)
    private Long id;

    @TableField(value = "user_name")
    @QueryDesc(field = "user_name",op = QueryRuleEnum.EQ)
    private String userName;

    @TableField(value = "nick_name")
    @QueryDesc(field = "nick_name",op = QueryRuleEnum.EQ)
    private String nickName;

    @TableField(value = "sex")
    @QueryDesc(op = QueryRuleEnum.EQ)
    private Integer sex;

    @TableField(value = "password")
    private String password;

    @TableField(value = "creator")
    private Long creator;

    @TableField(value = "updator")
    private Long updator;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "update_time")
    private Date updateTime;
}
