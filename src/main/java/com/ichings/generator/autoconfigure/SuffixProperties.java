package com.ichings.generator.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 类名后缀（首字母大写）
 *
 * @author changebooks
 */
@Data
@ConfigurationProperties(prefix = "suffix")
public class SuffixProperties {
    /**
     * Persistent Object
     */
    private String persistentObject;

    /**
     * Persistent Object Mapping
     * 如：Copier
     */
    private String persistentObjectMapper;

    /**
     * Persistent Object Criteria
     * 如：Criteria
     */
    private String persistentObjectCriteria;

    /**
     * Mybatis Object Relational Mapping
     * 如：Mapper
     */
    private String mybatisObject;

    /**
     * Mybatis Object Relational Mapping Resources
     * 如：Mapper
     */
    private String mybatisResource;

    /**
     * Database Interface
     * 如：Database
     */
    private String databaseInterface;

    /**
     * Database Implements
     * 如：DatabaseImpl
     */
    private String databaseImpl;

    /**
     * Repository Interface
     * 如：Repository
     */
    private String repositoryInterface;

    /**
     * Repository Implements
     * 如：RepositoryImpl
     */
    private String repositoryImpl;

    /**
     * Data Transfer Object
     * 如：Dto
     */
    private String dataTransferObject;

    /**
     * Data Transfer Object Mapping
     * 如：DtoCopier
     */
    private String dataTransferObjectMapper;

    /**
     * Service Interface
     * 如：Service
     */
    private String serviceInterface;

    /**
     * Service Implements
     * 如：ServiceImpl
     */
    private String serviceImpl;

    /**
     * View Object
     * 如：Vo
     */
    private String viewObject;

    /**
     * View Object Mapping
     * 如：VoCopier
     */
    private String viewObjectMapper;

    /**
     * View Object Create Request
     * 如：CreateRequest
     */
    private String viewObjectCreateRequest;

    /**
     * View Object Update Request
     * 如：UpdateRequest
     */
    private String viewObjectUpdateRequest;

    /**
     * View Object Criteria Request
     * 如：CriteriaRequest
     */
    private String viewObjectCriteriaRequest;

    /**
     * Web Controller
     * 如：Controller
     */
    private String controller;

}
