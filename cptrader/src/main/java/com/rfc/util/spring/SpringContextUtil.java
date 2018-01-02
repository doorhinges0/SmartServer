package com.rfc.util.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * spring上下文工具类
 *
 * @author fone
 * @version 2015年12月11日
 * @see SpringContextUtil
 * @since
 */
public final class SpringContextUtil implements ApplicationContextAware {
    /**
     * Spring应用上下文环境
     */
    private static ApplicationContext APPLICATIONCONTEXT;

    private SpringContextUtil() {}

    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境（web工程用此方法加载）
     *
     * @param applicationContext
     *            spring上下文
     * @throws BeansException
     *             BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        setContext(applicationContext);
    }

    /**
     * 设置spring上下文
     *
     * @param context
     *            spring上下文
     */
    public static void setContext(ApplicationContext context) {
        APPLICATIONCONTEXT = context;
    }

    /**
     * 获取spring上下文
     *
     * @return spring上下文
     */
    public static ApplicationContext getApplicationContext() {
        return APPLICATIONCONTEXT;
    }

    /**
     * 获取对象
     *
     * @param name
     *            bean名称
     * @return Object 一个以所给名字注册的bean的实例
     * @throws BeansException
     *             BeansException
     */
    public static Object getBean(String name)
            throws BeansException {
        return APPLICATIONCONTEXT.getBean(name);
    }

    /**
     * 获取类型为requiredType的对象 如果bean不能被类型转换，相应的异常将会被抛出（BeanNotOfRequiredTypeException）
     *
     * @param name
     *            bean注册名
     * @param requiredType
     *            返回对象类型
     * @param <T>
     *            泛型类型
     * @return T 返回requiredType类型对象
     * @throws BeansException BeansException
     */
    public static <T> T getBean(String name, Class<T> requiredType)
            throws BeansException {
        return APPLICATIONCONTEXT.getBean(name, requiredType);
    }

    /**
     * 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
     *
     * @param name
     *            bean名称
     * @return boolean 是否包含此bean
     */
    public static boolean containsBean(String name) {
        return APPLICATIONCONTEXT.containsBean(name);
    }

    /**
     * 判断以给定名字注册的bean定义是一个singleton还是一个prototype。
     * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
     *
     * @param name
     *            bean名称
     * @return boolean 是否为单例
     * @throws NoSuchBeanDefinitionException
     *             NoSuchBeanDefinitionException
     */
    public static boolean isSingleton(String name)
            throws NoSuchBeanDefinitionException {
        return APPLICATIONCONTEXT.isSingleton(name);
    }

    /**
     * 根据类型获取bean的class
     *
     * @param name
     *            类型名称
     * @param <T>
     *            泛型类型
     * @return T 注册对象的类型
     * @throws NoSuchBeanDefinitionException
     *             NoSuchBeanDefinitionException
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getType(String name)
            throws NoSuchBeanDefinitionException {
        return (Class<T>)APPLICATIONCONTEXT.getType(name);
    }

    /**
     * 如果给定的bean名字在bean定义中有别名，则返回这些别名
     *
     * @param name
     *            bean名字
     * @return 别名数组
     * @throws NoSuchBeanDefinitionException
     *             NoSuchBeanDefinitionException
     */
    public static String[] getAliases(String name)
            throws NoSuchBeanDefinitionException {
        return APPLICATIONCONTEXT.getAliases(name);
    }
}