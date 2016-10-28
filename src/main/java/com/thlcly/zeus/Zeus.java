package com.thlcly.zeus;

import com.thlcly.zeus.enums.FileTypeEnum;
import com.thlcly.zeus.factory.JavaCodeStatisticsTool;
import com.thlcly.zeus.statistics.CodeStatistics;
import com.thlcly.zeus.utils.FileUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author tonyhui
 * @since 16/10/19
 */
public class Zeus {

    public static void main(String[] args){
        // 获取请求参数中的文件或者文件夹
        // 注意: 如果是用java -jar 在命令行下进行运行, 则可以使用'~'来指定当前用户的home目录, 因为在控制台下系统可以解析'~' -> '/Users/tonyhui'
        // 如果是使用intellij idea的program arguments下不能使用'~', 因为intellij idea不会将'~' -> '/Users/tonyhui', 所以就会造成找不到文件的错误
        CodeStatistics codeStatistics = new JavaCodeStatisticsTool().instance();
        Arrays.stream(args).forEach(arg -> {
            File file = new File(arg);
            // 如果输入的参数是一个目录
            List<File> files = FileUtils.listFiles(file, FileTypeEnum.JAVA);
            long count = files.stream().mapToLong(codeStatistics::statisticsCodeLine).sum();
            System.out.println(file.getName() + " 行数: " + count);
        });
    }
}