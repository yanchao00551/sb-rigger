package com.ebaycloud.rigger.business.service;

import com.ebaycloud.rigger.business.entity.Article;
import com.ebaycloud.rigger.business.vo.ArticleConditionVO;
import com.ebaycloud.rigger.framework.object.AbstractService;
import com.ebaycloud.rigger.persistence.beans.BizArticle;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @PackageName:com.ebaycloud.sbcore.business.service
 * @ClassName:UserService
 * @Description:
 * @author: 悟空
 * @date: 2021/3/18 19:46
 * @email: 10947@163.com
 */
public interface BizArticleService extends AbstractService<Article,Long> {
    /**
     * 分页查询
     * @author 悟空
     * @description //TODO 
     * @date 23:17 2021/4/2
     * @param vo
     * @return com.github.pagehelper.PageInfo<com.ebaycloud.rigger.business.entity.Article>
     */
    PageInfo<Article> findPageBreakByCondition(ArticleConditionVO vo);


    /**
     * 近期文章
     *
     * @param pageSize
     * @return
     */
    List<Article> listRecent(int pageSize);


    /**
     * 站长推荐
     *
     * @param pageSize
     * @return
     */
    List<Article> listRecommended(int pageSize);


    /**
     * 随机文章
     *
     * @param pageSize
     * @return
     */
    List<Article> listRandom(int pageSize);


    /**
     * 获取热门文章
     *
     * @return
     */
    List<Article> listHotArticle(int pageSize);

    /**
     * 获取分类下所有文章
     * @author 悟空
     * @description //TODO
     * @date 19:20 2021/6/12
     * @param id
     * @return java.util.List<com.ebaycloud.rigger.persistence.beans.BizArticle>
     */
    List<BizArticle> findTypeArticleList(Long typeId);
}
