package com.ichings.generator.main.impl;

import com.ichings.generator.base.AssertUtils;
import com.ichings.generator.base.Placeholder;
import com.ichings.generator.main.TargetService;
import com.ichings.generator.model.TagValue;
import com.ichings.generator.model.TargetCode;
import com.ichings.generator.schema.TemplateSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author changebooks
 */
@Service
public class TargetServiceImpl implements TargetService {

    @Autowired
    private TemplateSchema templateSchema;

    @Override
    public TargetCode getTargetCode(TagValue tagValue) {
        AssertUtils.nonNull(tagValue, "tagValue");

        TargetCode result = new TargetCode();

        result.setPersistentObject(replaceAll(tagValue, templateSchema.getPersistentObject()));
        result.setPersistentObjectMapper(replaceAll(tagValue, templateSchema.getPersistentObjectMapper()));
        result.setPersistentObjectCriteria(replaceAll(tagValue, templateSchema.getPersistentObjectCriteria()));
        result.setMybatisObject(replaceAll(tagValue, templateSchema.getMybatisObject()));
        result.setMybatisResource(replaceAll(tagValue, templateSchema.getMybatisResource()));
        result.setDatabaseInterface(replaceAll(tagValue, templateSchema.getDatabaseInterface()));
        result.setDatabaseImpl(replaceAll(tagValue, templateSchema.getDatabaseImpl()));
        result.setRepositoryInterface(replaceAll(tagValue, templateSchema.getRepositoryInterface()));
        result.setRepositoryImpl(replaceAll(tagValue, templateSchema.getRepositoryImpl()));
        result.setDataTransferObject(replaceAll(tagValue, templateSchema.getDataTransferObject()));
        result.setDataTransferObjectMapper(replaceAll(tagValue, templateSchema.getDataTransferObjectMapper()));
        result.setServiceInterface(replaceAll(tagValue, templateSchema.getServiceInterface()));
        result.setServiceImpl(replaceAll(tagValue, templateSchema.getServiceImpl()));
        result.setViewObject(replaceAll(tagValue, templateSchema.getViewObject()));
        result.setViewObjectMapper(replaceAll(tagValue, templateSchema.getViewObjectMapper()));
        result.setViewObjectCreateRequest(replaceAll(tagValue, templateSchema.getViewObjectCreateRequest()));
        result.setViewObjectUpdateRequest(replaceAll(tagValue, templateSchema.getViewObjectUpdateRequest()));
        result.setViewObjectCriteriaRequest(replaceAll(tagValue, templateSchema.getViewObjectCriteriaRequest()));
        result.setController(replaceAll(tagValue, templateSchema.getController()));

        return result;
    }

    @Override
    public String replaceAll(TagValue tagValue, String template) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonEmpty(template, "template");

        template = replacePersistentObject(tagValue, template);
        template = replaceDataTransferObject(tagValue, template);
        template = replaceViewObject(tagValue, template);
        template = replaceMybatis(tagValue, template);
        template = replaceDatabase(tagValue, template);
        template = replaceRepository(tagValue, template);
        template = replaceService(tagValue, template);
        template = replaceController(tagValue, template);
        return template;
    }

    @Override
    public String replacePersistentObject(TagValue tagValue, String template) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonEmpty(template, "template");

        return template.replace(Placeholder.PERSISTENT_OBJECT_CLASS_TITLE, tagValue.getPersistentObjectClassTitle()).
                replace(Placeholder.PERSISTENT_OBJECT_PACKAGE_NAME, tagValue.getPersistentObjectPackageName()).
                replace(Placeholder.PERSISTENT_OBJECT_CLASS_NAME, tagValue.getPersistentObjectClassName()).
                replace(Placeholder.PERSISTENT_OBJECT_PACKAGE_CLASS, tagValue.getPersistentObjectPackageClass()).
                replace(Placeholder.PERSISTENT_OBJECT_IMPORT_LIST, tagValue.getPersistentObjectImportList()).
                replace(Placeholder.PERSISTENT_OBJECT_FIELD_LIST, tagValue.getPersistentObjectFieldList()).
                replace(Placeholder.PERSISTENT_OBJECT_METHOD_LIST, tagValue.getPersistentObjectMethodList()).
                replace(Placeholder.PERSISTENT_OBJECT_CRITERIA_PACKAGE_NAME, tagValue.getPersistentObjectCriteriaPackageName()).
                replace(Placeholder.PERSISTENT_OBJECT_CRITERIA_CLASS_NAME, tagValue.getPersistentObjectCriteriaClassName()).
                replace(Placeholder.PERSISTENT_OBJECT_CRITERIA_PACKAGE_CLASS, tagValue.getPersistentObjectCriteriaPackageClass()).
                replace(Placeholder.PERSISTENT_OBJECT_ID_TITLE, tagValue.getPersistentObjectIdTitle()).
                replace(Placeholder.PERSISTENT_OBJECT_UNIQUE_TITLE, tagValue.getPersistentObjectUniqueTitle()).
                replace(Placeholder.PERSISTENT_OBJECT_UNIQUE_NAME_LOWER, tagValue.getPersistentObjectUniqueNameLower()).
                replace(Placeholder.PERSISTENT_OBJECT_UNIQUE_NAME_UPPER, tagValue.getPersistentObjectUniqueNameUpper()).
                replace(Placeholder.PERSISTENT_OBJECT_UNIQUE_NAME_LOWER_CAMEL, tagValue.getPersistentObjectUniqueNameLowerCamel()).
                replace(Placeholder.PERSISTENT_OBJECT_UNIQUE_NAME_UPPER_CAMEL, tagValue.getPersistentObjectUniqueNameUpperCamel()).
                replace(Placeholder.PERSISTENT_OBJECT_MAPPER_PACKAGE_NAME, tagValue.getPersistentObjectMapperPackageName()).
                replace(Placeholder.PERSISTENT_OBJECT_MAPPER_INTERFACE_NAME, tagValue.getPersistentObjectMapperInterfaceName()).
                replace(Placeholder.PERSISTENT_OBJECT_MAPPER_PACKAGE_INTERFACE, tagValue.getPersistentObjectMapperPackageInterface());
    }

    @Override
    public String replaceDataTransferObject(TagValue tagValue, String template) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonEmpty(template, "template");

        return template.replace(Placeholder.DATA_TRANSFER_OBJECT_PACKAGE_NAME, tagValue.getDataTransferObjectPackageName()).
                replace(Placeholder.DATA_TRANSFER_OBJECT_CLASS_NAME, tagValue.getDataTransferObjectClassName()).
                replace(Placeholder.DATA_TRANSFER_OBJECT_PACKAGE_CLASS, tagValue.getDataTransferObjectPackageClass()).
                replace(Placeholder.DATA_TRANSFER_OBJECT_IMPORT_LIST, tagValue.getDataTransferObjectImportList()).
                replace(Placeholder.DATA_TRANSFER_OBJECT_FIELD_LIST, tagValue.getDataTransferObjectFieldList()).
                replace(Placeholder.DATA_TRANSFER_OBJECT_METHOD_LIST, tagValue.getDataTransferObjectMethodList()).
                replace(Placeholder.DATA_TRANSFER_OBJECT_MAPPER_PACKAGE_NAME, tagValue.getDataTransferObjectMapperPackageName()).
                replace(Placeholder.DATA_TRANSFER_OBJECT_MAPPER_INTERFACE_NAME, tagValue.getDataTransferObjectMapperInterfaceName()).
                replace(Placeholder.DATA_TRANSFER_OBJECT_MAPPER_PACKAGE_INTERFACE, tagValue.getDataTransferObjectMapperPackageInterface());
    }

    @Override
    public String replaceViewObject(TagValue tagValue, String template) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonEmpty(template, "template");

        return template.replace(Placeholder.VIEW_OBJECT_CREATE_REQUEST_PACKAGE_NAME, tagValue.getViewObjectCreateRequestPackageName()).
                replace(Placeholder.VIEW_OBJECT_CREATE_REQUEST_CLASS_NAME, tagValue.getViewObjectCreateRequestClassName()).
                replace(Placeholder.VIEW_OBJECT_CREATE_REQUEST_PACKAGE_CLASS, tagValue.getViewObjectCreateRequestPackageClass()).
                replace(Placeholder.VIEW_OBJECT_CREATE_REQUEST_IMPORT_LIST, tagValue.getViewObjectCreateRequestImportList()).
                replace(Placeholder.VIEW_OBJECT_CREATE_REQUEST_FIELD_LIST, tagValue.getViewObjectCreateRequestFieldList()).
                replace(Placeholder.VIEW_OBJECT_CREATE_REQUEST_METHOD_LIST, tagValue.getViewObjectCreateRequestMethodList()).
                replace(Placeholder.VIEW_OBJECT_UPDATE_REQUEST_PACKAGE_NAME, tagValue.getViewObjectUpdateRequestPackageName()).
                replace(Placeholder.VIEW_OBJECT_UPDATE_REQUEST_CLASS_NAME, tagValue.getViewObjectUpdateRequestClassName()).
                replace(Placeholder.VIEW_OBJECT_UPDATE_REQUEST_PACKAGE_CLASS, tagValue.getViewObjectUpdateRequestPackageClass()).
                replace(Placeholder.VIEW_OBJECT_CRITERIA_REQUEST_PACKAGE_NAME, tagValue.getViewObjectCriteriaRequestPackageName()).
                replace(Placeholder.VIEW_OBJECT_CRITERIA_REQUEST_CLASS_NAME, tagValue.getViewObjectCriteriaRequestClassName()).
                replace(Placeholder.VIEW_OBJECT_CRITERIA_REQUEST_PACKAGE_CLASS, tagValue.getViewObjectCriteriaRequestPackageClass()).
                replace(Placeholder.VIEW_OBJECT_PACKAGE_NAME, tagValue.getViewObjectPackageName()).
                replace(Placeholder.VIEW_OBJECT_CLASS_NAME, tagValue.getViewObjectClassName()).
                replace(Placeholder.VIEW_OBJECT_PACKAGE_CLASS, tagValue.getViewObjectPackageClass()).
                replace(Placeholder.VIEW_OBJECT_IMPORT_LIST, tagValue.getViewObjectImportList()).
                replace(Placeholder.VIEW_OBJECT_FIELD_LIST, tagValue.getViewObjectFieldList()).
                replace(Placeholder.VIEW_OBJECT_METHOD_LIST, tagValue.getViewObjectMethodList()).
                replace(Placeholder.VIEW_OBJECT_MAPPER_PACKAGE_NAME, tagValue.getViewObjectMapperPackageName()).
                replace(Placeholder.VIEW_OBJECT_MAPPER_INTERFACE_NAME, tagValue.getViewObjectMapperInterfaceName()).
                replace(Placeholder.VIEW_OBJECT_MAPPER_PACKAGE_INTERFACE, tagValue.getViewObjectMapperPackageInterface());
    }

    @Override
    public String replaceMybatis(TagValue tagValue, String template) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonEmpty(template, "template");

        return template.replace(Placeholder.MYBATIS_OBJECT_PACKAGE_NAME, tagValue.getMybatisObjectPackageName()).
                replace(Placeholder.MYBATIS_OBJECT_INTERFACE_NAME, tagValue.getMybatisObjectInterfaceName()).
                replace(Placeholder.MYBATIS_OBJECT_PACKAGE_INTERFACE, tagValue.getMybatisObjectPackageInterface()).
                replace(Placeholder.MYBATIS_RESOURCE_TABLE_NAME, tagValue.getMybatisResourceTableName()).
                replace(Placeholder.MYBATIS_RESOURCE_BASE_COLUMN_LIST, tagValue.getMybatisResourceBaseColumnList()).
                replace(Placeholder.MYBATIS_RESOURCE_BASE_RESULT_MAP, tagValue.getMybatisResourceBaseResultMap()).
                replace(Placeholder.MYBATIS_RESOURCE_INSERT_LIST_COLUMN_LIST, tagValue.getMybatisResourceInsertListColumnList()).
                replace(Placeholder.MYBATIS_RESOURCE_INSERT_LIST_VALUE_LIST, tagValue.getMybatisResourceInsertListValueList()).
                replace(Placeholder.MYBATIS_RESOURCE_INSERT_COLUMN_LIST, tagValue.getMybatisResourceInsertColumnList()).
                replace(Placeholder.MYBATIS_RESOURCE_INSERT_VALUE_LIST, tagValue.getMybatisResourceInsertValueList()).
                replace(Placeholder.MYBATIS_RESOURCE_UPDATE_LIST_FIELD_LIST, tagValue.getMybatisResourceUpdateListFieldList()).
                replace(Placeholder.MYBATIS_RESOURCE_UPDATE_FIELD_LIST, tagValue.getMybatisResourceUpdateFieldList());
    }

    @Override
    public String replaceDatabase(TagValue tagValue, String template) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonEmpty(template, "template");

        return template.replace(Placeholder.DATABASE_PACKAGE_NAME, tagValue.getDatabasePackageName()).
                replace(Placeholder.DATABASE_INTERFACE_NAME, tagValue.getDatabaseInterfaceName()).
                replace(Placeholder.DATABASE_PACKAGE_INTERFACE, tagValue.getDatabasePackageInterface()).
                replace(Placeholder.DATABASE_IMPL_PACKAGE_NAME, tagValue.getDatabaseImplPackageName()).
                replace(Placeholder.DATABASE_IMPL_CLASS_NAME, tagValue.getDatabaseImplClassName()).
                replace(Placeholder.DATABASE_IMPL_PACKAGE_CLASS, tagValue.getDatabaseImplPackageClass());
    }

    @Override
    public String replaceRepository(TagValue tagValue, String template) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonEmpty(template, "template");

        return template.replace(Placeholder.REPOSITORY_PACKAGE_NAME, tagValue.getRepositoryPackageName()).
                replace(Placeholder.REPOSITORY_INTERFACE_NAME, tagValue.getRepositoryInterfaceName()).
                replace(Placeholder.REPOSITORY_PACKAGE_INTERFACE, tagValue.getRepositoryPackageInterface()).
                replace(Placeholder.REPOSITORY_IMPL_PACKAGE_NAME, tagValue.getRepositoryImplPackageName()).
                replace(Placeholder.REPOSITORY_IMPL_CLASS_NAME, tagValue.getRepositoryImplClassName()).
                replace(Placeholder.REPOSITORY_IMPL_PACKAGE_CLASS, tagValue.getRepositoryImplPackageClass());
    }

    @Override
    public String replaceService(TagValue tagValue, String template) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonEmpty(template, "template");

        return template.replace(Placeholder.SERVICE_PACKAGE_NAME, tagValue.getServicePackageName()).
                replace(Placeholder.SERVICE_INTERFACE_NAME, tagValue.getServiceInterfaceName()).
                replace(Placeholder.SERVICE_PACKAGE_INTERFACE, tagValue.getServicePackageInterface()).
                replace(Placeholder.SERVICE_IMPL_PACKAGE_NAME, tagValue.getServiceImplPackageName()).
                replace(Placeholder.SERVICE_IMPL_CLASS_NAME, tagValue.getServiceImplClassName()).
                replace(Placeholder.SERVICE_IMPL_PACKAGE_CLASS, tagValue.getServiceImplPackageClass());
    }

    @Override
    public String replaceController(TagValue tagValue, String template) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonEmpty(template, "template");

        return template.replace(Placeholder.CONTROLLER_PACKAGE_NAME, tagValue.getControllerPackageName()).
                replace(Placeholder.CONTROLLER_CLASS_NAME, tagValue.getControllerClassName()).
                replace(Placeholder.CONTROLLER_PACKAGE_CLASS, tagValue.getControllerPackageClass());
    }

}
