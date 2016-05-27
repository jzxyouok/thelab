/**
 * Yixiu.com Inc.
 * Copyright (c) 2015-2015 All Rights Reserved.
 */
package com.yang.thelab.common;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.yang.thelab.common.exception.BizCode;
import com.yang.thelab.common.exception.BizException;
import com.yang.thelab.common.vojo.Customer;

/**
 * 
 * @author YJ.yang
 * @version $Id: LoginInterceptor.java, v 0.1 2016年3月9日 下午12:49:33 dev Exp $
 */
public class LoginInterceptor implements HandlerInterceptor {
    private final static Logger LOG = LoggerFactory.getLogger(LoginInterceptor.class);

    private boolean             skipLogin;

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object obj, Exception e) throws Exception {
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj,
                           ModelAndView mv) throws Exception {

    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object obj) throws Exception {
        String requestURI = request.getRequestURI();
        LOG.info("请求地址(" + request.getRequestURI() + ")，请求参数(" + JSON.toJSONString(request.getParameterMap()) + ")");
        if (skipLogin) {
            return true;
        }
        Customer customer = (Customer) request.getSession().getAttribute("user");
        if (requestURI.endsWith("/api/dologin") || requestURI.endsWith("error.htm")) {
            return true;
        }
        if (customer == null) {
            throw new BizException(BizCode.NOT_LOGIN);
        }
        return true;
    }

    public void setSkipLogin(boolean skipLogin) {
        this.skipLogin = skipLogin;
    }
}
