package com.ichings.generator.main.impl;

import com.ichings.generator.base.AssertUtils;
import com.ichings.generator.base.FileUtils;
import com.ichings.generator.main.WriterService;
import com.ichings.generator.model.AbsolutePath;
import com.ichings.generator.model.TargetCode;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * @author changebooks
 */
@Service
public class WriterServiceImpl implements WriterService {

    @Override
    public void write(AbsolutePath absolutePath, TargetCode targetCode) throws IOException {
        AssertUtils.nonNull(absolutePath, "absolutePath");
        AssertUtils.nonNull(targetCode, "targetCode");

        write(absolutePath.getPersistentObject(), targetCode.getPersistentObject());
        write(absolutePath.getPersistentObjectMapper(), targetCode.getPersistentObjectMapper());
        write(absolutePath.getPersistentObjectCriteria(), targetCode.getPersistentObjectCriteria());
        write(absolutePath.getMybatisObject(), targetCode.getMybatisObject());
        write(absolutePath.getMybatisResource(), targetCode.getMybatisResource());
        write(absolutePath.getDatabaseInterface(), targetCode.getDatabaseInterface());
        write(absolutePath.getDatabaseImpl(), targetCode.getDatabaseImpl());
        write(absolutePath.getRepositoryInterface(), targetCode.getRepositoryInterface());
        write(absolutePath.getRepositoryImpl(), targetCode.getRepositoryImpl());
        write(absolutePath.getDataTransferObject(), targetCode.getDataTransferObject());
        write(absolutePath.getDataTransferObjectMapper(), targetCode.getDataTransferObjectMapper());
        write(absolutePath.getServiceInterface(), targetCode.getServiceInterface());
        write(absolutePath.getServiceImpl(), targetCode.getServiceImpl());
        write(absolutePath.getViewObject(), targetCode.getViewObject());
        write(absolutePath.getViewObjectMapper(), targetCode.getViewObjectMapper());
        write(absolutePath.getViewObjectCreateRequest(), targetCode.getViewObjectCreateRequest());
        write(absolutePath.getViewObjectUpdateRequest(), targetCode.getViewObjectUpdateRequest());
        write(absolutePath.getViewObjectCriteriaRequest(), targetCode.getViewObjectCriteriaRequest());
        write(absolutePath.getController(), targetCode.getController());
    }

    @Override
    public void write(String fileName, String code) throws IOException {
        AssertUtils.nonEmpty(fileName, "fileName");
        AssertUtils.nonEmpty(code, "code");

        File file = new File(fileName);
        FileUtils.write(file, code, false);
    }

}
