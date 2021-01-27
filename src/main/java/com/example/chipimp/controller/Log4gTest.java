package com.example.chipimp.controller;

import org.apache.log4j.Logger;

public class Log4gTest {
    private static final Logger logger = Logger.getLogger("logfile");

    public static void main(String[] args) {
        // 记录debug级别的信息
        logger.debug("This is debug message.debug的测试");
        // 记录info级别的信息
        logger.info("This is info message.info的测试");
        // 记录error级别的信息
        logger.error("This is error message.error的测试");
    }
}
