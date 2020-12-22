package com.ichings.generator.main;

import com.ichings.generator.model.AbsolutePath;
import com.ichings.generator.model.TagValue;

/**
 * 文件路径
 *
 * @author changebooks
 */
public interface PathService {
    /**
     * 获取绝对路径
     *
     * @param tagValue TagValue
     * @return AbsolutePath
     */
    AbsolutePath getAbsolutePath(TagValue tagValue);

    /**
     * 拼接类文件路径
     *
     * @param directory 目录名（绝对路径）
     * @param className 类名
     * @return 绝对路径
     */
    String joinClass(String directory, String className);

    /**
     * 拼接资源文件路径
     *
     * @param directory    目录名（绝对路径）
     * @param resourceName 资源名
     * @return 绝对路径
     */
    String joinResource(String directory, String resourceName);

}
