package com.amp.user.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 修改密码DTO
 *
 * @author caizy
 * @date 2019/8/6 16:19
 **/
@Data
public class ChangePasswordParam implements Serializable {

    @NotNull(message = "登陆密码不能为空")
    private String oldPassword;

    @NotNull(message = "登陆密码不能为空")
    private String password;

    private String userName;
}
