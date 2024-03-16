package com.mobaijun.util;

import com.mobaijun.constant.Constant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description: [加解密方法]
 * Author: [mobaijun]
 * Date: [2024/3/16 18:54]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class EncryptionUtils {

    /**
     * 加密字符串
     */
    public static void encrypt() {
        String formatted = String.format("%s||||mobaijun||||%s", Constant.ENCRYPT_KEY, ConfusionEncryption.generateKey());
        FileUtils.checkAndWriteToFile(formatted);
    }

    /**
     * 解密字符串并获取日期
     *
     * @return 解密后的字符串日期
     */
    public static String decrypt() {
        String encryptedString = FileUtils.readFile(Constant.FILE_PATH);
        // 查找分隔符的位置
        int separatorIndex = encryptedString.indexOf("||||");
        // 截取分隔符之前的内容
        String contentBeforeSeparator = encryptedString.substring(0, separatorIndex);
        return extractDate(AESUtil.decrypt(contentBeforeSeparator));
    }

    /**
     * 从输入字符串中提取日期。
     *
     * @param input 输入字符串
     * @return 提取的日期字符串，如果没有找到日期则返回空字符串
     */
    public static String extractDate(String input) {
        // 定义日期匹配的正则表达式
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // 寻找匹配的日期子串
        String date = "";
        while (matcher.find()) {
            date = matcher.group();
        }

        return date;
    }
}
