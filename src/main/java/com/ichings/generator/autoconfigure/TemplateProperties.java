package com.ichings.generator.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 模板文件名（包含后缀）
 *
 * @author changebooks
 */
@Data
@ConfigurationProperties(prefix = "template")
public class TemplateProperties {
    /**
     * Persistent Object
     * 如：persistent-object.txt
     */
    private String persistentObject;

    /**
     * Persistent Object Mapping
     * 如：persistent-object-mapper.txt
     */
    private String persistentObjectMapper;

    /**
     * Persistent Object Criteria
     * 如：persistent-object-criteria.txt
     */
    private String persistentObjectCriteria;

    /**
     * Mybatis Object Relational Mapping
     * 如：mybatis-object.txt
     */
    private String mybatisObject;

    /**
     * Mybatis Object Relational Mapping Resources
     * 如：mybatis-resource.txt
     */
    private String mybatisResource;

    /**
     * Database Interface
     * 如：database-interface.txt
     */
    private String databaseInterface;

    /**
     * Database Implements
     * 如：database-impl.txt
     */
    private String databaseImpl;

    /**
     * Repository Interface
     * 如：repository-interface.txt
     */
    private String repositoryInterface;

    /**
     * Repository Implements
     * 如：repository-impl.txt
     */
    private String repositoryImpl;

    /**
     * Data Transfer Object
     * 如：data-transfer-object.txt
     */
    private String dataTransferObject;

    /**
     * Data Transfer Object Mapping
     * 如：data-transfer-object-mapper.txt
     */
    private String dataTransferObjectMapper;

    /**
     * Service Interface
     * 如：service-interface.txt
     */
    private String serviceInterface;

    /**
     * Service Implements
     * 如：service-impl.txt
     */
    private String serviceImpl;

    /**
     * View Object
     * 如：view-object.txt
     */
    private String viewObject;

    /**
     * View Object Mapping
     * 如：view-object-mapper.txt
     */
    private String viewObjectMapper;

    /**
     * View Object Create Request
     * 如：view-object-create-request.txt
     */
    private String viewObjectCreateRequest;

    /**
     * View Object Update Request
     * 如：view-object-update-request.txt
     */
    private String viewObjectUpdateRequest;

    /**
     * View Object Criteria Request
     * 如：view-object-criteria-request.txt
     */
    private String viewObjectCriteriaRequest;

    /**
     * Web Controller
     * 如：controller.txt
     */
    private String controller;

}
