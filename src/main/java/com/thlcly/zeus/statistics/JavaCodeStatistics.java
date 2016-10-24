package com.thlcly.zeus.statistics;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * @author tonyhui
 * @since 16/10/21
 */
public class JavaCodeStatistics implements CodeStatistics {

    @Override
    public long statisticsCodeLine(File file) {
        //统计代码行数
        try {
            FileInputStream fileInputStream = FileUtils.openInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;
            long count = 0;
            Boolean isMultiAnnotation = false;
            while ((line = br.readLine()) != null) {
                // 去除每一行行首和行尾的空白字符
                line = line.trim();

                if(StringUtils.isBlank(line)) continue;

                // 如果是单行注释
                if(line.startsWith("//")) continue;

                // 如果是多行注释结束
                if(line.startsWith("*/") || line.startsWith("**/") || line.endsWith("*/") || line.endsWith("**/")) {
                    isMultiAnnotation = false;
                    continue;
                }

                // 如果现在是在多行注释或者文档注释中
                if(isMultiAnnotation) continue;

                // 如果是多行注释开始
                if(line.startsWith("/*") || line.startsWith("/**")) {
                    isMultiAnnotation = true;
                    continue;
                }

                count++;
            }
            return count;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}