package spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.ResourceBundle;

/**
 * Created by Liuqi
 * Date: 2016/11/1.
 */
public class TestSpring {

    ClassPathResource resource = new ClassPathResource("bean.xml");
    DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
    FileSystemXmlApplicationContext con;
    ResourceBundle bundle;
    ApplicationContext context;
    BeanDefinition definition;
}
