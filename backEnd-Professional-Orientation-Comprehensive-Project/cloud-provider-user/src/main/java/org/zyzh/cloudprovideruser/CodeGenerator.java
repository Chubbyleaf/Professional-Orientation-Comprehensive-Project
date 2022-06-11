package org.zyzh.cloudprovideruser;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 代码生成器
 * 一般情况, 需要改动的地方:
 *  作者,
 *  数据源相关,
 *  生成的代码路径,
 *  需要映射的表名
 */
// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

    //要生成的表名A
    private static String[] tables ={"announce"};


    public static void main(String[] args) {
        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");////项目路径
        gc.setOutputDir(projectPath + "/src/main/java");// 生成的文件路径
        gc.setAuthor("Group5");//作者，开发人员
        gc.setOpen(false); //生成后是否打开资源管理器
        //gc.setFileOverride(true); // 是否覆盖已有文件, 默认false
        gc.setServiceName("%sService");	//service 命名方式,自动生成的Service类前面会自动加前缀I, 这里( %s 为占位符)取消I前缀
        //gc.setServiceImplName("%sServiceImpl");//service impl 命名方式
        gc.setIdType(IdType.AUTO); // 指定生成的主键的ID类型
        gc.setSwagger2(true);//开启Swagger2模式
        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://212.129.245.11:3306/zyzh?useSSL=false&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("zyzh");
        dsc.setPassword("zyzh2022.");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("org.zyzh.cloudprovideruser");
        pc.setEntity("sys.entity"); //此对象与数据库表结构一一对应，通过 DAO 层向上传输数据源对象。
        pc.setMapper("sys.mapper");
        pc.setService("sys.service");
        pc.setController("sys.controller");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略

        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true); // lombok
        strategy.setLogicDeleteFieldName("is_deleted");//逻辑删除字段名
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);//去掉布尔值的is_前缀（确保tinyint(1)）
        strategy.setRestControllerStyle(true); // 加上@RestController注解
        //strategy.setControllerMappingHyphenStyle(true);
        strategy.setInclude(tables);
        mpg.setStrategy(strategy);

        // 6、执行
        mpg.execute();
    }

}
