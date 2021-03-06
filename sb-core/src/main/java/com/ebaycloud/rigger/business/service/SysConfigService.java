package com.ebaycloud.rigger.business.service;

import com.ebaycloud.rigger.persistence.beans.SysConfig;

import java.util.Map;

/**
 * 系统配置业务类
 * @author 悟空
 * @description //TODO 
 * @date 15:38 2021/4/3
 * @param null
 * @return null
 */
public interface SysConfigService {

    /**
     * 获取系统配置
     * @author 悟空
     * @description //TODO
     * @date 15:40 2021/4/3
     * @param
     * @return java.util.Map<java.lang.String, java.lang.Object>
     */
    Map<String,Object> getConfigs();


    /**
     * 获取网站详情
     */
    Map<String, Object> getSiteInfo();

    /**
     * 获取单个配置
     *
     * @param key key
     */
    SysConfig getByKey(String key);
}
