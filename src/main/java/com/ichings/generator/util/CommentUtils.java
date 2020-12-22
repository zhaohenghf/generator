package com.ichings.generator.util;

/**
 * 注释
 *
 * @author changebooks
 */
public final class CommentUtils {
    /**
     * 普通注释
     */
    public static String buildAnnotation(String leftTab, String comment) {
        return "/**\n" +
                leftTab + String.format(" * %s\n", comment) +
                leftTab + " */\n";
    }

    /**
     * Swagger 注释
     */
    public static String buildSwagger(String leftTab, String value, boolean isUnique, String javaSimpleWrapper, String example) {
        String result = String.format(
                "@ApiModelProperty(value = \"%s\", required = %s, dataType = \"%s\", example = \"%s\")\n",
                value, (isUnique ? "true" : "false"), javaSimpleWrapper, example);

        if (isUnique) {
            result = "@NotEmpty\n" + leftTab + result;
        }

        return result;
    }

}
