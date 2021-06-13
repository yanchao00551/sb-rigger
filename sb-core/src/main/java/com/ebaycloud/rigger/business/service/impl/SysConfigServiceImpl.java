package com.ebaycloud.rigger.business.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.ebaycloud.rigger.business.enums.ConfigKeyEnum;
import com.ebaycloud.rigger.business.service.SysConfigService;
import com.ebaycloud.rigger.persistence.beans.SysConfig;
import com.ebaycloud.rigger.persistence.mapper.SysConfigMapper;
import com.ebaycloud.rigger.util.DateConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName:com.ebaycloud.rigger.business.service.impl
 * @ClassName:SysConfigServiceImpl
 * @Description:
 * @author: 悟空
 * @date: 2021/4/3 15:53
 * @email: 10947@163.com
 */
@Service
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    private SysConfigMapper sysConfigMapper;
    /**
     * 获取系统配置
     * @author 悟空
     * @description //TODO
     * @date 15:55 2021/4/3
     * @param
     * @return java.util.Map<java.lang.String, java.lang.Object>
     */
    @Override
    public Map<String, Object> getConfigs() {
        List<SysConfig> list = sysConfigMapper.selectAll();
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        String updateTimeKey = ConfigKeyEnum.UPDATE_TIME.getKey();
        Map<String,Object> res = new HashMap<>();
        res.put(updateTimeKey, DateUtil.parse("2021-04-03 00:00:00", DateConst.YYYY_MM_DD_HH_MM_SS_EN));
        list.forEach((sysConfig -> {
            res.put(String.valueOf(sysConfig.getConfigKey()),sysConfig.getConfigValue());
            if(sysConfig.getUpdateTime().after((Date) res.get(updateTimeKey))){
                res.put(updateTimeKey,sysConfig.getUpdateTime());
            }
        }));
        return res;
    }


    @Override
    public SysConfig getByKey(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        SysConfig sysConfig = new SysConfig();
        sysConfig.setConfigKey(key);
        return this.sysConfigMapper.selectOne(sysConfig);
    }


    @Override
    public Map<String, Object> getSiteInfo() {
        Map<String, Object> siteInfo = sysConfigMapper.getSiteInfo();
        if (!CollectionUtils.isEmpty(siteInfo)) {
            Date installdate = null;
            SysConfig config = this.getByKey(ConfigKeyEnum.INSTALLDATE.getKey());
            if (null == config || StringUtils.isEmpty(config.getConfigValue())) {
                // 默认建站日期为2019-01-01
                installdate = Date.from(LocalDate.of(2019, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
            } else {
                installdate = DateUtil.parse(config.getConfigValue(), DatePattern.NORM_DATETIME_PATTERN);
            }
            long between = 1;
            if (!installdate.after(new Date())) {
                between = DateUtil.between(installdate, new Date(), DateUnit.DAY);
            }
            siteInfo.put("installdate", between < 1 ? 1 : between);
        }
        return siteInfo;
    }

}
