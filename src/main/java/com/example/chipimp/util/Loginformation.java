package com.example.chipimp.util;

import com.example.chipimp.controller.Log4gTest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class Loginformation  {
    private static final Logger logger = Logger.getLogger("logfile");

    //请求头日志
    public void rqsheaderlog (HttpServletRequest request , HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        // 获取请求消息中所有头字段
        Enumeration headerNames = request.getHeaderNames();
        // 使用循环遍历所有请求头，并通过getHeader()方法获取一个指定名称的头字段
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            logger.info(headerName + " : " + request.getHeader(headerName));
        }
        Cookie[]cookies = request.getCookies();
        for(Cookie cookie: cookies) {
            logger.info("Cookie"+cookie.getName() + ":" + cookie.getValue());
        }

    }


}
