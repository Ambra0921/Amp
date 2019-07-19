package com.amp.user.service.impl;

import com.amp.user.dao.UserDao;
import com.amp.user.model.UserInfo;
import com.amp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

/**
 * 用户Service 实现类
 *
 * @author caizy
 * @date 2019/7/19 15:22
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void saveUserInfo(UserInfo userInfo) {
        userInfo.setCreator(1L);
        userDao.saveUserInfo(userInfo);
    }
}
