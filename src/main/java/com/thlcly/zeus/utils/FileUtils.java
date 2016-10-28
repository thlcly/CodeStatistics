package com.thlcly.zeus.utils;

import com.google.common.collect.Lists;
import com.thlcly.zeus.enums.FileTypeEnum;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

/**
 * @author tonyhui
 * @since 16/10/28
 */
public class FileUtils {

    /**
     * 遍历指定目录下的所有的文件
     *
     * @param dir
     * @return
     */
    public static List<File> listFiles(File dir) {
        List<File> files = Lists.newArrayList();
        listFiles(dir, files);
        return files;
    }

    /**
     * 遍历已指定的文件后缀结尾的文件
     *
     * @param dir
     * @param fileType
     * @return
     */
    public static List<File> listFiles(File dir, FileTypeEnum fileType) {
        // 注意: 这里的条件不仅仅是以指定的后缀结尾时返回true , 如果是目录也要返回true, 因为虽然目录不以任何后缀结尾但是有可能目录中的文件含有以指定后缀结尾的文件
        return listFiles(dir, file -> file.getName().endsWith(fileType.getValue()) || file.isDirectory());
    }

    /**
     * 遍历符合指定FileFilter的文件
     *
     * @param dir
     * @param fileFilter
     * @return
     */
    public static List<File> listFiles(File dir, FileFilter fileFilter) {
        List<File> files = Lists.newArrayList();
        listFiles(dir, files, fileFilter);
        return files;
    }

    /*======================================= 私有方法 =======================================*/

    /**
     * 获取符合指定FileFilter的文件
     *
     * @param file
     * @param totalFiles
     * @param fileFilter
     */
    private static void listFiles(File file, List<File> totalFiles, FileFilter fileFilter) {
        // 校验file和fileFilter不能为null
        if (file == null || fileFilter == null) return;

        // 如果是文件, 则返回(终止条件)
        if (file.isFile() && fileFilter.accept(file)) {
            totalFiles.add(file);
            return;
        }

        // 如果是目录, 则进行遍历
        File[] files = file.listFiles(fileFilter);

        // 不是一个空目录
        if (files != null) {
            for (File f : files) {
                listFiles(f, totalFiles, fileFilter);
            }
        }
    }

    /**
     * 获取所有的文件
     *
     * @param file
     * @param totalFiles
     */
    private static void listFiles(File file, List<File> totalFiles) {
        if (file == null) return;

        // 如果是文件, 则返回(终止条件)
        if (file.isFile()) {
            totalFiles.add(file);
            return;
        }

        // 如果是目录, 则进行遍历
        File[] files = file.listFiles();
        // 不是一个空目录
        if (files != null) {
            for (File f : files) {
                listFiles(f, totalFiles);
            }
        }
    }
}
