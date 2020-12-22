package com.ichings.generator.base;

/**
 * 常量
 *
 * @author changebooks
 */
public interface Constant {
    /**
     * 包名分隔符
     */
    String PACKAGE_SEPARATOR = ".";

    /**
     * 类文件后缀
     */
    String CLASS_SUFFIX = ".java";

    /**
     * 资源文件后缀
     */
    String RESOURCE_SUFFIX = ".xml";

    /**
     * 常用变量名
     * 如：
     * Object record = new Object();
     *
     * <foreach item="record">
     * userId = #{record.userId,jdbcType=BIGINT},
     */
    String VARIABLE_NAME = "record";

}
