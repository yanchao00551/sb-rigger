package com.ebaycloud.rigger.business.service;

import com.ebaycloud.rigger.business.entity.Tags;
import com.ebaycloud.rigger.framework.object.AbstractService;
import com.ebaycloud.rigger.persistence.beans.BizTags;

import java.util.List;

public interface BizTagsService extends AbstractService<Tags,Long> {
    /**
     * 根据文章id查询标签集
     * @author 悟空
     * @description //TODO
     * @date 18:04 2021/6/12
     * @param articleId
     * @return java.util.List<com.ebaycloud.rigger.persistence.beans.BizTags>
     */
    List<BizTags> queryArticleTags(Long articleId);
}
