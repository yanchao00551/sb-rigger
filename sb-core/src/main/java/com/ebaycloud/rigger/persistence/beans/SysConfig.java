package com.ebaycloud.rigger.persistence.beans;

import com.ebaycloud.rigger.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author 悟空
 * @description //TODO 
 * @date 15:57 2021/4/3
  * @param null
  * @return null
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysConfig extends AbstractDO {
    private String configKey;
    private String configValue;
}