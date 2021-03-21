package com.ebaycloud.rigger.persistence.beans;

import com.ebaycloud.rigger.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @PackageName:com.ebaycloud.rigger.persistence.beans
 * @ClassName:BizType
 * @Description:
 * @author: 悟空
 * @date: 2021/3/20 21:54
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizTags extends AbstractDO {
    private String name;
    private String description;
}
