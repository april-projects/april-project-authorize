package com.mobaijun.constant;

import com.mobaijun.util.AESUtil;

import java.time.LocalDate;

/**
 * Description: [通用常量]
 * Author: [mobaijun]
 * Date: [2024/3/16 18:11]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class Constant {

    /**
     * 字母表
     */
    public static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
    /**
     * AES 密钥，16 字节
     */
    public static final String AES_KEY = "0123456789abcdef";
    /**
     * 密钥长度
     */
    public static final int KEY_LENGTH = 1024;
    /**
     * 到期时间，统一7天时间，即7天后过期
     */
    public static final Integer EXPIRY_DATE = 7;
    /**
     * 获取系统当前执行目录
     */
    public static final String CURRENT_DIR = System.getProperty("user.dir");
    /**
     * 获取当前系统用户名
     */
    private static final String USER_NAME = System.getProperty("user.name");
    /**
     * 获取当前系统用户目录
     */
    private static final String USER_HOME = System.getProperty("user.home");
    /**
     * 获取当前系统操作系统
     */
    private static final String OS_NAME = System.getProperty("os.name");
    /**
     * 获取当前系统时间
     */
    private static final LocalDate DATE_NOW = LocalDate.now();
    /**
     * 加密字符串
     */
    public static final String ENCRYPT_KEY = AESUtil.encrypt(String.format("|%s|%s|%s|%s|", USER_NAME, USER_HOME, OS_NAME, DATE_NOW));
    /**
     * 文件名
     */
    private static final String FILE_NAME = "authorization-code.txt";
    /**
     * 获取系统当前执行目录下的文件名
     */
    public static final String FILE_PATH = String.format("%s/src/main/resources/%s", CURRENT_DIR, FILE_NAME);
}
