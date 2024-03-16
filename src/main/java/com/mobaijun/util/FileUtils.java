package com.mobaijun.util;

import com.mobaijun.constant.Constant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Description: [文件工具类]
 * Author: [mobaijun]
 * Date: [2024/3/16 18:20]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
public class FileUtils {

    /**
     * 日志记录器
     */
    private static final Logger logger = Logger.getLogger(SHAUtil.class.getName());

    /**
     * 检测文件是否存在，如果不存在则创建并写入内容
     *
     * @param content 要写入的内容
     */
    public static void checkAndWriteToFile(String content) {
        File file = new File(Constant.FILE_PATH);
        if (!file.exists()) {
            try {
                // 文件不存在，创建文件并写入内容
                boolean created = file.createNewFile();
                if (created) {
                    writeToFile(content, file.getPath());
                } else {
                    logger.log(Level.WARNING, "创建文件失败：" + file.getPath());
                }
            } catch (IOException e) {
                logger.log(Level.SEVERE, "创建文件时出现异常", e);
            }
        } else {
            logger.log(Level.INFO, "文件已存在：" + file.getPath());
        }
    }

    /**
     * 将文本内容写入 .txt 文件
     *
     * @param content  要写入的内容
     * @param filePath 文件路径
     */
    private static void writeToFile(String content, String filePath) {
        try {
            FileWriter writer = new FileWriter(Constant.FILE_PATH);
            writer.write(content);
            writer.close();
            logger.log(Level.INFO, "文件写入成功：" + filePath);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "写入文件时出现异常", e);
        }
    }

    /**
     * 读取文件
     *
     * @param filePath 文件路径
     * @return 文件内容
     */
    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error reading from file", e);
        }
        return content.toString();
    }
}
