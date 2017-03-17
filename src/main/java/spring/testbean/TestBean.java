package spring.testbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Liuqi
 * Date: 2017/3/17.
 */
public class TestBean {
    public static void main(String[] args) {
        System.out.println("main 开始初始化");
       /* ClassPathResource resource = new ClassPathResource("bean.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);*/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        System.out.println("初始化容器成功");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
        System.out.println("现在关闭容器");
        ((ClassPathXmlApplicationContext) applicationContext).registerShutdownHook();
    }
}
