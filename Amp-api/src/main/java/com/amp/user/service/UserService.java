package com.amp.user.service;

import com.amp.user.model.bo.UserInfo;

/**
 *
 * 用户service
 * @author caizy
 * @date 2019/7/19
 */

public interface UserService {

    /**
     * 保存用户
     * @param userInfo
     * @return
     */
    void saveUserInfo(UserInfo userInfo);
}
