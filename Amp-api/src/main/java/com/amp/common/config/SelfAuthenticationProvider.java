package com.amp.common.config;

import com.amp.common.exception.BaseException;
import com.amp.common.utils.Md5Util;
import com.amp.user.model.bo.UserInfo;
import com.amp.user.model.result.LoginResult;
import com.amp.user.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * 其他拦截判断
 *
 * @author caizy
 * @date 2019/7/29 11:19
 **/
@Component
public class SelfAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private SelfUserDetailsService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = (String) authentication.getPrincipal(); // 这个获取表单输入中返回的用户名;
        String encodePwd  = (String) authentication.getCredentials(); // 这个是表单中输入的密码；

        if(StringUtils.isEmpty(userName)|| StringUtils.isEmpty(encodePwd)){
            throw new BaseException("用户名密码不能为空！");
        }

        UserDetails loginResult = (LoginResult) userService.loadUserByUsername(userName);

        if(loginResult == null){
            throw new BaseException("当前用户不存在，请重新登陆！");
        }

        if (!loginResult.getPassword().equals(encodePwd)) {
            throw new BaseException("用户名密码不正确，请重新登陆！");
        }

        return new UsernamePasswordAuthenticationToken(userName, encodePwd,loginResult.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
