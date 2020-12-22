package com.ichings.generator.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * 业务
 *
 * @author changebooks
 */
@Data
@ConfigurationProperties(prefix = "biz")
public class BizProperties {
    /**
     * 生成代码的包名
     * 如：com.google.code
     */
    private String packageName;

    /**
     * 生成代码的作者名（替换模板中的##author_name##）
     * 如：张三
     */
    private String authorName;

    /**
     * 表名
     * 如：user, account, account_flow, credit, credit_flow
     */
    private List<String> tableName;

    /**
     * 存放模板的目录（建议绝对路径）
     * 如：template
     */
    private String templateDirectory;

    /**
     * 存放生成代码的目录（建议绝对路径）
     * 如：tmp-generator
     */
    private String targetDirectory;

}
