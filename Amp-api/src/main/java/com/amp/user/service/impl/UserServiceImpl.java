package com.amp.user.service.impl;

import com.amp.common.exception.BaseException;
import com.amp.common.utils.JSONUtils;
import com.amp.common.utils.Md5Util;
import com.amp.user.dao.UserDao;
import com.amp.user.model.bo.UserInfo;
import com.amp.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserDao,UserInfo> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void saveUserInfo(UserInfo userInfo) {
        //判断用户名是否已经存在
        log.error("获取用户信息参数：{}", JSONUtils.toJSONString(userInfo));
        List<UserInfo> users = userDao.getUserInfo(userInfo);
        log.error("获取用户信息 结果：{}", JSONUtils.toJSONString(users));
        if(!CollectionUtils.isEmpty(users)){
            throw new BaseException("该用户名已经存在");
        }
        //加密
        userInfo.setPassword(Md5Util.StringInMd5(userInfo.getPassword()));
        userInfo.setCreator(1L);
        userInfo.setCreateTime(new Date());
        userDao.saveUserInfo(userInfo);
    }

    @Override
    public UserInfo getUserInfo(UserInfo userInfo) {
        //判断用户名是否已经存在
        log.error("获取用户信息参数：{}", JSONUtils.toJSONString(userInfo));
        List<UserInfo> users = userDao.getUserInfo(userInfo);
        log.error("获取用户信息 结果：{}", JSONUtils.toJSONString(users));
        if(CollectionUtils.isEmpty(users)){
            return null;
        }
        return users.get(0);
    }
}
