package com.springaware;

import com.springaware.config.AwareConfig;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * spring aware实例
 * 1.Spring 提供的Aware接口
 *   BeanNameAware    获得容器中Bean的名称
 *   BeanFactoryAware 获得当前bean Factory，从而调用容器的服务
 *   ApplicationContextAware 当前的application context 从而调用容器的服务
 *   MessageSourceAware  message sourcece从而得到文本信息
 *  ResourceLoaderAware 获取资源加载器，可以获得外部资源文件
 * 2.Spring Aware的目的是为了让bean获得spring容器的服务，应为ApplicationContext集成了
 * MessageSource接口、ApplicationEventPublisher和ResourceLoader接口，因此当bean继承
 * 自ApplicationContextAware的时候就可以得到Spring容器的所有服务
 */
@Service
public class AwareServiceDemo implements BeanNameAware, ResourceLoaderAware {

    private String beanName;
    private ResourceLoader loader;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void outputResult() throws IOException {
        System.out.println("======Bean的名称是：" + beanName);
        Resource resource = loader.getResource("classpath:com/springaware/springAware.md");
        System.out.println("ResourceLoader加载的文件内容：");

        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareServiceDemo serviceDemo = context.getBean(AwareServiceDemo.class);
        try {
            serviceDemo.outputResult();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            context.close();
        }
    }
}
