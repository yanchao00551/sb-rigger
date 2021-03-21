package com.ebaycloud.rigger.business.service;

import com.ebaycloud.rigger.business.entity.Article;
import com.ebaycloud.rigger.business.vo.ArticleConditionVO;
import com.ebaycloud.rigger.framework.object.AbstractService;
import com.github.pagehelper.PageInfo;

/**
 * @PackageName:com.ebaycloud.sbcore.business.service
 * @ClassName:UserService
 * @Description:
 * @author: 悟空
 * @date: 2021/3/18 19:46
 * @email: 10947@163.com
 */
public interface BizArticleService extends AbstractService<Article,Long> {
    PageInfo<Article> findPageBreakByCondition(ArticleConditionVO vo);
}
