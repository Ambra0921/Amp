package com.amp.user.controller;

import com.amp.user.model.UserInfo;
import com.amp.user.service.UserService;
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
  public UserInfo saveUser(UserInfo userInfo)
  {
     userService.saveUserInfo(userInfo);
    return userInfo;
  }
}
