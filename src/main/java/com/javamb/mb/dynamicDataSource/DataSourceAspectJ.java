/*
 * Project: shardDb
 * 
 * File Created at 2017年10月15日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.javamb.mb.dynamicDataSource;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;

import com.javamb.mb.annotation.TargetDataSource;

/**
 * @Type DataSourceAspectJ.java
 * @Desc 
 * <pre>
 * 切面类:动态的把数据源放入ThreadLocal中,告诉Service层,我们使用的是哪个数据源
 * </pre>
 * @author limb
 * @date 2017年10月15日 下午12:17:10
 * @version 
 */
@Order(-1)  //spring.core包 切面的执行顺序, 值越小加载顺序越优先, -1当然是最优先了 
@Aspect //这是一个切面类
public class DataSourceAspectJ {
    
    /**
     * <pre>
     * "@Before" ->切面位置: com.javamb.mb.service包下面的所有类的所有方法的所有参数之前
     * </pre>
     * @param joinPoint 参数,切入点(就是这个:* com.javamb.mb.service..*.*(..)))
     */
    @Before(value = "execution(* com.javamb.mb.service..*.*(..))")
    //advice 这是一个增强或者通知
    public void before(JoinPoint joinPoint) {
        System.out.println("before advice");
        //1.获取目标 -> 被代理类
        Object target = joinPoint.getTarget();
        //获取目标的方法名称
        String targetMethodName = joinPoint.getSignature().getName();
        //2.拿到被代理类的所有接口
        Class<?>[] interfaces = target.getClass().getInterfaces();
        //3.拿被代理类的入参
        MethodSignature methodsignature = (MethodSignature)joinPoint.getSignature();
        Class<?>[] parameterTypes = methodsignature.getMethod().getParameterTypes();
        
        //遍历接口
        for(Class<?> intfzz : interfaces) {
            try {
                Method method = intfzz.getMethod(targetMethodName, parameterTypes);
                
                //如果有方法
                if(method != null){
                    //检查方法是否是注解类的, 如果是, 通过注解的参数 动态选择数据源
                    if(method.isAnnotationPresent(TargetDataSource.class)){
                        //反射得到注解类
                        TargetDataSource dataSource = method.getAnnotation(TargetDataSource.class);
                        HandleDataSource.pubDataSource(dataSource.value());
                    } else {
                        //没有不是, 就使用默认数据源 write写库
                        HandleDataSource.pubDataSource("write"); 
                        //会去spring-mysql-db.xml中找对应的string 来选择数据源
                    }
                }
            } catch (NoSuchMethodException e) {
                //方法不存在异常
                e.printStackTrace();
            } catch (SecurityException e) {
                //权限异常
                e.printStackTrace();
            }
        }
    }

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年10月15日 LMB creat
 */