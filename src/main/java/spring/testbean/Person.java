package spring.testbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Created by Liuqi
 * Date: 2017/3/17.
 */
public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String name;
    private int age;
    private String phone;
    private String address;

    private String beanName;
    private BeanFactory beanFactory;

    public Person() {
        System.out.println("调用构造器 初始化bean");
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        System.out.println("注入name属性");
        this.name = name;
    }

    public void setAge(int age) {
        System.out.println("注入age属性");
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        System.out.println("获得name属性");
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString()  {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("注入beanFactory");
        this.beanFactory = beanFactory;
    }

    public void setBeanName(String name) {
        System.out.println("设置beanName");
        this.beanName = name;
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet()");

    }

    public void destroy() throws Exception {
        System.out.println("调用DiposibleBean.destory()");
    }

    public void myInit() {
        System.out.println("myInit");
    }

    public void myDestory() {
        System.out.println("myDestory");
    }
}
