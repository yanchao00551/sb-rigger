package com.ebaycloud.rigger.business.service;

import com.ebaycloud.rigger.business.entity.ArticleLook;
import com.ebaycloud.rigger.framework.object.AbstractService;

/**
 * @PackageName:com.ebaycloud.rigger.business.service
 * @ClassName:BizArticleLook
 * @Description:
 * @author: 悟空
 * @date: 2021/4/3 10:54
 * @email: 10947@163.com
 */
public interface BizArticleLook extends AbstractService<BizArticleLook,Long> {
    /**
     * 插入
     * @author 悟空
     * @description //TODO
     * @date 14:41 2021/4/3
     * @param articleLook
     * @return com.ebaycloud.rigger.business.entity.ArticleLook
     */
    ArticleLook insert(ArticleLook articleLook);
}
