package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.CollectionUtil;
import org.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * 依赖注入，设置带有Inject注解的变量
 * Created by sihanwang on 2017/8/21.
 */
public final class IocHelper {
    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();

        if (CollectionUtil.isNotEmpty(beanMap)) {
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                Class<?> beanClass = beanEntry.getClass();
                Object beanInstance = beanEntry.getValue();
                Field[] fields = beanClass.getFields();
                if (ArrayUtil.isNotEmpty(fields)) {
                    for (Field beanField : fields) {
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }

            }

        }
    }
}
