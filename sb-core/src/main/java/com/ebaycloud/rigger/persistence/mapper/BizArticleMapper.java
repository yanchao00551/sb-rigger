package com.ebaycloud.rigger.persistence.mapper;

import com.ebaycloud.rigger.business.vo.ArticleConditionVO;
import com.ebaycloud.rigger.persistence.beans.BizArticle;
import com.ebaycloud.rigger.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
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
     * @Author 悟空
     * @Description //TODO 分页查询，关联查询文章标签、文章类型
     * @Date 23:14 2021/3/20
     * @Param [vo]
     * @return java.util.List<com.ebaycloud.rigger.persistence.beans.BizArticle>
     **/
    List<BizArticle> findPageBreakByCondition(ArticleConditionVO vo);
}
