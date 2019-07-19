package com.amp.user.dao;

import com.amp.user.model.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * 用户 Dao
 * @author caizy
 * @date 2019/7/19 15:23
 **/
@Repository
public interface UserDao {

    /**
     * 保存用户
     * @param userInfo
     * @return
     */
    long saveUserInfo(UserInfo userInfo);
}
