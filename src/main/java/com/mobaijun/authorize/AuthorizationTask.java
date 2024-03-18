package com.mobaijun.authorize;

/**
 * Description: [限定接口]
 * Author: [mobaijun]
 * Date: [2024/3/16 19:41]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public interface AuthorizationTask {

    /**
     * 执行授权任务
     */
    void execute(Integer expiryDate);

    /**
     * 初始化授权任务
     */
    void init();
}
