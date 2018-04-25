package com.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Properties文件的读取方式
 * 1.使用Properties方式
 * 2.使用ResourceBunder方式
 */
public class PropertiesDemo {
    /**
     * 通过properties方式
     *
     * @return properties对应的value
     */
    public static String getPropertiesValueByProperties(String propertiesKey) {


        Properties props = new Properties();
        InputStream in = null;

        try {
            in = PropertiesDemo.class.getClassLoader().getResourceAsStream("com/properties/test.properties");
            props.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return props.getProperty(propertiesKey);
    }

    /**
     * 通过ResourceBundle方式
     *
     * @param propertiesKey
     * @return
     */
    public static String getPropertiesValueByResourceBundle(String propertiesKey) {
        ResourceBundle bundle = ResourceBundle.getBundle("com.properties.test");
        return bundle.getString(propertiesKey);
    }


    /**
     * 方式3.通过读取属性文件到Spring容器
     * 1、在配置文件头配置context约束
     * 2、在配置文件中添加<context:property-placeholder location="classpath:xxxx"/>
     * 3、获取配置文件内容：${key}
     */
    public void test() {

    }


    public static void main(String[] args) {
        //通过properties方式获取properties value
        System.out.println(PropertiesDemo.getPropertiesValueByProperties("jdbc.url"));
        System.out.println(PropertiesDemo.getPropertiesValueByProperties("jdbc.username"));
        System.out.println(PropertiesDemo.getPropertiesValueByProperties("jdbc.password"));
        System.out.println(PropertiesDemo.getPropertiesValueByProperties("jdbc.driver"));

        //通过ResouceBundle方式获取properteis value
        System.out.println(PropertiesDemo.getPropertiesValueByResourceBundle("jdbc.url"));
        System.out.println(PropertiesDemo.getPropertiesValueByResourceBundle("jdbc.username"));
        System.out.println(PropertiesDemo.getPropertiesValueByResourceBundle("jdbc.password"));
        System.out.println(PropertiesDemo.getPropertiesValueByResourceBundle("jdbc.driver"));


    }

}
