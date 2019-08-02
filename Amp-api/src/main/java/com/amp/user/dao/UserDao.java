package com.amp.user.dao;

import com.amp.user.model.bo.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户 Dao
 * @author caizy
 * @date 2019/7/19 15:23
 **/
@Repository
public interface UserDao  extends BaseMapper<UserInfo> {

    /**
     * 保存用户
     * @param userInfo
     * @return
     */
    long saveUserInfo(UserInfo userInfo);


    /**
     * 查询用户信息
     */
    List<UserInfo> getUserInfo(UserInfo userInfo);

    /**
     * 删除用户信息
     * @param userInfo
     * @return
     */
    boolean delUserInfo(UserInfo userInfo);

    /**
     * 查询用户列表
     * @param userInfo
     * @return
     */
    List<UserInfo> queryUsers(UserInfo userInfo);
}
