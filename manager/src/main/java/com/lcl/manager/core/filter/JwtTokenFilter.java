package com.lcl.manager.core.filter;


import com.lcl.manager.core.jwt.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author liuchaolong
 * @version V1.0
 * @Title: jwtToken校验
 * @Package com.lcl.manager.core.filter
 * @Description: 首个拦截，校验token是否合法
 * @date 2017/11/1
 */
@WebFilter(filterName="jwtTokenFilter",urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")//忽略资源
        }
)
@Order(1)
public class JwtTokenFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenFilter.class);
    /**
     * JWT工具类
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        /*HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null){
            LOGGER.error("token>>>>>>>>>>>为空，非法访问");
        }
        String userId = jwtTokenUtil.generateToken(token);
        if(userId == null){
            LOGGER.error("toke不合法，非法访问");
        }
*/
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
