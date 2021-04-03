package com.ebaycloud.rigger.business.vo;

import com.ebaycloud.rigger.framework.object.BaseConditionVO;
import com.ebaycloud.rigger.persistence.beans.BizArticleLook;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @PackageName:com.ebaycloud.rigger.business.vo
 * @ClassName:ArticleLookVO
 * @Description:
 * @author: 悟空
 * @date: 2021/4/3 0:13
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ArticleLookVO extends BaseConditionVO {
    private BizArticleLook bizArticleLook;

}
