package com.cooper.factorymanager;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * TODO
 *
 * @author Cooper
 * @CreateDate 2023/7/22/10:42
 */
public class codeGenerator {
    public static void main(String[] args) {
        String url= "jdbc:mysql://localhost:3306/fac?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "123456";
        String MapperLocation = "D:\\Project\\Java\\factoryManager\\src\\main\\resources\\mapper\\";
        String tables = "address,goods,menu,outbound,role,role_menu,storage,user,user_role";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("cooper") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\Project\\Java\\factoryManager\\src\\main\\java\\com\\cooper\\factorymanager\\Generator\\"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.cooper.factorymanager.Generator.Generator") // 设置父包名
//                            .moduleName("test1") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, MapperLocation)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables); // 设置需要生成的表名
//                            .addTablePrefix("x_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
