package com.amp.common.config;

import com.amp.common.utils.JSONUtils;
import com.amp.common.vo.BaseResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登出
 *
 * @author caizy
 * @date 2019/7/29 11:17
 **/
@Component
public class AjaxLogoutSuccessHandler  implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(3);
        baseResult.setMsg("退出登陆成功");
        httpServletResponse.getWriter().write(JSONUtils.toJSONString(baseResult));
    }
}
