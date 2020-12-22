package com.ichings.generator.model;

import com.ichings.generator.base.JsonParser;
import lombok.Data;

import java.io.Serializable;

/**
 * 绝对路径
 *
 * @author changebooks
 */
@Data
public final class AbsolutePath implements Serializable {
    /**
     * Persistent Object
     * 如：tmp-generator/domain/model/User.java
     */
    private String persistentObject;

    /**
     * Persistent Object Mapper
     * 如：tmp-generator/domain/model/UserCopier.java
     */
    private String persistentObjectMapper;

    /**
     * Persistent Object Criteria
     * 如：tmp-generator/domain/model/UserCriteria.java
     */
    private String persistentObjectCriteria;

    /**
     * Mybatis Object Relational Mapping
     * 如：tmp-generator/domain/mapper/UserMapper.java
     */
    private String mybatisObject;

    /**
     * Mybatis Object Relational Mapping Resources
     * 如：tmp-generator/resources/mappings/UserMapper.xml
     */
    private String mybatisResource;

    /**
     * Database Interface
     * 如：tmp-generator/domain/database/UserDatabase.java
     */
    private String databaseInterface;

    /**
     * Database Implements
     * 如：tmp-generator/domain/database/impl/UserDatabaseImpl.java
     */
    private String databaseImpl;

    /**
     * Repository Interface
     * 如：tmp-generator/domain/repository/UserRepository.java
     */
    private String repositoryInterface;

    /**
     * Repository Implements
     * 如：tmp-generator/domain/repository/impl/UserRepositoryImpl.java
     */
    private String repositoryImpl;

    /**
     * Data Transfer Object
     * 如：tmp-generator/biz/dto/UserDto.java
     */
    private String dataTransferObject;

    /**
     * Data Transfer Object Mapper
     * 如：tmp-generator/biz/dto/UserDtoCopier.java
     */
    private String dataTransferObjectMapper;

    /**
     * Service Interface
     * 如：tmp-generator/biz/service/UserService.java
     */
    private String serviceInterface;

    /**
     * Service Implements
     * 如：tmp-generator/biz/service/impl/UserServiceImpl.java
     */
    private String serviceImpl;

    /**
     * View Object
     * 如：tmp-generator/web/vo/UserVo.java
     */
    private String viewObject;

    /**
     * View Object Mapper
     * 如：tmp-generator/web/vo/UserVoCopier.java
     */
    private String viewObjectMapper;

    /**
     * View Object Create Request
     * 如：tmp-generator/web/vo/UserCreateRequest.java
     */
    private String viewObjectCreateRequest;

    /**
     * View Object Update Request
     * 如：tmp-generator/web/vo/UserUpdateRequest.java
     */
    private String viewObjectUpdateRequest;

    /**
     * View Object Criteria Request
     * 如：tmp-generator/web/vo/UserCriteriaRequest.java
     */
    private String viewObjectCriteriaRequest;

    /**
     * Web Controller
     * 如：tmp-generator/web/controller/UserController.java
     */
    private String controller;

    @Override
    public String toString() {
        return JsonParser.toJson(this);
    }

}
