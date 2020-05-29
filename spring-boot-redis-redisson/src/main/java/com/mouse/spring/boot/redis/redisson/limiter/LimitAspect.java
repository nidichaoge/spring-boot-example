package com.mouse.spring.boot.redis.redisson.limiter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/11
 * @description
 */
@Aspect
@Component
public class LimitAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LimitAspect.class);

    @Resource
    private AkLimiter akLimiter;

    @Pointcut(value = "@annotation(com.mouse.spring.boot.redis.redisson.limiter.Limit)")
    public void pointcut(){}


    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
         HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();

        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        Limit annotation = method.getAnnotation(Limit.class);
        LimitType limitType = annotation.limitType();
        String name = annotation.name();
        int period = annotation.period();
        int count = annotation.count();

        String redisKey;
        // todo redis的key怎么来 对于ak 对于ip
        switch (limitType){
            case IP:
                //对于ip 从request请求里面拿到ip地址
                String ipAddr = IpUtils.getIpAddr(request);
                redisKey = "mouse:"+ipAddr;
                break;
            case AK:
                //对于ak 需要在登陆拦截器执行后 获取ak
                String key = annotation.key();
                redisKey = "mouse"+key;
                break;
            default:
                throw new RuntimeException();
        }

        boolean process = akLimiter.limit(redisKey,period,count);
        if (process){

            return point.proceed();
        } else {
            throw new LimiterException("Can not get token");
        }
    }

}
