package com.ichings.generator.schema;

import com.ichings.generator.autoconfigure.PackageProperties;
import com.ichings.generator.base.AssertUtils;
import com.ichings.generator.base.Constant;
import com.ichings.generator.base.JsonParser;
import lombok.Getter;

import java.io.Serializable;

/**
 * 包名（全路径）
 *
 * @author changebooks
 */
@Getter
public final class PackageSchema implements Serializable {
    /**
     * Persistent Object
     * 如：com.***.code.domain.model
     */
    private String persistentObject;

    /**
     * Persistent Object Mapper
     * 如：com.***.code.domain.model
     */
    private String persistentObjectMapper;

    /**
     * Persistent Object Criteria
     * 如：com.***.code.domain.model
     */
    private String persistentObjectCriteria;

    /**
     * Mybatis Object Relational Mapping
     * 如：com.***.code.domain.mapper
     */
    private String mybatisObject;

    /**
     * Database Interface
     * 如：com.***.code.domain.database
     */
    private String databaseInterface;

    /**
     * Database Implements
     * 如：com.***.code.domain.database.impl
     */
    private String databaseImpl;

    /**
     * Repository Interface
     * 如：com.***.code.domain.repository
     */
    private String repositoryInterface;

    /**
     * Repository Implements
     * 如：com.***.code.domain.repository.impl
     */
    private String repositoryImpl;

    /**
     * Data Transfer Object
     * 如：com.***.code.biz.dto
     */
    private String dataTransferObject;

    /**
     * Data Transfer Object Mapper
     * 如：com.***.code.biz.dto
     */
    private String dataTransferObjectMapper;

    /**
     * Service Interface
     * 如：com.***.code.biz.service
     */
    private String serviceInterface;

    /**
     * Service Implements
     * 如：com.***.code.biz.service.impl
     */
    private String serviceImpl;

    /**
     * View Object
     * 如：com.***.code.web.vo
     */
    private String viewObject;

    /**
     * View Object Mapper
     * 如：com.***.code.web.vo
     */
    private String viewObjectMapper;

    /**
     * View Object Create Request
     * 如：com.***.code.web.vo
     */
    private String viewObjectCreateRequest;

    /**
     * View Object Update Request
     * 如：com.***.code.web.vo
     */
    private String viewObjectUpdateRequest;

    /**
     * View Object Criteria Request
     * 如：com.***.code.web.vo
     */
    private String viewObjectCriteriaRequest;

    /**
     * Web Controller
     * 如：com.***.code.web.controller
     */
    private String controller;

    @Override
    public String toString() {
        return JsonParser.toJson(this);
    }

    /**
     * Build a new {@link PackageSchema}.
     */
    public static final class Builder {
        /**
         * 生成代码的根包名，如：com.***.code
         */
        private String packageName;

        /**
         * 包名
         */
        private PackageProperties properties;

        /**
         * 创建PackageSchema对象
         *
         * @return a PackageSchema Object
         */
        public PackageSchema create() {
            AssertUtils.nonEmpty(packageName, "packageName");
            AssertUtils.nonNull(properties, "properties");

            PackageSchema result = new PackageSchema();

            result.persistentObject = packageName + Constant.PACKAGE_SEPARATOR + properties.getPersistentObject();
            result.persistentObjectMapper = packageName + Constant.PACKAGE_SEPARATOR + properties.getPersistentObjectMapper();
            result.persistentObjectCriteria = packageName + Constant.PACKAGE_SEPARATOR + properties.getPersistentObjectCriteria();
            result.mybatisObject = packageName + Constant.PACKAGE_SEPARATOR + properties.getMybatisObject();
            result.databaseInterface = packageName + Constant.PACKAGE_SEPARATOR + properties.getDatabaseInterface();
            result.databaseImpl = packageName + Constant.PACKAGE_SEPARATOR + properties.getDatabaseImpl();
            result.repositoryInterface = packageName + Constant.PACKAGE_SEPARATOR + properties.getRepositoryInterface();
            result.repositoryImpl = packageName + Constant.PACKAGE_SEPARATOR + properties.getRepositoryImpl();
            result.dataTransferObject = packageName + Constant.PACKAGE_SEPARATOR + properties.getDataTransferObject();
            result.dataTransferObjectMapper = packageName + Constant.PACKAGE_SEPARATOR + properties.getDataTransferObjectMapper();
            result.serviceInterface = packageName + Constant.PACKAGE_SEPARATOR + properties.getServiceInterface();
            result.serviceImpl = packageName + Constant.PACKAGE_SEPARATOR + properties.getServiceImpl();
            result.viewObject = packageName + Constant.PACKAGE_SEPARATOR + properties.getViewObject();
            result.viewObjectMapper = packageName + Constant.PACKAGE_SEPARATOR + properties.getViewObjectMapper();
            result.viewObjectCreateRequest = packageName + Constant.PACKAGE_SEPARATOR + properties.getViewObjectCreateRequest();
            result.viewObjectUpdateRequest = packageName + Constant.PACKAGE_SEPARATOR + properties.getViewObjectUpdateRequest();
            result.viewObjectCriteriaRequest = packageName + Constant.PACKAGE_SEPARATOR + properties.getViewObjectCriteriaRequest();
            result.controller = packageName + Constant.PACKAGE_SEPARATOR + properties.getController();

            return result;
        }

        public Builder setPackageName(String packageName) {
            this.packageName = packageName;
            return this;
        }

        public Builder setProperties(PackageProperties properties) {
            this.properties = properties;
            return this;
        }

    }

}
