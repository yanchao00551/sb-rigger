package com.ebaycloud.rigger.persistence.mapper;

import com.ebaycloud.rigger.business.vo.TagsConditionVO;
import com.ebaycloud.rigger.persistence.beans.BizTags;
import com.ebaycloud.rigger.plugin.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @website https://docs.zhyd.me
 * @version 1.0
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Repository
public interface BizTagsMapper extends BaseMapper<BizTags> {

    /**
     * 分页查询
     * @param vo
     *
     * @return
     */
    List<BizTags> findPageBreakByCondition(TagsConditionVO vo);

    /**
     * 根据文章id查询标签
     * @author 悟空
     * @description //TODO
     * @date 18:06 2021/6/12
     * @param articleId
     * @return java.util.List<com.ebaycloud.rigger.persistence.beans.BizTags>
     */
    List<BizTags> selectArticleTags(@Param("articleId") Long articleId);
}
