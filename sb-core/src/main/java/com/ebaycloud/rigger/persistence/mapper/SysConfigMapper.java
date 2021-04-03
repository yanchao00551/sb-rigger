package com.ebaycloud.rigger.persistence.mapper;


import com.ebaycloud.rigger.persistence.beans.SysConfig;
import com.ebaycloud.rigger.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 *
 * @author 悟空
 * @description //TODO 
 * @date 15:45 2021/4/3
 * @param null
 * @return null
 */
@Repository
public interface SysConfigMapper extends BaseMapper<SysConfig> {
    /**
     * 获取站点信息
     * @author 悟空
     * @description //TODO
     * @date 15:50 2021/4/3
     * @param
     * @return java.util.Map<java.lang.String, java.lang.Object>
     */
    Map<String,Object> getSiteInfo();
}