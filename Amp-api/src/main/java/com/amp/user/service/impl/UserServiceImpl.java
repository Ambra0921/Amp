package com.amp.user.service.impl;

import com.amp.common.exception.BaseException;
import com.amp.user.dao.UserDao;
import com.amp.user.model.bo.UserInfo;
import com.amp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

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
        //判断用户名是否已经存在
        List<UserInfo> users = userDao.getUserInfo(userInfo);
        if(!CollectionUtils.isEmpty(users)){
            throw new BaseException("该用户名已经存在",2);
        }
        userInfo.setCreator(1L);
        userInfo.setCreateTime(new Date());
        userDao.saveUserInfo(userInfo);
    }
}
