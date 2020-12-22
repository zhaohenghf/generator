package com.ichings.generator.db;

import com.ichings.generator.base.AssertUtils;
import com.ichings.generator.base.JsonParser;
import com.ichings.generator.base.StringUtils;

import java.io.Serializable;

/**
 * 列的概要描述
 * 包含列名、类型、长度、精度、默认值等
 *
 * @author changebooks
 */
public final class ColumnSchema implements Serializable {
    /**
     * 列名
     */
    private String name;

    /**
     * 类型，java.sql.Types
     */
    private int type;

    /**
     * 类型名
     */
    private String typeName;

    /**
     * 长度
     */
    private int size;

    /**
     * 精度
     */
    private int scale;

    /**
     * 默认值
     */
    private String defaultValue;

    /**
     * 主键？
     */
    private boolean primaryKey;

    /**
     * 唯一索引？
     */
    private boolean uniqueKey;

    /**
     * 允许空？
     */
    private boolean allowNull;

    /**
     * 自增？
     */
    private boolean autoIncrement;

    /**
     * 备注
     */
    private String remark;

    /**
     * Jdbc类型名
     */
    private String jdbcName;

    /**
     * Java基础类型名
     */
    private String javaBasic;

    /**
     * Java包装类名
     */
    private String javaSimpleWrapper;

    /**
     * Java包装类全名（包括包名）
     */
    private String javaWrapper;

    /**
     * 用Java包装类，需要引包？
     */
    private boolean useImport;

    /**
     * null时默认值
     */
    private String defaultNullValue;

    /**
     * Getter/Setter方法名后缀，驼峰，首字母大写
     */
    private String methodName;

    /**
     * 属性名，驼峰，首字母小写
     */
    private String fieldName;

    @Override
    public String toString() {
        return JsonParser.toJson(this);
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getSize() {
        return size;
    }

    public int getScale() {
        return scale;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public boolean isUniqueKey() {
        return uniqueKey;
    }

    public boolean isAllowNull() {
        return allowNull;
    }

    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    public String getRemark() {
        return remark;
    }

    public String getJdbcName() {
        return jdbcName;
    }

    public String getJavaBasic() {
        return javaBasic;
    }

    public String getJavaSimpleWrapper() {
        return javaSimpleWrapper;
    }

    public String getJavaWrapper() {
        return javaWrapper;
    }

    public boolean isUseImport() {
        return useImport;
    }

    public String getDefaultNullValue() {
        return defaultNullValue;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getFieldName() {
        return fieldName;
    }

    /**
     * Build a new {@link ColumnSchema}.
     */
    public static final class Builder {
        /**
         * 列名
         */
        private String name;

        /**
         * 类型，java.sql.Types
         */
        private int type;

        /**
         * 类型名
         */
        private String typeName;

        /**
         * 长度
         */
        private int size;

        /**
         * 精度
         */
        private int scale;

        /**
         * 默认值
         */
        private String defaultValue;

        /**
         * 主键？
         */
        private boolean primaryKey;

        /**
         * 唯一索引？
         */
        private boolean uniqueKey;

        /**
         * 允许空？
         */
        private boolean allowNull;

        /**
         * 自增？
         */
        private boolean autoIncrement;

        /**
         * 备注
         */
        private String remark;

        /**
         * 创建ColumnSchema对象
         *
         * @return a ColumnSchema Object
         */
        public ColumnSchema create() {
            AssertUtils.nonEmpty(name, "name");

            TypeEnum typeEnum = TypeUtils.getEnum(type);
            AssertUtils.nonNull(typeEnum, "typeEnum");

            ColumnSchema schema = new ColumnSchema();

            schema.name = name;
            schema.type = type;
            schema.typeName = typeName;
            schema.size = size;
            schema.scale = scale;
            schema.defaultValue = defaultValue;
            schema.primaryKey = primaryKey;
            schema.uniqueKey = uniqueKey;
            schema.allowNull = allowNull;
            schema.autoIncrement = autoIncrement;
            schema.remark = remark;

            schema.jdbcName = typeEnum.getJdbcName();
            schema.javaBasic = typeEnum.getJavaBasic();
            schema.javaSimpleWrapper = typeEnum.getJavaSimpleWrapper();
            schema.javaWrapper = typeEnum.getJavaWrapper();
            schema.useImport = typeEnum.isUseImport();
            schema.defaultNullValue = typeEnum.getNullValue();

            schema.methodName = StringUtils.underscoreToCamel(schema.getName(), true);
            schema.fieldName = StringUtils.underscoreToCamel(schema.getName(), false);

            return schema;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setType(int type) {
            this.type = type;
            return this;
        }

        public Builder setTypeName(String typeName) {
            this.typeName = typeName;
            return this;
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setScale(int scale) {
            this.scale = scale;
            return this;
        }

        public Builder setDefaultValue(String defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        public Builder setPrimaryKey(boolean primaryKey) {
            this.primaryKey = primaryKey;
            return this;
        }

        public Builder setUniqueKey(boolean uniqueKey) {
            this.uniqueKey = uniqueKey;
            return this;
        }

        public Builder setAllowNull(boolean allowNull) {
            this.allowNull = allowNull;
            return this;
        }

        public Builder setAutoIncrement(boolean autoIncrement) {
            this.autoIncrement = autoIncrement;
            return this;
        }

        public Builder setRemark(String remark) {
            this.remark = remark;
            return this;
        }

    }

}
