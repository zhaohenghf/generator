package com.ichings.generator.schema;

import com.ichings.generator.autoconfigure.PackageProperties;
import com.ichings.generator.base.AssertUtils;
import com.ichings.generator.base.Constant;
import com.ichings.generator.base.FileUtils;
import com.ichings.generator.base.JsonParser;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * 目录名（绝对路径）
 *
 * @author changebooks
 */
@Getter
public final class DirectorySchema implements Serializable {
    /**
     * Persistent Object
     * 如：tmp-generator/domain/model
     */
    private String persistentObject;

    /**
     * Persistent Object Mapper
     * 如：tmp-generator/domain/model
     */
    private String persistentObjectMapper;

    /**
     * Persistent Object Criteria
     * 如：tmp-generator/domain/model
     */
    private String persistentObjectCriteria;

    /**
     * Mybatis Object Relational Mapping
     * 如：tmp-generator/domain/mapper
     */
    private String mybatisObject;

    /**
     * Mybatis Object Relational Mapping Resources
     * 如：tmp-generator/resources/mappings
     */
    private String mybatisResource;

    /**
     * Database Interface
     * 如：tmp-generator/domain/database
     */
    private String databaseInterface;

    /**
     * Database Implements
     * 如：tmp-generator/domain/database/impl
     */
    private String databaseImpl;

    /**
     * Repository Interface
     * 如：tmp-generator/domain/repository
     */
    private String repositoryInterface;

    /**
     * Repository Implements
     * 如：tmp-generator/domain/repository/impl
     */
    private String repositoryImpl;

    /**
     * Data Transfer Object
     * 如：tmp-generator/biz/dto
     */
    private String dataTransferObject;

    /**
     * Data Transfer Object Mapper
     * 如：tmp-generator/biz/dto
     */
    private String dataTransferObjectMapper;

    /**
     * Service Interface
     * 如：tmp-generator/biz/service
     */
    private String serviceInterface;

    /**
     * Service Implements
     * 如：tmp-generator/biz/service/impl
     */
    private String serviceImpl;

    /**
     * View Object
     * 如：tmp-generator/web/vo
     */
    private String viewObject;

    /**
     * View Object Mapper
     * 如：tmp-generator/web/vo
     */
    private String viewObjectMapper;

    /**
     * View Object Create Request
     * 如：tmp-generator/web/vo
     */
    private String viewObjectCreateRequest;

    /**
     * View Object Update Request
     * 如：tmp-generator/web/vo
     */
    private String viewObjectUpdateRequest;

    /**
     * View Object Criteria Request
     * 如：tmp-generator/web/vo
     */
    private String viewObjectCriteriaRequest;

    /**
     * Web Controller
     * 如：tmp-generator/web/controller
     */
    private String controller;

    @Override
    public String toString() {
        return JsonParser.toJson(this);
    }

    /**
     * Build a new {@link DirectorySchema}.
     */
    public static final class Builder {

        private static final Logger logger = LoggerFactory.getLogger(Builder.class);

        /**
         * 存放生成代码的根目录，如：tmp-generator
         */
        private String directory;

        /**
         * 包名
         */
        private PackageProperties properties;

        /**
         * 创建DirectorySchema对象
         *
         * @return a DirectorySchema Object
         */
        public DirectorySchema create() {
            AssertUtils.nonEmpty(directory, "directory");
            AssertUtils.nonNull(properties, "properties");

            if (!FileUtils.delete(directory)) {
                logger.error("DirectorySchema.Builder delete directory failed, directory: {}", directory);
            }

            FileUtils.mkdirs(directory);

            DirectorySchema result = new DirectorySchema();

            result.persistentObject = getAndMkdir(properties.getPersistentObject());
            result.persistentObjectMapper = getAndMkdir(properties.getPersistentObjectMapper());
            result.persistentObjectCriteria = getAndMkdir(properties.getPersistentObjectCriteria());
            result.mybatisObject = getAndMkdir(properties.getMybatisObject());
            result.mybatisResource = getAndMkdir(properties.getMybatisResource());
            result.databaseInterface = getAndMkdir(properties.getDatabaseInterface());
            result.databaseImpl = getAndMkdir(properties.getDatabaseImpl());
            result.repositoryInterface = getAndMkdir(properties.getRepositoryInterface());
            result.repositoryImpl = getAndMkdir(properties.getRepositoryImpl());
            result.dataTransferObject = getAndMkdir(properties.getDataTransferObject());
            result.dataTransferObjectMapper = getAndMkdir(properties.getDataTransferObjectMapper());
            result.serviceInterface = getAndMkdir(properties.getServiceInterface());
            result.serviceImpl = getAndMkdir(properties.getServiceImpl());
            result.viewObject = getAndMkdir(properties.getViewObject());
            result.viewObjectMapper = getAndMkdir(properties.getViewObjectMapper());
            result.viewObjectCreateRequest = getAndMkdir(properties.getViewObjectCreateRequest());
            result.viewObjectUpdateRequest = getAndMkdir(properties.getViewObjectUpdateRequest());
            result.viewObjectCriteriaRequest = getAndMkdir(properties.getViewObjectCriteriaRequest());
            result.controller = getAndMkdir(properties.getController());

            return result;
        }

        /**
         * 包名 -> 目录地址，并创建目录
         *
         * @param packageName 包名，如：biz.service
         * @return 目录地址
         */
        public String getAndMkdir(String packageName) {
            AssertUtils.nonEmpty(packageName, "packageName");

            String path = directory + FileUtils.SEPARATOR + packageName.replace(Constant.PACKAGE_SEPARATOR, FileUtils.SEPARATOR);
            FileUtils.mkdirs(path);

            return path;
        }

        public Builder setDirectory(String directory) {
            this.directory = directory;
            return this;
        }

        public Builder setProperties(PackageProperties properties) {
            this.properties = properties;
            return this;
        }

    }

}
