package com.ichings.generator.db;

import com.ichings.generator.base.Assert;
import com.ichings.generator.base.AssertUtils;
import com.ichings.generator.base.Check;
import com.ichings.generator.base.JsonParser;
import com.ichings.generator.base.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 表的概要描述
 * 包含表名、备注、主键名、自增字段名、字段名、列默认值等
 *
 * @author changebooks
 */
public final class TableSchema implements Serializable {
    /**
     * 表名
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 主键列
     */
    private ColumnSchema primaryKey;

    /**
     * 唯一索引列
     */
    private ColumnSchema uniqueKey;

    /**
     * 字段名列表
     */
    private List<String> columnNames = new ArrayList<>();

    /**
     * 列默认值
     */
    private Map<String, String> attributeDefaults = new HashMap<>();

    /**
     * 列的概要描述
     */
    private Map<String, ColumnSchema> columnMap = new HashMap<>();

    /**
     * 列的概要描述
     */
    private List<ColumnSchema> columnList = new ArrayList<>();

    /**
     * 类名，驼峰，首字母大写
     */
    private String className;

    /**
     * 方法名后缀，驼峰，首字母大写
     */
    private String methodName;

    /**
     * 属性名，驼峰，首字母小写
     */
    private String fieldName;

    /**
     * 列名存在？
     */
    public boolean hasColumn(String name) {
        if (Check.isEmpty(name)) {
            return false;
        }

        return columnMap.containsKey(name);
    }

    @Override
    public String toString() {
        return JsonParser.toJson(this);
    }

    public String getName() {
        return name;
    }

    public String getRemark() {
        return remark;
    }

    public ColumnSchema getPrimaryKey() {
        return primaryKey;
    }

    public ColumnSchema getUniqueKey() {
        return uniqueKey;
    }

    public List<String> getColumnNames() {
        return columnNames;
    }

    public Map<String, String> getAttributeDefaults() {
        return attributeDefaults;
    }

    public Map<String, ColumnSchema> getColumnMap() {
        return columnMap;
    }

    public List<ColumnSchema> getColumnList() {
        return columnList;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getFieldName() {
        return fieldName;
    }

    /**
     * Build a new {@link TableSchema}.
     */
    public static final class Builder {
        /**
         * 只支持一个主键
         */
        public static String PRIMARY_KEY_LIMIT = "%s can only be 1 primary key";

        /**
         * 表名
         */
        private String name;

        /**
         * 备注
         */
        private String remark;

        /**
         * 列的概要描述
         */
        private List<ColumnSchema> columns;

        /**
         * 创建TableSchema对象
         *
         * @return a TableSchema Object
         */
        public TableSchema create() {
            AssertUtils.nonEmpty(name, "name");

            TableSchema schema = new TableSchema();

            schema.name = name;
            schema.remark = remark;

            schema.className = StringUtils.underscoreToCamel(schema.getName(), true);
            schema.methodName = StringUtils.underscoreToCamel(schema.getName(), true);
            schema.fieldName = StringUtils.underscoreToCamel(schema.getName(), false);

            if (Check.isEmpty(columns)) {
                return schema;
            }

            for (ColumnSchema c : columns) {
                if (c == null) {
                    continue;
                }

                if (c.isPrimaryKey()) {
                    Assert.checkArgument(Check.isNull(schema.primaryKey), String.format(PRIMARY_KEY_LIMIT, schema.getName()));
                    schema.primaryKey = c;
                }

                if (c.isUniqueKey()) {
                    if (Check.isNull(schema.uniqueKey)) {
                        schema.uniqueKey = c;
                    }
                }

                String columnName = c.getName();
                String defaultValue = c.getDefaultValue();

                schema.columnNames.add(columnName);

                if (Check.nonEmpty(defaultValue)) {
                    schema.attributeDefaults.put(columnName, defaultValue);
                }

                schema.columnMap.put(columnName, c);
                schema.columnList.add(c);
            }

            return schema;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setRemark(String remark) {
            this.remark = remark;
            return this;
        }

        public Builder setColumns(List<ColumnSchema> columns) {
            this.columns = columns;
            return this;
        }

    }

}
