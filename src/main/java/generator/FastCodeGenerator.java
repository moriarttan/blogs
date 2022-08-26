package generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.*;

/**
 * <p>
 * 代码生成器（快速版本）
 * </p>
 *
 * @author FF
 * @since 2021-10-22 0022 16:51
 */
public class FastCodeGenerator {

    // 基础信息配置
    // 数据库连接字符
    private static final String URL = "jdbc:mysql://localhost:3306/blogs?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowPublicKeyRetrieval=true";
    // 数据库用户名
    private static final String USERNAME = "root";
    // 数据库密码
    private static final String PASSWORD = "123456";
    // 项目根路径。生成结果如：
    private static final String projectRootPath = System.getProperty("user.dir");
    private static final String path = "D:\\Git\\blogs\\src\\main\\java\\com\\example\\blogs\\";
    // 项目根路径（测试用，非通用）（此句是本项目测试用的。实际项目中，包括多模块项目，请注释掉此句，使用上句）
//    private static final String projectRootPath = System.getProperty("user.dir") + "/study-mybatis-plus-fast-generator";
    // 父包名。用于生成的java文件的import。
//    private static final String parentPackageName = "com.cxhit.mybatisplus.generator";
    private static final String parentPackageName = "com.example";

    // 模板主目录
    static String templatePath = "/template";
    // controller 模板地址
    static String controllerTemplate = templatePath + "/" + "controller.java";
    // service 模板地址
    static String serviceTemplate = templatePath + "/" + "service.java";
    // serviceImpl 模板地址
    static String serviceImplTemplate = templatePath + "/" + "serviceImpl.java";
    // entity 模板地址
    static String entityTemplate = templatePath + "/" + "entity.java";
    // mapper 模板地址
    static String mapperTemplate = templatePath + "/" + "mapper.java";
    // mapper xml 模板地址
    static String xmlTemplate = templatePath + "/" + "mapper.xml";

    /**
     * 执行此处
     */
    public static void main(String[] args) {
        System.out.println("输入生成表名用逗号隔开,所有表输入all");
        Scanner scanner = new Scanner(System.in);
        getTables(scanner.next());

        // 简单示例，适用于单模块项目
        simpleGenerator(1);
        simpleGenerator(2);
    }

    /**
     * 【单模块】简单的实现方案
     */
    protected static void simpleGenerator(int otherNum) {
        //1.DTO 2.VO
        String other = otherNum == 1 ? "dto" : "vo";

        // 包路径
        String packagePath = projectRootPath + "/src/main/java";
        // XML文件的路径
        String mapperXmlPath = projectRootPath + "/src/main/resources/mapper";

        // 开始执行代码生成
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                // 1. 全局配置
                .globalConfig(builder -> builder
                        // 作者名称
                        .author("FF")
                        // 开启覆盖已生成的文件。注释掉则关闭覆盖。
                        .fileOverride()
                        // 禁止打开输出目录。注释掉则生成完毕后，自动打开生成的文件目录。
                        .disableOpenDir()
                        // 指定输出目录。如果指定，Windows生成至D盘根目录下，Linux or MAC 生成至 /tmp 目录下。
                        .outputDir(packagePath)
                        // 开启swagger2.注释掉则默认关闭。
                        .enableSwagger()
                        // 指定时间策略。
                        .dateType(DateType.TIME_PACK)
                        // 注释时间策略。entity
                        .commentDate("yyyy-MM-dd")
                )

                // 2. 包配置
                .packageConfig((scanner, builder) -> builder
                        // 设置父表名
                        .parent(parentPackageName)
                        .moduleName("blogs")
                        .other(other) // 设置dto包名
                        // mapper.xml 文件的路径。单模块下，其他文件路径默认即可。
                        .pathInfo(
                                new HashMap<OutputFile, String>() {{
                                    // mapper.xml文件的保存路径
                                    put(OutputFile.mapperXml, mapperXmlPath);
                                    put(OutputFile.other, path + other);
                                    put(OutputFile.service, path + "service");
                                    put(OutputFile.mapper, path + "mapper");
                                    put(OutputFile.serviceImpl, path + "service/impl");
                                    put(OutputFile.entity, path + "entity");
                                    // 控制类的保存路径
                                    put(OutputFile.controller, path + "controller");
                                }})
                )
                .injectionConfig(consumer -> {
                    Map<String, String> customFile = new HashMap<>();
                    // DTO
                    if ("dto".equals(other)) {
                        customFile.put("DTO.java", "/template/entityDTO.java.ftl");
                    } else {
                        customFile.put("VO.java", "/template/entityVO.java.ftl");
                    }
                    consumer.customFile(customFile);
                })
                .templateConfig(builder -> {
                    builder.controller(controllerTemplate)
                            .entity(entityTemplate)
                            .service(serviceTemplate)
                            .serviceImpl(serviceImplTemplate)
                            .mapper(mapperTemplate)
                            .mapperXml(xmlTemplate);
                })
                // 3. 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude()
                        .addExclude("admin", "admin_role_relation", "permission", "role_permission_relation", "role")
                        // 阶段1：Entity实体类策略配置
                        .entityBuilder()
                        // 开启生成实体时生成字段注解。
                        // 会在实体类的属性前，添加[@TableField("nickname")]
                        .enableTableFieldAnnotation()
                        .enableLombok()
                        // 逻辑删除字段名(数据库)。
                        .logicDeleteColumnName("is_delete")
                        // 逻辑删除属性名(实体)。
                        // 会在实体类的该字段属性前加注解[@TableLogic]
                        .logicDeletePropertyName("isDelete")
                        // 会在实体类的该字段上追加注解[@TableField(value = "create_time", fill = FieldFill.INSERT)]
                        .addTableFills(new Column("create_time", FieldFill.INSERT), new Column("create_username", FieldFill.INSERT), new Column("create_user_id", FieldFill.INSERT))
                        // 会在实体类的该字段上追加注解[@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)]
                        .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE), new Column("update_user_id", FieldFill.INSERT_UPDATE), new Column("update_username", FieldFill.INSERT_UPDATE))
                        // 阶段2：Mapper策略配置
                        .mapperBuilder()
                        // 开启 @Mapper 注解。
                        // 会在mapper接口上添加注解[@Mapper]
                        .enableMapperAnnotation()
                        // 启用 BaseResultMap 生成。
                        // 会在mapper.xml文件生成[通用查询映射结果]配置。
                        .enableBaseResultMap()
                        // 启用 BaseColumnList。
                        // 会在mapper.xml文件生成[通用查询结果列 ]配置
                        .enableBaseColumnList()
                        // 阶段4：Controller策略配置
                        .controllerBuilder()
                        // 会在控制类中加[@RestController]注解。
                        .enableRestStyle()
                        // 开启驼峰转连字符
                        .enableHyphenStyle()
                        .serviceBuilder().formatServiceFileName("%sService")
                        .build()
                )

                // 4. 模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                .templateEngine(new EnhanceFreemarkerTemplateEngine())

                // 5. 执行
                .execute();
    }


    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }


}

