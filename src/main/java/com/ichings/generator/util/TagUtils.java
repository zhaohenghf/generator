package com.ichings.generator.util;

import com.ichings.generator.base.AssertUtils;
import com.ichings.generator.base.Check;
import com.ichings.generator.base.Constant;
import com.ichings.generator.base.StringUtils;
import com.ichings.generator.db.ColumnSchema;
import com.ichings.generator.db.CommonColumn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 标签
 *
 * @author changebooks
 */
public final class TagUtils {
    /**
     * import ***;
     * import ***;
     * ...
     */
    public static String buildImportList(List<ColumnSchema> columnList, List<String> ignoreList) {
        AssertUtils.nonNull(columnList, "columnList");

        Set<String> javaWrapperSet = new TreeSet<>(Comparator.naturalOrder());
        for (ColumnSchema c : columnList) {
            if (isIgnore(ignoreList, c.getName())) {
                continue;
            }

            if (c.isUseImport()) {
                String javaWrapper = c.getJavaWrapper();
                javaWrapperSet.add(javaWrapper);
            }
        }

        if (Check.isEmpty(javaWrapperSet)) {
            return "";
        }

        List<String> result = new ArrayList<>();
        for (String n : javaWrapperSet) {
            String code = "import " + n + ";";
            result.add(code);
        }

        return StringUtils.join(result, "\n") + "\n";
    }

    /**
     * private Type ***;
     * private Type ***;
     * ...
     */
    public static String buildFieldList(List<ColumnSchema> columnList, List<String> ignoreList, boolean swagger) {
        AssertUtils.nonNull(columnList, "columnList");

        List<String> result = new ArrayList<>();

        String leftTab = "\t";
        boolean firstLine = true;

        for (ColumnSchema c : columnList) {
            if (isIgnore(ignoreList, c.getName())) {
                continue;
            }

            String fieldName = c.getFieldName();
            String remark = c.getRemark();
            String javaSimpleWrapper = c.getJavaSimpleWrapper();

            AssertUtils.nonEmpty(fieldName, "fieldName");
            AssertUtils.nonEmpty(remark, "remark");
            AssertUtils.nonEmpty(javaSimpleWrapper, "javaSimpleWrapper");

            String code = firstLine ? "" : leftTab;

            if (swagger) {
                code += CommentUtils.buildSwagger(leftTab, remark, c.isUniqueKey(), javaSimpleWrapper, remark);
            } else {
                code += CommentUtils.buildAnnotation(leftTab, remark);
            }

            code += leftTab + String.format("private %s %s;", javaSimpleWrapper, fieldName);

            result.add(code);
            firstLine = false;
        }

        return StringUtils.join(result, "\n\n");
    }

    /**
     * <pre>
     * public Type get***() {
     *     return return ***;
     * }
     *
     * public void set***(Type ***) {
     *     this.%s = %s;
     * }
     *
     * ...
     * </pre>
     */
    public static String buildMethodList(List<ColumnSchema> columnList, List<String> ignoreList) {
        AssertUtils.nonNull(columnList, "columnList");

        List<String> result = new ArrayList<>();

        String leftTab = "\t";
        boolean firstLine = true;

        for (ColumnSchema c : columnList) {
            if (isIgnore(ignoreList, c.getName())) {
                continue;
            }

            String javaSimpleWrapper = c.getJavaSimpleWrapper();
            String methodName = c.getMethodName();
            String fieldName = c.getFieldName();

            AssertUtils.nonEmpty(javaSimpleWrapper, "javaSimpleWrapper");
            AssertUtils.nonEmpty(methodName, "methodName");
            AssertUtils.nonEmpty(fieldName, "fieldName");

            String code = firstLine ? "" : leftTab;

            code += String.format("public %s get%s() {\n", javaSimpleWrapper, methodName) +
                    leftTab + String.format("\treturn %s;\n", fieldName) +
                    leftTab + "}\n\n";

            code += leftTab + String.format("public void set%s(%s %s) {\n", methodName, javaSimpleWrapper, fieldName) +
                    leftTab + String.format("\tthis.%s = %s;\n", fieldName, fieldName) +
                    leftTab + "}";

            result.add(code);
            firstLine = false;
        }

        return StringUtils.join(result, "\n\n");
    }

    /**
     * ##mybatis_resource_base_result_map##
     *
     * <id column="id" jdbcType="BIGINT" property="id"/>
     * <result column="user_id" jdbcType="BIGINT" property="userId"/>
     * ...
     */
    public static String buildBaseResultMap(List<ColumnSchema> columnList) {
        AssertUtils.nonNull(columnList, "columnList");

        List<String> result = new ArrayList<>();

        String leftTab = "\t\t";
        boolean firstLine = true;

        for (ColumnSchema c : columnList) {
            String name = c.getName();
            String jdbcName = c.getJdbcName();
            String fieldName = c.getFieldName();
            String tag = c.isPrimaryKey() ? "id" : "result";

            AssertUtils.nonEmpty(name, "name");
            AssertUtils.nonEmpty(jdbcName, "jdbcName");
            AssertUtils.nonEmpty(fieldName, "fieldName");

            String code = firstLine ? "" : leftTab;
            code += String.format("<%s column=\"%s\" jdbcType=\"%s\" property=\"%s\"/>", tag, name, jdbcName, fieldName);

            result.add(code);
            firstLine = false;
        }

        return StringUtils.join(result, "\n");
    }

    /**
     * ##mybatis_resource_base_column_list##
     * <p>
     * id,
     * username,
     * ...
     */
    public static String buildBaseColumnList(List<String> columnNames) {
        AssertUtils.nonNull(columnNames, "columnNames");

        return StringUtils.join(columnNames, ",\n\t\t");
    }

    /**
     * ##mybatis_resource_insert_column_list##
     * ##mybatis_resource_insert_list_column_list##
     * <p>
     * user_id,
     * username,
     * ...
     */
    public static String buildInsertColumnList(List<ColumnSchema> columnList) {
        AssertUtils.nonNull(columnList, "columnList");

        List<String> result = new ArrayList<>();

        String leftTab = "\t\t";
        int line = 1;

        for (ColumnSchema c : columnList) {
            String name = c.getName();
            String fieldName = c.getFieldName();

            AssertUtils.nonEmpty(name, "name");
            AssertUtils.nonEmpty(fieldName, "fieldName");

            if (ignoreInsert(name)) {
                continue;
            }

            String code = line == 1 ? "" : leftTab;
            code += name + ",";

            result.add(code);
            line++;
        }

        return StringUtils.trim(StringUtils.join(result, "\n"), ',');
    }

    /**
     * ##mybatis_resource_insert_value_list##
     * ##mybatis_resource_insert_list_value_list##
     * <p>
     * #{userId,jdbcType=BIGINT},
     * #{username,jdbcType=VARCHAR},
     * ...
     */
    public static String buildInsertValueList(List<ColumnSchema> columnList, boolean foreach) {
        AssertUtils.nonNull(columnList, "columnList");

        List<String> result = new ArrayList<>();

        String leftTab = foreach ? "\t\t\t\t" : "\t\t";
        int line = 1;

        for (ColumnSchema c : columnList) {
            String name = c.getName();
            String fieldName = c.getFieldName();
            String jdbcName = c.getJdbcName();

            AssertUtils.nonEmpty(name, "name");
            AssertUtils.nonEmpty(fieldName, "fieldName");
            AssertUtils.nonEmpty(jdbcName, "jdbcName");

            if (ignoreInsert(name)) {
                continue;
            }

            String code = line == 1 ? "" : leftTab;
            code += String.format("#{%s,jdbcType=%s},", fieldName, jdbcName);

            result.add(code);
            line++;
        }

        return StringUtils.trim(StringUtils.join(result, "\n"), ',');
    }

    /**
     * ##mybatis_resource_update_field_list##
     * ##mybatis_resource_update_list_field_list##
     *
     * <pre>
     * <if test="userId != null">
     *     userId = #{userId,jdbcType=BIGINT},
     * </if>
     * <if test="username != null">
     *     username = #{username,jdbcType=VARCHAR},
     * </if>
     * ...
     * </pre>
     */
    public static String buildUpdateFieldList(List<ColumnSchema> columnList, boolean foreach) {
        AssertUtils.nonNull(columnList, "columnList");

        List<String> result = new ArrayList<>();

        String leftTab = foreach ? "\t\t\t\t\t" : "\t\t\t";
        boolean firstLine = true;

        for (ColumnSchema c : columnList) {
            String name = c.getName();
            String fieldName = c.getFieldName();
            String jdbcName = c.getJdbcName();

            AssertUtils.nonEmpty(name, "name");
            AssertUtils.nonEmpty(fieldName, "fieldName");
            AssertUtils.nonEmpty(jdbcName, "jdbcName");

            if (ignoreUpdate(name)) {
                continue;
            }

            if (foreach) {
                fieldName = Constant.VARIABLE_NAME + "." + fieldName;
            }

            String code = firstLine ? "" : leftTab;
            code += String.format("<if test=\"%s != null\">\n", fieldName) +
                    leftTab + String.format("\t%s = #{%s,jdbcType=%s},\n", name, fieldName, jdbcName) +
                    leftTab + "</if>";

            result.add(code);
            firstLine = false;
        }

        return StringUtils.join(result, "\n");
    }

    /**
     * ##mybatis_resource_insert_column_list##
     * ##mybatis_resource_insert_list_column_list##
     * ##mybatis_resource_insert_value_list##
     * ##mybatis_resource_insert_list_value_list##
     * 忽略字段
     */
    private static boolean ignoreInsert(String columnName) {
        return CommonColumn.isCreatedAt(columnName) ||
                CommonColumn.isUpdatedAt(columnName) ||
                CommonColumn.isDeletedAt(columnName) ||
                CommonColumn.isDeleted(columnName);
    }

    /**
     * ##mybatis_resource_update_field_list##
     * ##mybatis_resource_update_list_field_list##
     * 忽略字段
     */
    private static boolean ignoreUpdate(String columnName) {
        return CommonColumn.isId(columnName) ||
                CommonColumn.isCreatedAt(columnName) ||
                CommonColumn.isUpdatedAt(columnName);
    }

    /**
     * 忽略字段？
     */
    public static boolean isIgnore(List<String> columnList, String columnName) {
        if (Check.isEmpty(columnList)) {
            return false;
        }

        if (Check.isEmpty(columnName)) {
            return false;
        }

        return columnList.contains(columnName);
    }

}
