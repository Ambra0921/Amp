package com.amp.user.controller;

import com.amp.common.utils.ExceptionUtil;
import com.amp.common.utils.QueryUtils;
import com.amp.common.utils.UserUtil;
import com.amp.common.vo.BaseResult;
import com.amp.user.model.bo.UserInfo;
import com.amp.user.model.dto.ChangePasswordParam;
import com.amp.user.model.dto.SaveUserParam;
import com.amp.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

/**
 *
 * 用户controller
 * @author caizy
 * @date 2019/7/19
 */
@RestController
@RequestMapping(value = "user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult saveUser(SaveUserParam userInfo) {

        try{
            UserInfo user = new UserInfo();
            BeanUtils.copyProperties(userInfo,user);
            userService.saveOrUpdate(user);
            return BaseResult.successResult(userInfo);
        }catch (Exception e){
            return ExceptionUtil.fail(e);
        }
    }

    @RequestMapping(value = "/delUser",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult delUser(@Validated @NotNull(message = "id不能为空") Long id) {

        try{
            Boolean result = userService.removeById(id);
            return BaseResult.successResult(result);
        }catch (Exception e){
            return ExceptionUtil.fail(e);
        }
    }

    @RequestMapping(value = "/changePassword",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult changePassword(@Validated ChangePasswordParam passwordParam) {

        try{
            String userName = StringUtils.isEmpty(passwordParam.getUserName()) ?
                    UserUtil.getCurrentUser().getUsername():passwordParam.getUserName();
            UserInfo params = new UserInfo();
            params.setUserName(userName);
            UserInfo userInfo = userService.getOne(QueryUtils.initQueryWrapper(params));
            if(userInfo == null){
                return  BaseResult.fail(2,"用户不存在");
            }

            if(!userInfo.getPassword().equals(passwordParam.getOldPassword())){
                return  BaseResult.fail(2,"旧密码不正确");
            }
            userInfo.setPassword(passwordParam.getPassword());
            Boolean result = userService.saveOrUpdate(userInfo);
            return BaseResult.successResult(result);
        }catch (Exception e){
            return ExceptionUtil.fail(e);
        }
    }


    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult  getUserInfo(HttpServletRequest request) {

        try{
            UserInfo userInfo = userService.getById(UserUtil.getCurrentUser().getId());
            return BaseResult.successResult(userInfo);
        }catch (Exception e){
            return ExceptionUtil.fail(e);
        }
    }



}
