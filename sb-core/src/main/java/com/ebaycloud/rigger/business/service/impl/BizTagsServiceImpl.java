package com.ebaycloud.rigger.business.service.impl;

import com.ebaycloud.rigger.business.entity.Tags;
import com.ebaycloud.rigger.business.service.BizTagsService;
import com.ebaycloud.rigger.persistence.beans.BizTags;
import com.ebaycloud.rigger.persistence.mapper.BizTagsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 标签
 * @PackageName:com.ebaycloud.rigger.business.service.impl
 * @ClassName:BizTagsServiceImpl
 * @Description:
 * @author: 悟空
 * @date: 2021/6/12 12:38
 * @email: 10947@163.com
 */
@Service
public class BizTagsServiceImpl implements BizTagsService {
    @Autowired
    private BizTagsMapper bizTagsMapper;



    @Override
    public Tags insert(Tags entity) {
        return null;
    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean updateSelective(Tags entity) {
        return false;
    }

    @Override
    public Tags getByPrimaryKey(Long primaryKey) {
        return null;
    }

    @Override
    public List<Tags> listAll() {
        List<BizTags> entityList = bizTagsMapper.selectAll();
        return getTags(entityList);
    }

    private List<Tags> getTags(List<BizTags> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return null;
        }
        List<Tags> list = new ArrayList<>();
        for (BizTags entity : entityList) {
            list.add(new Tags(entity));
        }
        return list;
    }

    @Override
    public List<BizTags> queryArticleTags(Long articleId) {
        return bizTagsMapper.selectArticleTags(articleId);
    }
}
