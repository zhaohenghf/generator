package com.ichings.generator.schema;

import com.ichings.generator.autoconfigure.TemplateProperties;
import com.ichings.generator.base.AssertUtils;
import com.ichings.generator.base.FileUtils;
import com.ichings.generator.base.JsonParser;
import com.ichings.generator.base.Placeholder;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 * 模板
 *
 * @author changebooks
 */
@Getter
public final class TemplateSchema implements Serializable {
    /**
     * Persistent Object
     */
    private String persistentObject;

    /**
     * Persistent Object Mapping
     */
    private String persistentObjectMapper;

    /**
     * Persistent Object Criteria
     */
    private String persistentObjectCriteria;

    /**
     * Mybatis Object Relational Mapping
     */
    private String mybatisObject;

    /**
     * Mybatis Object Relational Mapping Resources
     */
    private String mybatisResource;

    /**
     * Database Interface
     */
    private String databaseInterface;

    /**
     * Database Implements
     */
    private String databaseImpl;

    /**
     * Repository Interface
     */
    private String repositoryInterface;

    /**
     * Repository Implements
     */
    private String repositoryImpl;

    /**
     * Data Transfer Object
     */
    private String dataTransferObject;

    /**
     * Data Transfer Object Mapping
     */
    private String dataTransferObjectMapper;

    /**
     * Service Interface
     */
    private String serviceInterface;

    /**
     * Service Implements
     */
    private String serviceImpl;

    /**
     * View Object
     */
    private String viewObject;

    /**
     * View Object Mapping
     */
    private String viewObjectMapper;

    /**
     * View Object Create Request
     */
    private String viewObjectCreateRequest;

    /**
     * View Object Update Request
     */
    private String viewObjectUpdateRequest;

    /**
     * View Object Criteria Request
     */
    private String viewObjectCriteriaRequest;

    /**
     * Web Controller
     */
    private String controller;

    @Override
    public String toString() {
        return JsonParser.toJson(this);
    }

    /**
     * Build a new {@link TemplateSchema}.
     */
    public static final class Builder {
        /**
         * 存放模板的根目录，如：template
         */
        private String directory;

        /**
         * 模板文件名（包含后缀）
         */
        private TemplateProperties properties;

        /**
         * 生成代码的作者名（替换模板中的##author_name##）
         */
        private String authorName;

        /**
         * 创建TemplateSchema对象
         *
         * @return a TemplateSchema Object
         */
        public TemplateSchema create() throws IOException {
            AssertUtils.nonEmpty(directory, "directory");
            AssertUtils.nonNull(properties, "properties");
            AssertUtils.nonEmpty(authorName, "authorName");

            TemplateSchema result = new TemplateSchema();

            result.persistentObject = readAndReplace(properties.getPersistentObject());
            result.persistentObjectMapper = readAndReplace(properties.getPersistentObjectMapper());
            result.persistentObjectCriteria = readAndReplace(properties.getPersistentObjectCriteria());
            result.mybatisObject = readAndReplace(properties.getMybatisObject());
            result.mybatisResource = readAndReplace(properties.getMybatisResource());
            result.databaseInterface = readAndReplace(properties.getDatabaseInterface());
            result.databaseImpl = readAndReplace(properties.getDatabaseImpl());
            result.repositoryInterface = readAndReplace(properties.getRepositoryInterface());
            result.repositoryImpl = readAndReplace(properties.getRepositoryImpl());
            result.dataTransferObject = readAndReplace(properties.getDataTransferObject());
            result.dataTransferObjectMapper = readAndReplace(properties.getDataTransferObjectMapper());
            result.serviceInterface = readAndReplace(properties.getServiceInterface());
            result.serviceImpl = readAndReplace(properties.getServiceImpl());
            result.viewObject = readAndReplace(properties.getViewObject());
            result.viewObjectMapper = readAndReplace(properties.getViewObjectMapper());
            result.viewObjectCreateRequest = readAndReplace(properties.getViewObjectCreateRequest());
            result.viewObjectUpdateRequest = readAndReplace(properties.getViewObjectUpdateRequest());
            result.viewObjectCriteriaRequest = readAndReplace(properties.getViewObjectCriteriaRequest());
            result.controller = readAndReplace(properties.getController());

            return result;
        }

        /**
         * 读模板内容，并替换“##author_name##”标签
         *
         * @param fileName 模板文件名（包含后缀），如：***.txt
         * @return 模板内容
         * @throws IOException 读模板失败
         */
        public String readAndReplace(String fileName) throws IOException {
            AssertUtils.nonEmpty(fileName, "fileName");

            String path = directory + FileUtils.SEPARATOR + fileName;
            File file = new File(path);

            String template = FileUtils.getChars(file);
            AssertUtils.nonEmpty(template, "template");

            return template.replace(Placeholder.AUTHOR_NAME, authorName);
        }

        public Builder setDirectory(String directory) {
            this.directory = directory;
            return this;
        }

        public Builder setProperties(TemplateProperties properties) {
            this.properties = properties;
            return this;
        }

        public Builder setAuthorName(String authorName) {
            this.authorName = authorName;
            return this;
        }

    }

}
