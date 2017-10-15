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

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Type DynamicDataSource.java
 * @Desc 
 * <pre>
 * 继承org.springframework.jdbc.datasource.lookup的 AbstractRoutingDataSource抽象类,
 * 重写determineCurrentLookupKey方法动态获取数据源
 * 这个方法的作用就是告诉spring我们到底是用哪一个数据源
 * </pre>
 * @author limb
 * @date 2017年10月15日 上午11:53:28
 * @version 
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return HandleDataSource.getDataSource();
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