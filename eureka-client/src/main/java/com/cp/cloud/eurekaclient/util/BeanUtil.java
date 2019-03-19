package com.cp.cloud.eurekaclient.util;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * Description: 就是实现类里面使用注解获取的对象是获取不到的，因为它们不会被Spring管理，
 * 我们前面都是自己new context()的对象，还有是通过反射new出来的，它们已经脱离了Spring的管理，运行时会出来 Null 异常。
 *
 * @author chenpeng
 * @date 2019/2/27 21:52
 */
@Service
public class BeanUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanUtil.applicationContext = applicationContext;
    }

    public BeanUtil() {
        //加载继承该类的类，扫描成员变量
        Reflections reflections = new Reflections(this.getClass(), new FieldAnnotationsScanner());

        //将含有Autowired注解的成员变量扫描出来
        Set<Field> fields = reflections.getFieldsAnnotatedWith(Autowired.class);

        for (Field field : fields) {

            try {
                //获取成员变量所属类的类名
                String simpleName = field.getType().getSimpleName();
                //把首字母转为小写，因为spring中管理的bean 的name都是小写
                String beanName = toLowerCaseFirstLetter(simpleName);
                //通过beanName 去applicationContext获取beanName对象
                Object bean = applicationContext.getBean(beanName);

                if (bean == null) {
                    return;
                }

                //打破封装
                field.setAccessible(true);
                //把spring管理的对象 设置到我们反射出来的对象中
                field.set(this, bean);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

    public String toLowerCaseFirstLetter(String beanName) {
        String newBeanName = beanName.substring(0, 1).toLowerCase() +
                beanName.substring(1, beanName.length());
        return newBeanName;
    }

}
