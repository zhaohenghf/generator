package com.ichings.generator.main;

import com.ichings.generator.base.Check;
import com.ichings.generator.db.DbSchema;
import com.ichings.generator.db.TableSchema;
import com.ichings.generator.model.AbsolutePath;
import com.ichings.generator.model.TagValue;
import com.ichings.generator.model.TargetCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * 运行
 *
 * @author changebooks
 */
@Component
public class Runner {

    @Autowired
    private PathService pathService;

    @Autowired
    private TagService tagService;

    @Autowired
    private TargetService targetService;

    @Autowired
    private WriterService writerService;

    @Autowired
    private DbSchema dbSchema;

    public void run() throws IOException {
        batchGenerate();
    }

    /**
     * 批量构建
     */
    public void batchGenerate() throws IOException {
        List<TableSchema> tableList = dbSchema.getTableList();
        if (Check.nonEmpty(tableList)) {
            for (TableSchema t : tableList) {
                generate(t);
            }
        }
    }

    /**
     * 构建
     */
    public void generate(TableSchema tableSchema) throws IOException {
        TagValue tagValue = tagService.getValue(tableSchema);
        AbsolutePath absolutePath = pathService.getAbsolutePath(tagValue);
        TargetCode targetCode = targetService.getTargetCode(tagValue);

        writerService.write(absolutePath, targetCode);
    }

}
