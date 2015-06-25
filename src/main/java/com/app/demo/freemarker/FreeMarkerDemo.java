package com.app.demo.freemarker;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerDemo {
	public static void main(String[] args) throws IOException, TemplateException {

		//1.创建配置实例Cofiguration
		Configuration cfg = new Configuration();

		//2.设置模板文件目录
		//（1）src目录下的目录（template在src下）
		//cfg.setDirectoryForTemplateLoading(new File("src/template"));
		//（2）完整路径（template在src下）
		//cfg.setDirectoryForTemplateLoading(new File(
		//  	"D:/cpic-env/workspace/javaFreemarker/src/template"));
		//cfg.setDirectoryForTemplateLoading(new File("src/template"));
		//（3）工程目录下的目录（template/main在工程下）--推荐
		cfg.setDirectoryForTemplateLoading(new File("./src/main/resources/dev/freemarker/"));
		//cfg.setObjectWrapper(new DefaultObjectWrapper());
		//获取模板（template）
		Template template = cfg.getTemplate("demo.ftl");
		//建立数据模型（Map）
		Map<String, String> root = new HashMap<String, String>();
		root.put("name", "cxl");
		root.put("age", "25");
		//获取输出流（指定到控制台（标准输出））
		Writer out = new OutputStreamWriter(System.out);
		//StringWriter out = new StringWriter();
		//System.out.println(out.toString());
		//数据与模板合并（数据+模板=输出）
		template.process(root, out);
		out.flush();
	}
}

