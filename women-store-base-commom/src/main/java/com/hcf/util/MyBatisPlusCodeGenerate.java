package com.hcf.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/** MyBatis-Plus自动生成代码 */
public class MyBatisPlusCodeGenerate {
  /** 读取控制台内容 */
  public static String scanner(String tip) {
    Scanner scanner = new Scanner(System.in);
    StringBuilder help = new StringBuilder();
    help.append("请输入" + tip + "：");
    System.out.println(help.toString());
    if (scanner.hasNext()) {
      String ipt = scanner.next();
      if (StringUtils.isNotBlank(ipt)) {
        return ipt;
      }
    }
    throw new MybatisPlusException("请输入正确的" + tip + "！");
  }

  public static void main(String[] args) {
    // 代码生成器实体对象
    AutoGenerator mpg = new AutoGenerator();

    // 全局配置
    GlobalConfig gc = new GlobalConfig();
    gc.setOutputDir(scanner("请输入项目路径") + "/src/main/java");
    gc.setAuthor("hcf");
    // 生成之后是否打开输出目录
    gc.setOpen(false);
    // 重新生成是否覆盖文件
    gc.setFileOverride(false);
    // 生成接口
    gc.setServiceName("%sService");
    // 设置组件生成策略,自动增长
    gc.setIdType(IdType.AUTO);
    // 日期类型
    gc.setDateType(DateType.ONLY_DATE);
    // 实体属性 Swagger2 注解
    gc.setSwagger2(true);
    mpg.setGlobalConfig(gc);

    // 数据源配置
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setUrl(
        "jdbc:mysql://localhost:3306/womenstore?useUnicode=true&characterEncoding=UTF-8" +
                "&serverTimezone=GMT%2B8");
    // dsc.setSchemaName("public");
    dsc.setDriverName("com.mysql.cj.jdbc.Driver");
    dsc.setUsername("root");
    dsc.setPassword("root");
    dsc.setDbType(DbType.MYSQL);
    mpg.setDataSource(dsc);

    // 包配置
    PackageConfig pc = new PackageConfig();
    pc.setModuleName(scanner("请输入模块名"));
    pc.setParent("com.hcf");
    pc.setController("controller");
    pc.setService("service");
    pc.setServiceImpl("service.impl");
    pc.setMapper("mapper");
    pc.setEntity("entity");
    pc.setXml("mapper");
    mpg.setPackageInfo(pc);

    // 策略配置
    StrategyConfig strategy = new StrategyConfig();
    // 设置哪些表需要自动生成
    strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
    // 实体类驼峰命名
    strategy.setNaming(NamingStrategy.underline_to_camel);
    // 列名驼峰吗命名
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    // 使用lombok简化
    strategy.setEntityLombokModel(true);
    // 设置controller风格
    strategy.setRestControllerStyle(true);
    // 驼峰转连字符
    strategy.setControllerMappingHyphenStyle(true);
    // 忽略表中生成类的前缀
    strategy.setTablePrefix("tb_");
    mpg.setStrategy(strategy);
    mpg.execute();
  }
}
