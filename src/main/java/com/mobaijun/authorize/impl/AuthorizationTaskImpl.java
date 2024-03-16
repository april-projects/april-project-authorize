package com.mobaijun.authorize.impl;

import com.mobaijun.authorize.AuthorizationTask;
import com.mobaijun.constant.Constant;
import com.mobaijun.util.EncryptionUtils;

import java.time.LocalDate;
import java.util.logging.Logger;

/**
 * Description: [授权实现类]
 * Author: [mobaijun]
 * Date: [2024/3/16 19:42]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class AuthorizationTaskImpl implements AuthorizationTask {

    /**
     * 日志
     */
    private static final Logger logger = Logger.getLogger(AuthorizationTaskImpl.class.getName());

    /**
     * 判断当前日期是否在有效期内
     * 注册日期字符串，格式为 "yyyy-MM-dd"
     *
     * @return 如果在有效期内则返回 true，否则返回 false
     */
    public static boolean isWithinValidityPeriod() {
        // 解析注册日期字符串为 LocalDate 对象
        LocalDate parsedDate = LocalDate.parse(EncryptionUtils.decrypt());

        // 获取当前日期
        LocalDate currentDate = LocalDate.now();

        // 获取到期日期（注册日期 + 7天）
        LocalDate expiryDate = parsedDate.plusDays(Constant.EXPIRY_DATE);

        // 判断当前日期是否在有效期内
        return !currentDate.isBefore(parsedDate) && !currentDate.isAfter(expiryDate);
    }

    @Override
    public void execute() {
        // 判断当前日期是否在有效期内
        if (!isWithinValidityPeriod()) {
            // 记录授权过期信息到日志
            logger.warning("授权已过期，请联系作者获取正版授权！");
            logger.warning("作者邮箱：mobaijun8@163.com");
            logger.warning("网站：https://docs.mobaijun.com/");

            // 终止程序执行
            System.exit(1);
        }
    }

    @Override
    public void init() {
        // 初始化加密字符串到本地文件
        EncryptionUtils.encrypt();
    }
}
