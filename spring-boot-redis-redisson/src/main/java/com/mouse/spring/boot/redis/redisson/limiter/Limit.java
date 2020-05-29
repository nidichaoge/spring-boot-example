package com.mouse.spring.boot.redis.redisson.limiter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/11
 * @description
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Limit {

    String name() default "";

    String key() default "";

    int period() default 60;

    int count() default 100;

    LimitType limitType() default LimitType.AK;

}
