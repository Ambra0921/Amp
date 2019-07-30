package com.amp.common.config;


import com.amp.common.utils.JSONUtils;
import com.amp.common.vo.BaseResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆失败handle
 *
 * @author caizy
 * @date 2019/7/29 10:52
 **/
@Component
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(6);
        baseResult.setMsg("登陆失败");

        httpServletResponse.getWriter().write(JSONUtils.toJSONString(baseResult));
    }
}
