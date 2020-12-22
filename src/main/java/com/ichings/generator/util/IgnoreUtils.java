package com.ichings.generator.util;

import com.ichings.generator.db.CommonColumn;

import java.util.ArrayList;
import java.util.List;

/**
 * 忽略字段
 *
 * @author changebooks
 */
public final class IgnoreUtils {
    /**
     * Data Transfer Object
     */
    public static final List<String> DATA_TRANSFER_OBJECT = new ArrayList<>();

    /**
     * View Object
     */
    public static final List<String> VIEW_OBJECT = new ArrayList<>();

    /**
     * View Object Create Request
     */
    public static final List<String> VIEW_OBJECT_CREATE_REQUEST = new ArrayList<>();

    static {
        DATA_TRANSFER_OBJECT.add(CommonColumn.IS_DELETED.getName());
        DATA_TRANSFER_OBJECT.add(CommonColumn.DELETED_AT.getName());

        VIEW_OBJECT.add(CommonColumn.NOTE.getName());
        VIEW_OBJECT.add(CommonColumn.IS_DELETED.getName());
        VIEW_OBJECT.add(CommonColumn.DELETED_AT.getName());

        VIEW_OBJECT_CREATE_REQUEST.add(CommonColumn.ID.getName());
        VIEW_OBJECT_CREATE_REQUEST.add(CommonColumn.CREATED_AT.getName());
        VIEW_OBJECT_CREATE_REQUEST.add(CommonColumn.UPDATED_AT.getName());
        VIEW_OBJECT_CREATE_REQUEST.add(CommonColumn.IS_DELETED.getName());
        VIEW_OBJECT_CREATE_REQUEST.add(CommonColumn.DELETED_AT.getName());
    }

}
