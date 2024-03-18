package com.mobaijun.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Description: [打开url地址工具类]
 * Author: [mobaijun]
 * Date: [2024/3/16 15:08]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class RunCommandRunner {

    /**
     * 日志记录器
     */
    private static final Logger logger = Logger.getLogger(RunCommandRunner.class.getName());

    /**
     * 打开指定 URL
     *
     * @param url 要打开的 URL
     */
    public static void openUrl(String url) {
        String os = System.getProperty("os.name").toLowerCase();
        // 使用操作系统特定的命令打开 URL
        if (os.contains("win")) {
            openUrlWindows(url);
        } else if (os.contains("mac")) {
            openUrlMac(url);
        }
        logger.log(Level.INFO, "Successfully opened URL: {}", url);
    }

    /**
     * Windows
     *
     * @param url url
     */
    private static void openUrlWindows(String url) {
        try {
            Runtime.getRuntime().exec("cmd /c start " + url);
        } catch (IOException e) {
            handleException(e);
        }
    }

    /**
     * macOS
     *
     * @param url url
     */
    private static void openUrlMac(String url) {
        try {
            Runtime.getRuntime().exec("open " + url);
        } catch (IOException e) {
            handleException(e);
        }
    }

    /**
     * 处理异常情况
     *
     * @param ex 异常对象
     */
    private static void handleException(Exception ex) {
        // 记录异常
        logger.log(Level.ALL, "Error opening the page. Please find the cause and try again: {}", ex.getMessage());
    }
}
