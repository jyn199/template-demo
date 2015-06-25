package com.app.demo.velocity;

import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/**
 * 从文件中加载模板文件,即velocity默认的模板文件加载方式
 * @author welcome
 *
 */
public class VelocityDemo {
    
    public static void main(String[] args) throws Exception{
    	fileType();
    	classType();
    	jarType();
    }
    
    /**
     * 找classpath目录下面的
     */
    private static void jarType(){
    	//初始化参数
        Properties properties=new Properties();
        //设置velocity资源加载方式为file
        properties.setProperty("resource.loader", "jar");
        //设置velocity资源加载方式为file时的处理类
        properties.setProperty("jar.resource.loader.class", "org.apache.velocity.runtime.resource.loader.JarResourceLoader");
        //设置jar包所在的位置
        properties.setProperty("jar.resource.loader.path", "jar:file:./src/main/webapp/WEB-INF/lib/vm.jar");
        //实例化一个VelocityEngine对象
        VelocityEngine velocityEngine=new VelocityEngine(properties);
        
        //实例化一个VelocityContext
        VelocityContext context=new VelocityContext();
        //向VelocityContext中放入键值
        context.put("name", "jarType");
        //实例化一个StringWriter
        StringWriter writer=new StringWriter();
        //从vm目录下加载index.vm模板,在eclipse工程中该vm目录与src目录平级
        velocityEngine.mergeTemplate("vm/index.vm", "utf-8", context, writer);
        System.out.println(writer.toString());
    }
    
    /**
     * 找classpath目录下面的
     */
    private static void classType(){
    	//初始化参数
        Properties properties=new Properties();
        //设置velocity资源加载方式为file
        properties.setProperty("resource.loader", "class");
        //设置velocity资源加载方式为file时的处理类
        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        //实例化一个VelocityEngine对象
        VelocityEngine velocityEngine=new VelocityEngine(properties);
        
        //实例化一个VelocityContext
        VelocityContext context=new VelocityContext();
        //向VelocityContext中放入键值
        context.put("name", "classType");
        //实例化一个StringWriter
        StringWriter writer=new StringWriter();
        //从vm目录下加载index.vm模板,在eclipse工程中该vm目录与src目录平级
        velocityEngine.mergeTemplate("vm/demo.vm", "utf-8", context, writer);
        System.out.println(writer.toString());
    }
    
    /**
     * 找file目录下面的
     */
    private static void fileType(){
    	//初始化参数
        Properties properties=new Properties();
        //设置velocity资源加载方式为file
        properties.setProperty("resource.loader", "file");
        //设置velocity资源加载方式为file时的处理类
        properties.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        //实例化一个VelocityEngine对象
        VelocityEngine velocityEngine=new VelocityEngine(properties);
        
        //实例化一个VelocityContext
        VelocityContext context=new VelocityContext();
        //向VelocityContext中放入键值
        context.put("name", "fileType");
        //实例化一个StringWriter
        StringWriter writer=new StringWriter();
        //从vm目录下加载index.vm模板,在eclipse工程中该vm目录与src目录平级
        velocityEngine.mergeTemplate("./src/main/resources/dev/vm/demo.vm", "utf-8", context, writer);
        System.out.println(writer.toString());
    }
    
}