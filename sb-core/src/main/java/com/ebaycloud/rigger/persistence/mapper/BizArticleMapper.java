package com.ebaycloud.rigger.persistence.mapper;

import com.ebaycloud.rigger.business.vo.ArticleConditionVO;
import com.ebaycloud.rigger.persistence.beans.BizArticle;
import com.ebaycloud.rigger.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文章mapper
 * @PackageName:com.ebaycloud.rigger.persistence.mapper
 * @ClassName:BizArticleMapper
 * @Description:
 * @author: 悟空
 * @date: 2021/3/20 23:12
 * @email: 10947@163.com
 */
@Repository
public interface BizArticleMapper extends BaseMapper<BizArticle> {

    /**
     * 分页查询，关联查询文章标签、文章类型
     * @author 悟空
     * @description //TODO
     * @date 23:16 2021/4/2
     * @param vo
     * @return java.util.List<com.ebaycloud.rigger.persistence.beans.BizArticle>
     */
    List<BizArticle> findPageBreakByCondition(ArticleConditionVO vo);

    /**
     * 统计指定文章的标签集合
     * @author 悟空
     * @description //TODO
     * @date 23:17 2021/4/2
     * @param list
     * @return java.util.List<com.ebaycloud.rigger.persistence.beans.BizArticle>
     */
    List<BizArticle> listTagsByArticleId(List<Long> list);

    /**
     * 获取热门文章
     *
     * @return
     */
    List<BizArticle> listHotArticle();
}
