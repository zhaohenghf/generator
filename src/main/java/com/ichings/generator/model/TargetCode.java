package com.ichings.generator.model;

import com.ichings.generator.base.JsonParser;
import lombok.Data;

import java.io.Serializable;

/**
 * 目标代码
 *
 * @author changebooks
 */
@Data
public final class TargetCode implements Serializable {
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

}
