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
package com.javamb.mb.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Type TargetDataSource.java
 * @Desc <pre>
 *  动态数据源注解
 *  2个值 读read 写write
 *  </pre>
 * @author limb
 * @date 2017年10月15日 上午11:45:10
 * @version 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TargetDataSource {
    String value() default "";
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年10月15日 LMB creat
 */