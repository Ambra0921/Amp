package com.amp.common.config;


import com.amp.common.utils.JSONUtils;
import com.amp.common.vo.BaseResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拒绝访问handle
 *
 * @author caizy
 * @date 2019/7/29 10:52
 **/
@Component
public class AjaxAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(-2);
        baseResult.setMsg("需要授权");

        httpServletResponse.getWriter().write(JSONUtils.toJSONString(baseResult));
    }
}
