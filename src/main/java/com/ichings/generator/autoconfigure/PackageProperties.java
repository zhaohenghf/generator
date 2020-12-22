package com.ichings.generator.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 包名
 *
 * @author changebooks
 */
@Data
@ConfigurationProperties(prefix = "package")
public class PackageProperties {
    /**
     * Persistent Object
     * 如：domain.model
     */
    private String persistentObject;

    /**
     * Persistent Object Mapper
     * 如：domain.model
     */
    private String persistentObjectMapper;

    /**
     * Persistent Object Criteria
     * 如：domain.model
     */
    private String persistentObjectCriteria;

    /**
     * Mybatis Object Relational Mapping
     * 如：domain.mapper
     */
    private String mybatisObject;

    /**
     * Mybatis Object Relational Mapping Resources
     * 如：resources.mappings
     */
    private String mybatisResource;

    /**
     * Database Interface
     * 如：domain.database
     */
    private String databaseInterface;

    /**
     * Database Implements
     * 如：domain.database.impl
     */
    private String databaseImpl;

    /**
     * Repository Interface
     * 如：domain.repository
     */
    private String repositoryInterface;

    /**
     * Repository Implements
     * 如：domain.repository.impl
     */
    private String repositoryImpl;

    /**
     * Data Transfer Object
     * 如：biz.dto
     */
    private String dataTransferObject;

    /**
     * Data Transfer Object Mapper
     * 如：biz.dto
     */
    private String dataTransferObjectMapper;

    /**
     * Service Interface
     * 如：biz.service
     */
    private String serviceInterface;

    /**
     * Service Implements
     * 如：biz.service.impl
     */
    private String serviceImpl;

    /**
     * View Object
     * 如：web.vo
     */
    private String viewObject;

    /**
     * View Object Mapper
     * 如：web.vo
     */
    private String viewObjectMapper;

    /**
     * View Object Create Request
     * 如：web.vo
     */
    private String viewObjectCreateRequest;

    /**
     * View Object Update Request
     * 如：web.vo
     */
    private String viewObjectUpdateRequest;

    /**
     * View Object Criteria Request
     * 如：web.vo
     */
    private String viewObjectCriteriaRequest;

    /**
     * Web Controller
     * 如：web.controller
     */
    private String controller;

}
