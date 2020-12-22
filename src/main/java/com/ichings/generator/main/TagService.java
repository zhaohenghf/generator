package com.ichings.generator.main;

import com.ichings.generator.db.TableSchema;
import com.ichings.generator.model.TagValue;

/**
 * TableSchema -> TagValue
 *
 * @author changebooks
 */
public interface TagService {
    /**
     * TableSchema -> TagValue
     *
     * @param tableSchema TableSchema
     * @return TagValue
     */
    TagValue getValue(TableSchema tableSchema);

    /**
     * Persistent Object
     *
     * @param tagValue    TagValue
     * @param tableSchema TableSchema
     */
    void setPersistentObject(TagValue tagValue, TableSchema tableSchema);

    /**
     * Persistent Object Mapper
     *
     * @param tagValue    TagValue
     * @param tableSchema TableSchema
     */
    void setPersistentObjectMapper(TagValue tagValue, TableSchema tableSchema);

    /**
     * Persistent Object Criteria
     *
     * @param tagValue    TagValue
     * @param tableSchema TableSchema
     */
    void setPersistentObjectCriteria(TagValue tagValue, TableSchema tableSchema);

    /**
     * Data Transfer Object
     *
     * @param tagValue    TagValue
     * @param tableSchema TableSchema
     */
    void setDataTransferObject(TagValue tagValue, TableSchema tableSchema);

    /**
     * Data Transfer Object Mapper
     *
     * @param tagValue    TagValue
     * @param tableSchema TableSchema
     */
    void setDataTransferObjectMapper(TagValue tagValue, TableSchema tableSchema);

    /**
     * View Object
     *
     * @param tagValue    TagValue
     * @param tableSchema TableSchema
     */
    void setViewObject(TagValue tagValue, TableSchema tableSchema);

    /**
     * View Object Mapper
     *
     * @param tagValue    TagValue
     * @param tableSchema TableSchema
     */
    void setViewObjectMapper(TagValue tagValue, TableSchema tableSchema);

    /**
     * View Object Create Request
     *
     * @param tagValue    TagValue
     * @param tableSchema TableSchema
     */
    void setViewObjectCreateRequest(TagValue tagValue, TableSchema tableSchema);

    /**
     * View Object Update Request
     *
     * @param tagValue    TagValue
     * @param tableSchema TableSchema
     */
    void setViewObjectUpdateRequest(TagValue tagValue, TableSchema tableSchema);

    /**
     * View Object Criteria Request
     *
     * @param tagValue    TagValue
     * @param tableSchema TableSchema
     */
    void setViewObjectCriteriaRequest(TagValue tagValue, TableSchema tableSchema);

    /**
     * Mybatis Object
     *
     * @param tagValue    TagValue
     * @param tableSchema TableSchema
     */
    void setMybatisObject(TagValue tagValue, TableSchema tableSchema);

    /**
     * Mybatis Resource
     *
     * @param tagValue    TagValue
     * @param tableSchema TableSchema
     */
    void setMybatisResource(TagValue tagValue, TableSchema tableSchema);

    /**
     * Database Interface
     *
     * @param tagValue    TagValue
     * @param tableSchema TableSchema
     */
    void setDatabaseInterface(TagValue tagValue, TableSchema tableSchema);

    /**
     * Database Implements
     *
     * @param tagValue    TagValue
     * @param tableSchema TableSchema
     */
    void setDatabaseImpl(TagValue tagValue, TableSchema tableSchema);

    /**
     * Repository Interface
     *
     * @param tagValue    TagValue
     * @param tableSchema TableSchema
     */
    void setRepositoryInterface(TagValue tagValue, TableSchema tableSchema);

    /**
     * Repository Implements
     *
     * @param tagValue    TagValue
     * @param tableSchema TableSchema
     */
    void setRepositoryImpl(TagValue tagValue, TableSchema tableSchema);

    /**
     * Service Interface
     *
     * @param tagValue    TagValue
     * @param tableSchema TableSchema
     */
    void setServiceInterface(TagValue tagValue, TableSchema tableSchema);

    /**
     * Service Implements
     *
     * @param tagValue    TagValue
     * @param tableSchema TableSchema
     */
    void setServiceImpl(TagValue tagValue, TableSchema tableSchema);

    /**
     * Controller
     *
     * @param tagValue    TagValue
     * @param tableSchema TableSchema
     */
    void setController(TagValue tagValue, TableSchema tableSchema);

}
