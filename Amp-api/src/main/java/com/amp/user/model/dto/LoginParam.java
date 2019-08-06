package com.amp.user.model.dto;

import com.amp.common.annotion.QueryDesc;
import com.amp.common.annotion.QueryRuleEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 登陆参数
 *
 * @author caizy
 * @date 2019/7/23 14:12
 **/
@Data
public class LoginParam implements Serializable {

    @NotNull(message = "用户名不能为空")
    private String userName;

    @NotNull(message = "登陆密码不能为空")
    private String password;
}
