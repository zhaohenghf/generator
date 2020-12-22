# generator
## 代码生成器

### 运行
```
com.ichings.generator.main.Application.main();
```

### 配置文件
```
resources.application.properties
```

### 配置内容摘要
```
# 生成代码的根包名
biz.package-name=com.generator.sample

# 生成代码的作者名（替换模板中的##author_name##）
biz.author-name=张三

# 表名
biz.table-name=table1, table2, table3

# 存放模板的根目录（建议绝对路径）
biz.template-directory=template

# 存放生成代码的根目录（建议绝对路径）
biz.target-directory=tmp-generator
#
#
#
#### 数据库 ###
dsn.url=jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai
dsn.username=root
dsn.password=123456
```

### 竞品
```
Mybatis Generator

EasyCode
```
