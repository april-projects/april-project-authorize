package com.mobaijun.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Description: [hash 工具类]
 * Author: [mobaijun]
 * Date: [2024/3/16 18:17]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class SHAUtil {

    /**
     * 日志记录器
     */
    private static final Logger logger = Logger.getLogger(SHAUtil.class.getName());


    /**
     * 对字符串进行 SHA 加密
     *
     * @param plainText 要加密的字符串
     * @return SHA 加密后的哈希值
     */
    public static String sha256(String plainText) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(plainText.getBytes());
            return bytesToHex(encodedHash);
        } catch (NoSuchAlgorithmException e) {
            logger.log(Level.SEVERE, "SHA algorithm not found", e);
            return null;
        }
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param bytes 字节数组
     * @return 十六进制字符串
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
