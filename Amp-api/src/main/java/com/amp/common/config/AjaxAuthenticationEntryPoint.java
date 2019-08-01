package com.amp.common.config;


import com.amp.common.utils.JSONUtils;
import com.amp.common.vo.BaseResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户没有登录时返回给前端的数据
 *
 * @author caizy
 * @date 2019/7/29 10:52
 **/
@Component
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        BaseResult responseBody = new BaseResult();

        responseBody.setCode(2);
        responseBody.setMsg("Need Authorities!");
        httpServletResponse.getWriter().write(JSONUtils.toJSONString(responseBody));
    }
}
