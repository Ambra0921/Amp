package com.amp.common.config;

import com.amp.user.model.bo.UserInfo;
import com.amp.user.model.result.LoginResult;
import com.amp.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 *  ② 根据 username 获取数据库 user 信息
 */
@Component
public class SelfUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //构建用户信息的逻辑(取数据库/LDAP等用户信息)
        LoginResult userInfo = new LoginResult();

        UserInfo params = new UserInfo();
        params.setUserName(username);

        UserInfo user = userService.getUserInfo(params);

        if(user == null){
            return null;
        }

        //拷贝信息
        BeanUtils.copyProperties(user,userInfo);
        userInfo.setUsername(user.getUserName());
        Set authoritiesSet = new HashSet();
        GrantedAuthority authority = new SimpleGrantedAuthority("admin"); // 模拟从数据库中获取用户角色


        authoritiesSet.add(authority);
        userInfo.setAuthorities(authoritiesSet);

        return userInfo;
    }
}
