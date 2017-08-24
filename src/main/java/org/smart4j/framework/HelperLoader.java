package org.smart4j.framework;

import org.smart4j.framework.helper.*;
import org.smart4j.framework.util.ClassUtil;

/**
 * 初始化所需要的类
 * Created by sihanwang on 2017/8/21.
 */
public final class HelperLoader {
    public static void init() {
        Class<?>[] classList = {
                //获取所有带有service和controller注解的类
                ClassHelper.class,
                //AOP框架
                AopHelper.class,
                //实例化类
                BeanHelper.class,
                //依赖注入，实例化注解类
                IocHelper.class,
                //获取Action里的请求方式和路径，并建立request与handler的映射关系
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            //加载类
            ClassUtil.loadClass(cls.getName());
        }
    }
}
