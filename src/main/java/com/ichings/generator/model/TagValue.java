package com.ichings.generator.model;

import com.ichings.generator.base.JsonParser;
import lombok.Data;

import java.io.Serializable;

/**
 * 标签值（替换模板标签，如：##***##）
 *
 * @author changebooks
 */
@Data
public final class TagValue implements Serializable {
    /**
     * ##persistent_object_class_title##
     */
    private String persistentObjectClassTitle;

    /**
     * ##persistent_object_package_name##
     */
    private String persistentObjectPackageName;

    /**
     * ##persistent_object_class_name##
     */
    private String persistentObjectClassName;

    /**
     * ##persistent_object_package_class##
     */
    private String persistentObjectPackageClass;

    /**
     * ##persistent_object_import_list##
     */
    private String persistentObjectImportList;

    /**
     * ##persistent_object_field_list##
     */
    private String persistentObjectFieldList;

    /**
     * ##persistent_object_method_list##
     */
    private String persistentObjectMethodList;

    /**
     * ##persistent_object_criteria_package_name##
     */
    private String persistentObjectCriteriaPackageName;

    /**
     * ##persistent_object_criteria_class_name##
     */
    private String persistentObjectCriteriaClassName;

    /**
     * ##persistent_object_criteria_package_class##
     */
    private String persistentObjectCriteriaPackageClass;

    /**
     * ##persistent_object_id_title##
     */
    private String persistentObjectIdTitle;

    /**
     * ##persistent_object_unique_title##
     */
    private String persistentObjectUniqueTitle;

    /**
     * ##persistent_object_unique_name_lower##
     */
    private String persistentObjectUniqueNameLower;

    /**
     * ##persistent_object_unique_name_upper##
     */
    private String persistentObjectUniqueNameUpper;

    /**
     * ##persistent_object_unique_name_lower_camel##
     */
    private String persistentObjectUniqueNameLowerCamel;

    /**
     * ##persistent_object_unique_name_upper_camel##
     */
    private String persistentObjectUniqueNameUpperCamel;

    /**
     * ##persistent_object_mapper_package_name##
     */
    private String persistentObjectMapperPackageName;

    /**
     * ##persistent_object_mapper_interface_name##
     */
    private String persistentObjectMapperInterfaceName;

    /**
     * ##persistent_object_mapper_package_interface##
     */
    private String persistentObjectMapperPackageInterface;

    /**
     * ##data_transfer_object_package_name##
     */
    private String dataTransferObjectPackageName;

    /**
     * ##data_transfer_object_class_name##
     */
    private String dataTransferObjectClassName;

    /**
     * ##data_transfer_object_package_class##
     */
    private String dataTransferObjectPackageClass;

    /**
     * ##data_transfer_object_import_list##
     */
    private String dataTransferObjectImportList;

    /**
     * ##data_transfer_object_field_list##
     */
    private String dataTransferObjectFieldList;

    /**
     * ##data_transfer_object_method_list##
     */
    private String dataTransferObjectMethodList;

    /**
     * ##data_transfer_object_mapper_package_name##
     */
    private String dataTransferObjectMapperPackageName;

    /**
     * ##data_transfer_object_mapper_interface_name##
     */
    private String dataTransferObjectMapperInterfaceName;

    /**
     * ##data_transfer_object_mapper_package_interface##
     */
    private String dataTransferObjectMapperPackageInterface;

    /**
     * ##view_object_create_request_package_name##
     */
    private String viewObjectCreateRequestPackageName;

    /**
     * ##view_object_create_request_class_name##
     */
    private String viewObjectCreateRequestClassName;

    /**
     * ##view_object_create_request_package_class##
     */
    private String viewObjectCreateRequestPackageClass;

    /**
     * ##view_object_create_request_import_list##
     */
    private String viewObjectCreateRequestImportList;

    /**
     * ##view_object_create_request_field_list##
     */
    private String viewObjectCreateRequestFieldList;

    /**
     * ##view_object_create_request_method_list##
     */
    private String viewObjectCreateRequestMethodList;

    /**
     * ##view_object_update_request_package_name##
     */
    private String viewObjectUpdateRequestPackageName;

    /**
     * ##view_object_update_request_class_name##
     */
    private String viewObjectUpdateRequestClassName;

    /**
     * ##view_object_update_request_package_class##
     */
    private String viewObjectUpdateRequestPackageClass;

    /**
     * ##view_object_criteria_request_package_name##
     */
    private String viewObjectCriteriaRequestPackageName;

    /**
     * ##view_object_criteria_request_class_name##
     */
    private String viewObjectCriteriaRequestClassName;

    /**
     * ##view_object_criteria_request_package_class##
     */
    private String viewObjectCriteriaRequestPackageClass;

    /**
     * ##view_object_package_name##
     */
    private String viewObjectPackageName;

    /**
     * ##view_object_class_name##
     */
    private String viewObjectClassName;

    /**
     * ##view_object_package_class##
     */
    private String viewObjectPackageClass;

    /**
     * ##view_object_import_list##
     */
    private String viewObjectImportList;

    /**
     * ##view_object_field_list##
     */
    private String viewObjectFieldList;

    /**
     * ##view_object_method_list##
     */
    private String viewObjectMethodList;

    /**
     * ##view_object_mapper_package_name##
     */
    private String viewObjectMapperPackageName;

    /**
     * ##view_object_mapper_interface_name##
     */
    private String viewObjectMapperInterfaceName;

    /**
     * ##view_object_mapper_package_interface##
     */
    private String viewObjectMapperPackageInterface;

    /**
     * ##mybatis_object_package_name##
     */
    private String mybatisObjectPackageName;

    /**
     * ##mybatis_object_interface_name##
     */
    private String mybatisObjectInterfaceName;

    /**
     * ##mybatis_object_package_interface##
     */
    private String mybatisObjectPackageInterface;

    /**
     * Mybatis Object Relational Mapping Resources 文件名
     */
    private String mybatisResourceFileName;

    /**
     * ##mybatis_resource_table_name##
     */
    private String mybatisResourceTableName;

    /**
     * ##mybatis_resource_base_column_list##
     */
    private String mybatisResourceBaseColumnList;

    /**
     * ##mybatis_resource_base_result_map##
     */
    private String mybatisResourceBaseResultMap;

    /**
     * ##mybatis_resource_insert_list_column_list##
     */
    private String mybatisResourceInsertListColumnList;

    /**
     * ##mybatis_resource_insert_list_value_list##
     */
    private String mybatisResourceInsertListValueList;

    /**
     * ##mybatis_resource_insert_column_list##
     */
    private String mybatisResourceInsertColumnList;

    /**
     * ##mybatis_resource_insert_value_list##
     */
    private String mybatisResourceInsertValueList;

    /**
     * ##mybatis_resource_update_list_field_list##
     */
    private String mybatisResourceUpdateListFieldList;

    /**
     * ##mybatis_resource_update_field_list##
     */
    private String mybatisResourceUpdateFieldList;

    /**
     * ##database_package_name##
     */
    private String databasePackageName;

    /**
     * ##database_interface_name##
     */
    private String databaseInterfaceName;

    /**
     * ##database_package_interface##
     */
    private String databasePackageInterface;

    /**
     * ##database_impl_package_name##
     */
    private String databaseImplPackageName;

    /**
     * ##database_impl_class_name##
     */
    private String databaseImplClassName;

    /**
     * ##database_impl_package_class##
     */
    private String databaseImplPackageClass;

    /**
     * ##repository_package_name##
     */
    private String repositoryPackageName;

    /**
     * ##repository_interface_name##
     */
    private String repositoryInterfaceName;

    /**
     * ##repository_package_interface##
     */
    private String repositoryPackageInterface;

    /**
     * ##repository_impl_package_name##
     */
    private String repositoryImplPackageName;

    /**
     * ##repository_impl_class_name##
     */
    private String repositoryImplClassName;

    /**
     * ##repository_impl_package_class##
     */
    private String repositoryImplPackageClass;

    /**
     * ##service_package_name##
     */
    private String servicePackageName;

    /**
     * ##service_interface_name##
     */
    private String serviceInterfaceName;

    /**
     * ##service_package_interface##
     */
    private String servicePackageInterface;

    /**
     * ##service_impl_package_name##
     */
    private String serviceImplPackageName;

    /**
     * ##service_impl_class_name##
     */
    private String serviceImplClassName;

    /**
     * ##service_impl_package_class##
     */
    private String serviceImplPackageClass;

    /**
     * ##controller_package_name##
     */
    private String controllerPackageName;

    /**
     * ##controller_class_name##
     */
    private String controllerClassName;

    /**
     * ##controller_package_class##
     */
    private String controllerPackageClass;

    @Override
    public String toString() {
        return JsonParser.toJson(this);
    }

}
