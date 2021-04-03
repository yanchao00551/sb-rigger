package com.ebaycloud.rigger.plugin;

import com.ebaycloud.rigger.framework.object.AbstractDO;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 *
 * @author 悟空
 * @description //TODO 
 * @date 23:18 2021/4/2
 * @param null
 * @return null
 */
public interface BaseMapper<T extends AbstractDO> extends Mapper<T>, MySqlMapper<T> {
    // 特别注意，该接口不能被扫描到，否则会出错
}
