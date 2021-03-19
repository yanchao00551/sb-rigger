package com.ebaycloud.rigger.plugin;

import com.ebaycloud.rigger.persistence.beans.BaseEntity;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/*
 * @Author 悟空
 * @Description //TODO 公有Mapper
 * @Date 17:04 2021/3/18
 * @Param
 * @return 
 **/

public interface BaseMapper<T extends BaseEntity> extends Mapper<T>, MySqlMapper<T> {
    // 特别注意，该接口不能被扫描到，否则会出错
}
