package com.ichings.generator.main;

import com.ichings.generator.model.AbsolutePath;
import com.ichings.generator.model.TargetCode;

import java.io.IOException;

/**
 * 操作文件
 *
 * @author changebooks
 */
public interface WriterService {
    /**
     * 写文件
     *
     * @param absolutePath AbsolutePath
     * @param targetCode   TargetCode
     * @throws IOException 写失败
     */
    void write(AbsolutePath absolutePath, TargetCode targetCode) throws IOException;

    /**
     * 写文件
     *
     * @param fileName 文件路径
     * @param code     文件内容
     * @throws IOException 写失败
     */
    void write(String fileName, String code) throws IOException;

}
