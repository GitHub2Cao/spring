package com.softnovo.base;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class Generator {
	public static void main(String[] args) throws Exception { // MBG 执行过程中的警告信息
		List<String> warnings = new ArrayList<String>();
		// 当 生成的代码重复时，覆盖原代码
		boolean overwrite = true;
		// 读取 MBG 配直文件
		InputStream is = Generator.class.getResourceAsStream("./generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(is);
		is.close();
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		// 创建 MBG
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		// 执行生成代码
		myBatisGenerator.generate(null); // 输 出 警告信息
		for (String warning : warnings) {
			System.out.println(warning);
		}
	}
}
