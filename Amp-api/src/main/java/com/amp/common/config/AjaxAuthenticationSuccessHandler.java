package com.amp.common.config;


import com.amp.common.utils.JSONUtils;
import com.amp.common.vo.BaseResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆成功handle
 *
 * @author caizy
 * @date 2019/7/29 10:52
 **/
@Component
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(1);
        baseResult.setMsg("Login success!!");

        httpServletResponse.getWriter().write(JSONUtils.toJSONString(baseResult));
    }
}
