package com.ebaycloud.rigger.business.enums;

/**
 * 配置类枚举
 * @author 悟空
 * @description //TODO
 * @date 16:15 2021/4/3
 * @param null
 * @return null
 */
public enum ConfigKeyEnum {
    /**
     * 系统最后一次更新的日期
     * @author 悟空
     * @description //TODO
     * @date 16:16 2021/4/3
     * @param null
     * @return null
     */
    UPDATE_TIME("updateTime"),
    ;
    private String key;

    ConfigKeyEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
