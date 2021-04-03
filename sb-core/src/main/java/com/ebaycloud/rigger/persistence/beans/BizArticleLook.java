package com.ebaycloud.rigger.persistence.beans;

import com.ebaycloud.rigger.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @PackageName:com.ebaycloud.rigger.persistence.beans
 * @ClassName:BizArticleLook
 * @Description:
 * @author: 悟空
 * @date: 2021/4/3 0:07
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizArticleLook extends AbstractDO {
    private Long articleId;
    private Long userId;
    private String userIp;
    private Date lookTime;
}
