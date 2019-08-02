package com.amp.user.service;

import com.amp.user.model.bo.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 * 用户service
 * @author caizy
 * @date 2019/7/19
 */

public interface UserService extends IService<UserInfo> {

    /**
     * 保存用户
     * @param userInfo
     * @return
     */
    void saveUserInfo(UserInfo userInfo);

    /**
     * 获取用户信息
     * @param userInfo
     * @return
     */
    UserInfo getUserInfo(UserInfo userInfo);
}
