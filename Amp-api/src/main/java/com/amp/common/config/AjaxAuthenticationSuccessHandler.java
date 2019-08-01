package com.amp.common.config;


import com.amp.common.utils.JSONUtils;
import com.amp.common.vo.BaseResult;
import com.google.common.collect.Maps;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(1);
        baseResult.setMsg("登陆成功" );
        Map<String,Object> result = Maps.newHashMap();
        result.put("role",authentication.getAuthorities().iterator().next().getAuthority());
        result.put("token",httpServletRequest.getSession().getId());
        baseResult.setResult(result);
        httpServletResponse.getWriter().write(JSONUtils.toJSONString(baseResult));
    }
}
