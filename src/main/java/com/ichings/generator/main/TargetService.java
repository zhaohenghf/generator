package com.ichings.generator.main;

import com.ichings.generator.model.TagValue;
import com.ichings.generator.model.TargetCode;

/**
 * 目标代码
 *
 * @author changebooks
 */
public interface TargetService {
    /**
     * 获取目标代码
     *
     * @param tagValue TagValue
     * @return TargetCode
     */
    TargetCode getTargetCode(TagValue tagValue);

    /**
     * 替换全部标签
     *
     * @param tagValue 标签值
     * @param template 模板内容
     * @return 目标代码
     */
    String replaceAll(TagValue tagValue, String template);

    /**
     * 替换 ##persistent_object_*##
     *
     * @param tagValue 标签值
     * @param template 模板内容
     * @return 目标代码
     */
    String replacePersistentObject(TagValue tagValue, String template);

    /**
     * 替换 ##data_transfer_object_*##
     *
     * @param tagValue 标签值
     * @param template 模板内容
     * @return 目标代码
     */
    String replaceDataTransferObject(TagValue tagValue, String template);

    /**
     * 替换 ##view_object_*##
     *
     * @param tagValue 标签值
     * @param template 模板内容
     * @return 目标代码
     */
    String replaceViewObject(TagValue tagValue, String template);

    /**
     * 替换 ##mybatis_object_*##
     *
     * @param tagValue 标签值
     * @param template 模板内容
     * @return 目标代码
     */
    String replaceMybatis(TagValue tagValue, String template);

    /**
     * 替换 ##database_*##
     *
     * @param tagValue 标签值
     * @param template 模板内容
     * @return 目标代码
     */
    String replaceDatabase(TagValue tagValue, String template);

    /**
     * 替换 ##repository_*##
     *
     * @param tagValue 标签值
     * @param template 模板内容
     * @return 目标代码
     */
    String replaceRepository(TagValue tagValue, String template);

    /**
     * 替换 ##service_*##
     *
     * @param tagValue 标签值
     * @param template 模板内容
     * @return 目标代码
     */
    String replaceService(TagValue tagValue, String template);

    /**
     * 替换 ##controller_*##
     *
     * @param tagValue 标签值
     * @param template 模板内容
     * @return 目标代码
     */
    String replaceController(TagValue tagValue, String template);

}
