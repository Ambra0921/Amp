package com.amp.user.model.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserInfo implements Serializable {

    private Long id;

    private String userName;

    private String password;

    private Long creator;

    private Long updator;

    private Date createTime;

    private Date updateTime;
}
