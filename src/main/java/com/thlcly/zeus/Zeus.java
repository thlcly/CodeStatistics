package com.thlcly.zeus;

import com.thlcly.zeus.factory.JavaCodeStatisticsTool;

import java.io.File;
import java.util.Arrays;

/**
 * @author tonyhui
 * @since 16/10/19
 */
public class Zeus {
    public static void main(String[] args){
        // 获取请求参数中的文件或者文件夹
        Arrays.stream(args).forEach(arg -> {
            File file = new File("/Users/tonyhui/Desktop/DepartmentController.java");
            long count = new JavaCodeStatisticsTool().instance().statisticsCodeLine(file);
            System.out.println(file.getName() + " 行数: " + count);
        });
    }
}