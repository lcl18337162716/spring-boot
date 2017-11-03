package com.lcl.manager.core.interceptor;

import com.lcl.manager.core.jwt.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: jwt token拦截校验
 * @Package com.lcl.manager.core.interceptor
 * @Description: JwtTokenInterceptor
 * @date 2017/11/2
 */
public class JwtTokenInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
       /* String token = httpServletRequest.getHeader("Authorization");
        if(token == null){
            LOGGER.error("token>>>>>>>>>>>为空，非法访问");
        }
        String userId = jwtTokenUtil.generateToken(token);
        if(userId == null){
            LOGGER.error("toke不合法，非法访问");
        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        LOGGER.info("请求时候操作");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        LOGGER.info("请求后操作");
    }
}
