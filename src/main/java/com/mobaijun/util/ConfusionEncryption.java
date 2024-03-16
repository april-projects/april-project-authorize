package com.mobaijun.util;

import java.util.Random;

import static com.mobaijun.constant.Constant.ALPHABET;
import static com.mobaijun.constant.Constant.KEY_LENGTH;

/**
 * Description: [自定义混淆加密算法]
 * Author: [mobaijun]
 * Date: [2024/3/16 18:24]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class ConfusionEncryption {

    /**
     * 生成随机密钥
     *
     * @return 随机生成的密钥
     */
    public static String generateKey() {
        Random random = new Random();
        StringBuilder keyBuilder = new StringBuilder();
        for (int i = 0; i < KEY_LENGTH; i++) {
            keyBuilder.append(ALPHABET[random.nextInt(ALPHABET.length)]);
        }
        return keyBuilder.toString();
    }
}
