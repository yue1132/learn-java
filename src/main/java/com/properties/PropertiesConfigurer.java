package com.properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

/**
 * 通过PropertyPlaceholderConfigurer在加载上下文的时候暴露properties到自定义子类的属性中以供程序中使用
 */
public class PropertiesConfigurer extends PropertyPlaceholderConfigurer {

    private Properties props;

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        this.props = props;
    }

    public String getProperties(String key){
        return this.props.getProperty(key);
    }

    public String getProperties(String key,String defaultValue){
        return  this.props.getProperty(key,defaultValue);
    }


    public Object setProperties(String key,String value){
       return this.props.setProperty(key,value);
    }

}
