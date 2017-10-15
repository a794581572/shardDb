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

/**
 * @Type HandleDataSource.java
 * @Desc 
 * <pre>
 * 使用注解TargetDataSource("str") str参数作为方法名, 反射得到数据源
 * </pre> 
 * @author limb
 * @date 2017年10月15日 上午11:54:32
 * @version 
 */
public class HandleDataSource {

    public static final ThreadLocal<String> holder = new ThreadLocal<String>();
    
    /**
     * 通过注解TargetDataSource("str") 把str当参数,放入ThreadLocal中,就是当前请求的数据源
     * @param dataSource 参数,数据源
     * <pre>参数哪里来, service层加载切面(切面的功能就是通过反射得到我们自己写
     * 的注解里面的value,就是参数,就是我们选择的数据源)</pre>
     */
    public static void pubDataSource(String dataSource) {
        System.out.println("dataSource : " + dataSource);
        holder.set(dataSource);
    }
    
    /**
     * 从ThreadLocal里面得到当前数据源
     * @return String 返回类型
     */
    public static String getDataSource() {
        return holder.get();
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