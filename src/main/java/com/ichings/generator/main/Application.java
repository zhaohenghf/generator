package com.ichings.generator.main;

import com.ichings.generator.autoconfigure.BizProperties;
import com.ichings.generator.autoconfigure.DsnProperties;
import com.ichings.generator.autoconfigure.PackageProperties;
import com.ichings.generator.autoconfigure.SuffixProperties;
import com.ichings.generator.autoconfigure.TemplateProperties;
import com.ichings.generator.db.DbDriver;
import com.ichings.generator.db.DbSchema;
import com.ichings.generator.db.DbUtils;
import com.ichings.generator.schema.DirectorySchema;
import com.ichings.generator.schema.PackageSchema;
import com.ichings.generator.schema.TemplateSchema;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author changebooks
 */
@SpringBootApplication
@EnableConfigurationProperties({
        BizProperties.class,
        DsnProperties.class,
        PackageProperties.class,
        SuffixProperties.class,
        TemplateProperties.class})
public class Application {
    /**
     * 启动类名
     */
    private static final String RUNNER = "runner";

    public static void main(String[] args) throws IOException {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        Runner runner = context.getBean(RUNNER, Runner.class);
        runner.run();
    }

    @Bean
    public DirectorySchema directorySchema(BizProperties bizProperties, PackageProperties packageProperties) {
        return new DirectorySchema.Builder().
                setDirectory(bizProperties.getTargetDirectory()).
                setProperties(packageProperties).
                create();
    }

    @Bean
    public PackageSchema packageSchema(BizProperties bizProperties, PackageProperties packageProperties) {
        return new PackageSchema.Builder().
                setPackageName(bizProperties.getPackageName()).
                setProperties(packageProperties).
                create();
    }

    @Bean
    public TemplateSchema templateSchema(BizProperties bizProperties, TemplateProperties templateProperties) throws IOException {
        return new TemplateSchema.Builder().
                setDirectory(bizProperties.getTemplateDirectory()).
                setProperties(templateProperties).
                setAuthorName(bizProperties.getAuthorName()).
                create();
    }

    @Bean
    public DbSchema dbSchema(DbDriver dbDriver, BizProperties bizProperties) throws SQLException {
        return DbUtils.getDb(dbDriver.getConnection(), bizProperties.getTableName());
    }

    @Bean
    public DbDriver dbDriver(DsnProperties properties) {
        return new DbDriver(properties);
    }

}
