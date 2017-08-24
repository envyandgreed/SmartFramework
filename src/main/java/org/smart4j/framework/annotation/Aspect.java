package org.smart4j.framework.annotation;

import java.lang.annotation.*;

/**
 * Created by sihanwang on 2017/8/24.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    /**
     * 注解
     */
    Class<? extends Annotation> value();
}
