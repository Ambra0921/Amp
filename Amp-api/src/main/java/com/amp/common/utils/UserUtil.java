package com.amp.common.utils;

import com.amp.user.model.result.LoginResult;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;

/**
 * 用户工具类
 *
 * @author caizy
 * @date 2019/8/6 16:11
 **/
public class UserUtil {

    public UserUtil(){

    }

    /**
     * 获取session中的用户名
     * @return
     */
    public static LoginResult getCurrentUser() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((LoginResult) principal);
        }else{
            return null;
        }

    }
}
