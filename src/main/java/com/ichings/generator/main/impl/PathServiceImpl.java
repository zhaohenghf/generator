package com.ichings.generator.main.impl;

import com.ichings.generator.base.AssertUtils;
import com.ichings.generator.base.Constant;
import com.ichings.generator.base.FileUtils;
import com.ichings.generator.main.PathService;
import com.ichings.generator.model.AbsolutePath;
import com.ichings.generator.model.TagValue;
import com.ichings.generator.schema.DirectorySchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author changebooks
 */
@Service
public class PathServiceImpl implements PathService {

    @Autowired
    private DirectorySchema directorySchema;

    @Override
    public AbsolutePath getAbsolutePath(TagValue tagValue) {
        AssertUtils.nonNull(tagValue, "tagValue");

        AbsolutePath result = new AbsolutePath();

        result.setPersistentObject(joinClass(directorySchema.getPersistentObject(), tagValue.getPersistentObjectClassName()));
        result.setPersistentObjectMapper(joinClass(directorySchema.getPersistentObjectMapper(), tagValue.getPersistentObjectMapperInterfaceName()));
        result.setPersistentObjectCriteria(joinClass(directorySchema.getPersistentObjectCriteria(), tagValue.getPersistentObjectCriteriaClassName()));
        result.setMybatisObject(joinClass(directorySchema.getMybatisObject(), tagValue.getMybatisObjectInterfaceName()));
        result.setMybatisResource(joinResource(directorySchema.getMybatisResource(), tagValue.getMybatisResourceFileName()));
        result.setDatabaseInterface(joinClass(directorySchema.getDatabaseInterface(), tagValue.getDatabaseInterfaceName()));
        result.setDatabaseImpl(joinClass(directorySchema.getDatabaseImpl(), tagValue.getDatabaseImplClassName()));
        result.setRepositoryInterface(joinClass(directorySchema.getRepositoryInterface(), tagValue.getRepositoryInterfaceName()));
        result.setRepositoryImpl(joinClass(directorySchema.getRepositoryImpl(), tagValue.getRepositoryImplClassName()));
        result.setDataTransferObject(joinClass(directorySchema.getDataTransferObject(), tagValue.getDataTransferObjectClassName()));
        result.setDataTransferObjectMapper(joinClass(directorySchema.getDataTransferObjectMapper(), tagValue.getDataTransferObjectMapperInterfaceName()));
        result.setServiceInterface(joinClass(directorySchema.getServiceInterface(), tagValue.getServiceInterfaceName()));
        result.setServiceImpl(joinClass(directorySchema.getServiceImpl(), tagValue.getServiceImplClassName()));
        result.setViewObject(joinClass(directorySchema.getViewObject(), tagValue.getViewObjectClassName()));
        result.setViewObjectMapper(joinClass(directorySchema.getViewObjectMapper(), tagValue.getViewObjectMapperInterfaceName()));
        result.setViewObjectCreateRequest(joinClass(directorySchema.getViewObjectCreateRequest(), tagValue.getViewObjectCreateRequestClassName()));
        result.setViewObjectUpdateRequest(joinClass(directorySchema.getViewObjectUpdateRequest(), tagValue.getViewObjectUpdateRequestClassName()));
        result.setViewObjectCriteriaRequest(joinClass(directorySchema.getViewObjectCriteriaRequest(), tagValue.getViewObjectCriteriaRequestClassName()));
        result.setController(joinClass(directorySchema.getController(), tagValue.getControllerClassName()));

        return result;
    }

    @Override
    public String joinClass(String directory, String className) {
        AssertUtils.nonEmpty(directory, "directory");
        AssertUtils.nonEmpty(className, "className");

        return directory + FileUtils.SEPARATOR + className + Constant.CLASS_SUFFIX;
    }

    @Override
    public String joinResource(String directory, String resourceName) {
        AssertUtils.nonEmpty(directory, "directory");
        AssertUtils.nonEmpty(resourceName, "resourceName");

        return directory + FileUtils.SEPARATOR + resourceName + Constant.RESOURCE_SUFFIX;
    }

}
