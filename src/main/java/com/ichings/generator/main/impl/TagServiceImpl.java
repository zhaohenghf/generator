package com.ichings.generator.main.impl;

import com.ichings.generator.autoconfigure.SuffixProperties;
import com.ichings.generator.base.AssertUtils;
import com.ichings.generator.base.Check;
import com.ichings.generator.base.Constant;
import com.ichings.generator.base.StringUtils;
import com.ichings.generator.db.ColumnSchema;
import com.ichings.generator.db.TableSchema;
import com.ichings.generator.main.TagService;
import com.ichings.generator.model.TagValue;
import com.ichings.generator.schema.PackageSchema;
import com.ichings.generator.util.IgnoreUtils;
import com.ichings.generator.util.TagUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author changebooks
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private SuffixProperties suffixProperties;

    @Autowired
    private PackageSchema packageSchema;

    @Override
    public TagValue getValue(TableSchema tableSchema) {
        AssertUtils.nonNull(tableSchema, "tableSchema");

        TagValue result = new TagValue();

        setPersistentObject(result, tableSchema);
        setPersistentObjectMapper(result, tableSchema);
        setPersistentObjectCriteria(result, tableSchema);
        setDataTransferObject(result, tableSchema);
        setDataTransferObjectMapper(result, tableSchema);
        setViewObject(result, tableSchema);
        setViewObjectMapper(result, tableSchema);
        setViewObjectCreateRequest(result, tableSchema);
        setViewObjectUpdateRequest(result, tableSchema);
        setViewObjectCriteriaRequest(result, tableSchema);
        setMybatisObject(result, tableSchema);
        setMybatisResource(result, tableSchema);
        setDatabaseInterface(result, tableSchema);
        setDatabaseImpl(result, tableSchema);
        setRepositoryInterface(result, tableSchema);
        setRepositoryImpl(result, tableSchema);
        setServiceInterface(result, tableSchema);
        setServiceImpl(result, tableSchema);
        setController(result, tableSchema);

        return result;
    }

    @Override
    public void setPersistentObject(TagValue tagValue, TableSchema tableSchema) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonNull(tableSchema, "tableSchema");

        String classTitle = tableSchema.getRemark();
        String packageName = packageSchema.getPersistentObject();
        String className = tableSchema.getClassName() + suffixProperties.getPersistentObject();
        String packageClass = packageName + Constant.PACKAGE_SEPARATOR + className;
        String importList = TagUtils.buildImportList(tableSchema.getColumnList(), null);
        String fieldList = TagUtils.buildFieldList(tableSchema.getColumnList(), null, false);
        String methodList = TagUtils.buildMethodList(tableSchema.getColumnList(), null);
        String idTitle = null;
        String uniqueTitle = null;
        String uniqueNameLower = null;
        String uniqueNameUpper = null;
        String uniqueNameLowerCamel = null;
        String uniqueNameUpperCamel = null;

        ColumnSchema primaryKey = tableSchema.getPrimaryKey();
        if (Check.nonNull(primaryKey)) {
            idTitle = primaryKey.getRemark();
        }

        ColumnSchema uniqueKey = tableSchema.getUniqueKey();
        if (Check.nonNull(uniqueKey)) {
            uniqueTitle = uniqueKey.getRemark();
            String uniqueName = uniqueKey.getName();
            if (Check.nonEmpty(uniqueName)) {
                uniqueNameLower = uniqueName.toLowerCase();
                uniqueNameUpper = uniqueName.toUpperCase();
                uniqueNameLowerCamel = StringUtils.underscoreToCamel(uniqueName, false);
                uniqueNameUpperCamel = StringUtils.underscoreToCamel(uniqueName, true);
            }
        }

        tagValue.setPersistentObjectClassTitle(Check.nonEmpty(classTitle) ? classTitle : "");
        tagValue.setPersistentObjectPackageName(Check.nonEmpty(packageName) ? packageName : "");
        tagValue.setPersistentObjectClassName(Check.nonEmpty(className) ? className : "");
        tagValue.setPersistentObjectPackageClass(Check.nonEmpty(packageClass) ? packageClass : "");
        tagValue.setPersistentObjectImportList(Check.nonEmpty(importList) ? importList : "");
        tagValue.setPersistentObjectFieldList(Check.nonEmpty(fieldList) ? fieldList : "");
        tagValue.setPersistentObjectMethodList(Check.nonEmpty(methodList) ? methodList : "");
        tagValue.setPersistentObjectIdTitle(Check.nonEmpty(idTitle) ? idTitle : "");
        tagValue.setPersistentObjectUniqueTitle(Check.nonEmpty(uniqueTitle) ? uniqueTitle : "");
        tagValue.setPersistentObjectUniqueNameLower(Check.nonEmpty(uniqueNameLower) ? uniqueNameLower : "");
        tagValue.setPersistentObjectUniqueNameUpper(Check.nonEmpty(uniqueNameUpper) ? uniqueNameUpper : "");
        tagValue.setPersistentObjectUniqueNameLowerCamel(Check.nonEmpty(uniqueNameLowerCamel) ? uniqueNameLowerCamel : "");
        tagValue.setPersistentObjectUniqueNameUpperCamel(Check.nonEmpty(uniqueNameUpperCamel) ? uniqueNameUpperCamel : "");
    }

    @Override
    public void setPersistentObjectMapper(TagValue tagValue, TableSchema tableSchema) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonNull(tableSchema, "tableSchema");

        String packageName = packageSchema.getPersistentObjectMapper();
        String interfaceName = tableSchema.getClassName() + suffixProperties.getPersistentObjectMapper();
        String packageInterface = packageName + Constant.PACKAGE_SEPARATOR + interfaceName;

        tagValue.setPersistentObjectMapperPackageName(Check.nonEmpty(packageName) ? packageName : "");
        tagValue.setPersistentObjectMapperInterfaceName(Check.nonEmpty(interfaceName) ? interfaceName : "");
        tagValue.setPersistentObjectMapperPackageInterface(Check.nonEmpty(packageInterface) ? packageInterface : "");
    }

    @Override
    public void setPersistentObjectCriteria(TagValue tagValue, TableSchema tableSchema) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonNull(tableSchema, "tableSchema");

        String packageName = packageSchema.getPersistentObjectCriteria();
        String className = tableSchema.getClassName() + suffixProperties.getPersistentObjectCriteria();
        String packageClass = packageName + Constant.PACKAGE_SEPARATOR + className;

        tagValue.setPersistentObjectCriteriaPackageName(Check.nonEmpty(packageName) ? packageName : "");
        tagValue.setPersistentObjectCriteriaClassName(Check.nonEmpty(className) ? className : "");
        tagValue.setPersistentObjectCriteriaPackageClass(Check.nonEmpty(packageClass) ? packageClass : "");
    }

    @Override
    public void setDataTransferObject(TagValue tagValue, TableSchema tableSchema) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonNull(tableSchema, "tableSchema");

        String packageName = packageSchema.getDataTransferObject();
        String className = tableSchema.getClassName() + suffixProperties.getDataTransferObject();
        String packageClass = packageName + Constant.PACKAGE_SEPARATOR + className;

        String importList = TagUtils.buildImportList(tableSchema.getColumnList(), IgnoreUtils.DATA_TRANSFER_OBJECT);
        String fieldList = TagUtils.buildFieldList(tableSchema.getColumnList(), IgnoreUtils.DATA_TRANSFER_OBJECT, false);
        String methodList = TagUtils.buildMethodList(tableSchema.getColumnList(), IgnoreUtils.DATA_TRANSFER_OBJECT);

        tagValue.setDataTransferObjectPackageName(Check.nonEmpty(packageName) ? packageName : "");
        tagValue.setDataTransferObjectClassName(Check.nonEmpty(className) ? className : "");
        tagValue.setDataTransferObjectPackageClass(Check.nonEmpty(packageClass) ? packageClass : "");

        tagValue.setDataTransferObjectImportList(Check.nonEmpty(importList) ? importList : "");
        tagValue.setDataTransferObjectFieldList(Check.nonEmpty(fieldList) ? fieldList : "");
        tagValue.setDataTransferObjectMethodList(Check.nonEmpty(methodList) ? methodList : "");
    }

    @Override
    public void setDataTransferObjectMapper(TagValue tagValue, TableSchema tableSchema) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonNull(tableSchema, "tableSchema");

        String packageName = packageSchema.getDataTransferObjectMapper();
        String interfaceName = tableSchema.getClassName() + suffixProperties.getDataTransferObjectMapper();
        String packageInterface = packageName + Constant.PACKAGE_SEPARATOR + interfaceName;

        tagValue.setDataTransferObjectMapperPackageName(Check.nonEmpty(packageName) ? packageName : "");
        tagValue.setDataTransferObjectMapperInterfaceName(Check.nonEmpty(interfaceName) ? interfaceName : "");
        tagValue.setDataTransferObjectMapperPackageInterface(Check.nonEmpty(packageInterface) ? packageInterface : "");
    }

    @Override
    public void setViewObject(TagValue tagValue, TableSchema tableSchema) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonNull(tableSchema, "tableSchema");

        String packageName = packageSchema.getViewObject();
        String className = tableSchema.getClassName() + suffixProperties.getViewObject();
        String packageClass = packageName + Constant.PACKAGE_SEPARATOR + className;

        String importList = TagUtils.buildImportList(tableSchema.getColumnList(), IgnoreUtils.VIEW_OBJECT);
        String fieldList = TagUtils.buildFieldList(tableSchema.getColumnList(), IgnoreUtils.VIEW_OBJECT, false);
        String methodList = TagUtils.buildMethodList(tableSchema.getColumnList(), IgnoreUtils.VIEW_OBJECT);

        tagValue.setViewObjectPackageName(Check.nonEmpty(packageName) ? packageName : "");
        tagValue.setViewObjectClassName(Check.nonEmpty(className) ? className : "");
        tagValue.setViewObjectPackageClass(Check.nonEmpty(packageClass) ? packageClass : "");

        tagValue.setViewObjectImportList(Check.nonEmpty(importList) ? importList : "");
        tagValue.setViewObjectFieldList(Check.nonEmpty(fieldList) ? fieldList : "");
        tagValue.setViewObjectMethodList(Check.nonEmpty(methodList) ? methodList : "");
    }

    @Override
    public void setViewObjectMapper(TagValue tagValue, TableSchema tableSchema) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonNull(tableSchema, "tableSchema");

        String packageName = packageSchema.getViewObjectMapper();
        String interfaceName = tableSchema.getClassName() + suffixProperties.getViewObjectMapper();
        String packageInterface = packageName + Constant.PACKAGE_SEPARATOR + interfaceName;

        tagValue.setViewObjectMapperPackageName(Check.nonEmpty(packageName) ? packageName : "");
        tagValue.setViewObjectMapperInterfaceName(Check.nonEmpty(interfaceName) ? interfaceName : "");
        tagValue.setViewObjectMapperPackageInterface(Check.nonEmpty(packageInterface) ? packageInterface : "");
    }

    @Override
    public void setViewObjectCreateRequest(TagValue tagValue, TableSchema tableSchema) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonNull(tableSchema, "tableSchema");

        String packageName = packageSchema.getViewObjectCreateRequest();
        String className = tableSchema.getClassName() + suffixProperties.getViewObjectCreateRequest();
        String packageClass = packageName + Constant.PACKAGE_SEPARATOR + className;

        String importList = TagUtils.buildImportList(tableSchema.getColumnList(), IgnoreUtils.VIEW_OBJECT_CREATE_REQUEST);
        String fieldList = TagUtils.buildFieldList(tableSchema.getColumnList(), IgnoreUtils.VIEW_OBJECT_CREATE_REQUEST, true);
        String methodList = TagUtils.buildMethodList(tableSchema.getColumnList(), IgnoreUtils.VIEW_OBJECT_CREATE_REQUEST);

        tagValue.setViewObjectCreateRequestPackageName(Check.nonEmpty(packageName) ? packageName : "");
        tagValue.setViewObjectCreateRequestClassName(Check.nonEmpty(className) ? className : "");
        tagValue.setViewObjectCreateRequestPackageClass(Check.nonEmpty(packageClass) ? packageClass : "");

        tagValue.setViewObjectCreateRequestImportList(Check.nonEmpty(importList) ? importList : "");
        tagValue.setViewObjectCreateRequestFieldList(Check.nonEmpty(fieldList) ? fieldList : "");
        tagValue.setViewObjectCreateRequestMethodList(Check.nonEmpty(methodList) ? methodList : "");
    }

    @Override
    public void setViewObjectUpdateRequest(TagValue tagValue, TableSchema tableSchema) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonNull(tableSchema, "tableSchema");

        String packageName = packageSchema.getViewObjectUpdateRequest();
        String className = tableSchema.getClassName() + suffixProperties.getViewObjectUpdateRequest();
        String packageClass = packageName + Constant.PACKAGE_SEPARATOR + className;

        tagValue.setViewObjectUpdateRequestPackageName(Check.nonEmpty(packageName) ? packageName : "");
        tagValue.setViewObjectUpdateRequestClassName(Check.nonEmpty(className) ? className : "");
        tagValue.setViewObjectUpdateRequestPackageClass(Check.nonEmpty(packageClass) ? packageClass : "");
    }

    @Override
    public void setViewObjectCriteriaRequest(TagValue tagValue, TableSchema tableSchema) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonNull(tableSchema, "tableSchema");

        String packageName = packageSchema.getViewObjectCriteriaRequest();
        String className = tableSchema.getClassName() + suffixProperties.getViewObjectCriteriaRequest();
        String packageClass = packageName + Constant.PACKAGE_SEPARATOR + className;

        tagValue.setViewObjectCriteriaRequestPackageName(Check.nonEmpty(packageName) ? packageName : "");
        tagValue.setViewObjectCriteriaRequestClassName(Check.nonEmpty(className) ? className : "");
        tagValue.setViewObjectCriteriaRequestPackageClass(Check.nonEmpty(packageClass) ? packageClass : "");
    }

    @Override
    public void setMybatisObject(TagValue tagValue, TableSchema tableSchema) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonNull(tableSchema, "tableSchema");

        String packageName = packageSchema.getMybatisObject();
        String interfaceName = tableSchema.getClassName() + suffixProperties.getMybatisObject();
        String packageInterface = packageName + Constant.PACKAGE_SEPARATOR + interfaceName;

        tagValue.setMybatisObjectPackageName(Check.nonEmpty(packageName) ? packageName : "");
        tagValue.setMybatisObjectInterfaceName(Check.nonEmpty(interfaceName) ? interfaceName : "");
        tagValue.setMybatisObjectPackageInterface(Check.nonEmpty(packageInterface) ? packageInterface : "");
    }

    @Override
    public void setMybatisResource(TagValue tagValue, TableSchema tableSchema) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonNull(tableSchema, "tableSchema");

        String fileName = tableSchema.getClassName() + suffixProperties.getMybatisObject();
        String tableName = tableSchema.getName();
        String baseColumnList = TagUtils.buildBaseColumnList(tableSchema.getColumnNames());
        String baseResultMap = TagUtils.buildBaseResultMap(tableSchema.getColumnList());
        String insertListColumnList = TagUtils.buildInsertColumnList(tableSchema.getColumnList());
        String insertListValueList = TagUtils.buildInsertValueList(tableSchema.getColumnList(), true);
        String insertColumnList = TagUtils.buildInsertColumnList(tableSchema.getColumnList());
        String insertValueList = TagUtils.buildInsertValueList(tableSchema.getColumnList(), false);
        String updateListFieldList = TagUtils.buildUpdateFieldList(tableSchema.getColumnList(), true);
        String updateFieldList = TagUtils.buildUpdateFieldList(tableSchema.getColumnList(), false);

        tagValue.setMybatisResourceFileName(Check.nonEmpty(fileName) ? fileName : "");
        tagValue.setMybatisResourceTableName(Check.nonEmpty(tableName) ? tableName : "");
        tagValue.setMybatisResourceBaseColumnList(Check.nonEmpty(baseColumnList) ? baseColumnList : "");
        tagValue.setMybatisResourceBaseResultMap(Check.nonEmpty(baseResultMap) ? baseResultMap : "");
        tagValue.setMybatisResourceInsertListColumnList(Check.nonEmpty(insertListColumnList) ? insertListColumnList : "");
        tagValue.setMybatisResourceInsertListValueList(Check.nonEmpty(insertListValueList) ? insertListValueList : "");
        tagValue.setMybatisResourceInsertColumnList(Check.nonEmpty(insertColumnList) ? insertColumnList : "");
        tagValue.setMybatisResourceInsertValueList(Check.nonEmpty(insertValueList) ? insertValueList : "");
        tagValue.setMybatisResourceUpdateListFieldList(Check.nonEmpty(updateListFieldList) ? updateListFieldList : "");
        tagValue.setMybatisResourceUpdateFieldList(Check.nonEmpty(updateFieldList) ? updateFieldList : "");
    }

    @Override
    public void setDatabaseInterface(TagValue tagValue, TableSchema tableSchema) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonNull(tableSchema, "tableSchema");

        String packageName = packageSchema.getDatabaseInterface();
        String interfaceName = tableSchema.getClassName() + suffixProperties.getDatabaseInterface();
        String packageInterface = packageName + Constant.PACKAGE_SEPARATOR + interfaceName;

        tagValue.setDatabasePackageName(Check.nonEmpty(packageName) ? packageName : "");
        tagValue.setDatabaseInterfaceName(Check.nonEmpty(interfaceName) ? interfaceName : "");
        tagValue.setDatabasePackageInterface(Check.nonEmpty(packageInterface) ? packageInterface : "");
    }

    @Override
    public void setDatabaseImpl(TagValue tagValue, TableSchema tableSchema) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonNull(tableSchema, "tableSchema");

        String packageName = packageSchema.getDatabaseImpl();
        String className = tableSchema.getClassName() + suffixProperties.getDatabaseImpl();
        String packageClass = packageName + Constant.PACKAGE_SEPARATOR + className;

        tagValue.setDatabaseImplPackageName(Check.nonEmpty(packageName) ? packageName : "");
        tagValue.setDatabaseImplClassName(Check.nonEmpty(className) ? className : "");
        tagValue.setDatabaseImplPackageClass(Check.nonEmpty(packageClass) ? packageClass : "");
    }

    @Override
    public void setRepositoryInterface(TagValue tagValue, TableSchema tableSchema) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonNull(tableSchema, "tableSchema");

        String packageName = packageSchema.getRepositoryInterface();
        String interfaceName = tableSchema.getClassName() + suffixProperties.getRepositoryInterface();
        String packageInterface = packageName + Constant.PACKAGE_SEPARATOR + interfaceName;

        tagValue.setRepositoryPackageName(Check.nonEmpty(packageName) ? packageName : "");
        tagValue.setRepositoryInterfaceName(Check.nonEmpty(interfaceName) ? interfaceName : "");
        tagValue.setRepositoryPackageInterface(Check.nonEmpty(packageInterface) ? packageInterface : "");
    }

    @Override
    public void setRepositoryImpl(TagValue tagValue, TableSchema tableSchema) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonNull(tableSchema, "tableSchema");

        String packageName = packageSchema.getRepositoryImpl();
        String className = tableSchema.getClassName() + suffixProperties.getRepositoryImpl();
        String packageClass = packageName + Constant.PACKAGE_SEPARATOR + className;

        tagValue.setRepositoryImplPackageName(Check.nonEmpty(packageName) ? packageName : "");
        tagValue.setRepositoryImplClassName(Check.nonEmpty(className) ? className : "");
        tagValue.setRepositoryImplPackageClass(Check.nonEmpty(packageClass) ? packageClass : "");
    }

    @Override
    public void setServiceInterface(TagValue tagValue, TableSchema tableSchema) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonNull(tableSchema, "tableSchema");

        String packageName = packageSchema.getServiceInterface();
        String interfaceName = tableSchema.getClassName() + suffixProperties.getServiceInterface();
        String packageInterface = packageName + Constant.PACKAGE_SEPARATOR + interfaceName;

        tagValue.setServicePackageName(Check.nonEmpty(packageName) ? packageName : "");
        tagValue.setServiceInterfaceName(Check.nonEmpty(interfaceName) ? interfaceName : "");
        tagValue.setServicePackageInterface(Check.nonEmpty(packageInterface) ? packageInterface : "");
    }

    @Override
    public void setServiceImpl(TagValue tagValue, TableSchema tableSchema) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonNull(tableSchema, "tableSchema");

        String packageName = packageSchema.getServiceImpl();
        String className = tableSchema.getClassName() + suffixProperties.getServiceImpl();
        String packageClass = packageName + Constant.PACKAGE_SEPARATOR + className;

        tagValue.setServiceImplPackageName(Check.nonEmpty(packageName) ? packageName : "");
        tagValue.setServiceImplClassName(Check.nonEmpty(className) ? className : "");
        tagValue.setServiceImplPackageClass(Check.nonEmpty(packageClass) ? packageClass : "");
    }

    @Override
    public void setController(TagValue tagValue, TableSchema tableSchema) {
        AssertUtils.nonNull(tagValue, "tagValue");
        AssertUtils.nonNull(tableSchema, "tableSchema");

        String packageName = packageSchema.getController();
        String className = tableSchema.getClassName() + suffixProperties.getController();
        String packageClass = packageName + Constant.PACKAGE_SEPARATOR + className;

        tagValue.setControllerPackageName(Check.nonEmpty(packageName) ? packageName : "");
        tagValue.setControllerClassName(Check.nonEmpty(className) ? className : "");
        tagValue.setControllerPackageClass(Check.nonEmpty(packageClass) ? packageClass : "");
    }

}
