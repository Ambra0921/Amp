package com.amp.user.controller;

import com.amp.common.utils.ExceptionUtil;
import com.amp.common.vo.BaseResult;
import com.amp.user.model.bo.UserInfo;
import com.amp.user.model.dto.LoginParam;
import com.amp.user.model.dto.SaveUserParam;
import com.amp.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * 用户controller
 * @author caizy
 * @date 2019/7/19
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/saveUser",method = RequestMethod.PUT)
    @ResponseBody
    public BaseResult<UserInfo> saveUser(SaveUserParam userInfo) {

        try{
          UserInfo user = new UserInfo();
          BeanUtils.copyProperties(userInfo,user);
          userService.saveUserInfo(user);
          BaseResult result = new BaseResult();
          return result.successResult(userInfo);
        }catch (Exception e){
          return ExceptionUtil.fail(e);
        }

    }
    @RequestMapping(value = "/saveUser",method = RequestMethod.PUT)
    @ResponseBody
    public void login(LoginParam login)
    {
//        userService.saveUserInfo(userInfo);
//        return userInfo;
    }

}
