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
    private static final Logger logger = Logger.getLogger(FileUtils.class.getName());

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
                    logger.log(Level.WARNING, "File creation failure：" + file.getPath());
                }
            } catch (IOException e) {
                logger.log(Level.SEVERE, "An exception occurred while creating the file", e.getMessage());
            }
        } else {
            logger.log(Level.INFO, "File already exists：" + file.getPath());
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
            logger.log(Level.INFO, "File write success：" + filePath);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "An exception occurred while writing the file", e);
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
