package com.ebaycloud.rigger.framework.tag;

import com.ebaycloud.rigger.business.entity.Article;
import com.ebaycloud.rigger.business.enums.ArticleStatusEnum;
import com.ebaycloud.rigger.business.service.BizArticleService;
import com.ebaycloud.rigger.business.vo.ArticleConditionVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * 文章相关的自定义标签
 */
@Component
public class ArticleTags extends BaseTag {

    @Autowired
    private BizArticleService articleService;

    public ArticleTags() {
        super(ArticleTags.class.getName());
    }

    public Object recentArticles(Map params) {
        int pageSize = this.getPageSize(params);
        return articleService.listRecent(pageSize);
    }

    public Object recommendedList(Map params) {
        int pageSize = this.getPageSize(params);
        return articleService.listRecommended(pageSize);
    }

    public Object randomList(Map params) {
        int pageSize = this.getPageSize(params);
        return articleService.listRandom(pageSize);
    }

    public Object hotList(Map params) {
        int pageSize = this.getPageSize(params);
        return articleService.listHotArticle(pageSize);
    }

    public Object typeList(Map params) {
        int pageSize = this.getPageSize(params);
        long typeId = -1;
        String typeStr = getParam(params, "typeId");
        if (!StringUtils.isEmpty(typeStr)) {
            typeId = Long.parseLong(typeStr);
        }
        // 按文章分类查询
        ArticleConditionVO vo = new ArticleConditionVO();
        vo.setTypeId(typeId);
        // 已发布状态
        vo.setStatus(ArticleStatusEnum.PUBLISHED.getCode());
        vo.setPageSize(pageSize);
        PageInfo<Article> pageInfo = articleService.findPageBreakByCondition(vo);
        return null == pageInfo ? null : pageInfo.getList();
    }
}
