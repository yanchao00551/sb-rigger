package com.ebaycloud.rigger.business.service.impl;

import com.ebaycloud.rigger.business.entity.Article;
import com.ebaycloud.rigger.business.service.BizArticleService;
import com.ebaycloud.rigger.business.vo.ArticleConditionVO;
import com.ebaycloud.rigger.persistence.beans.BizArticle;
import com.ebaycloud.rigger.persistence.mapper.BizArticleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @PackageName:com.ebaycloud.sbcore.business.service.impl
 * @ClassName:UserServiceImpl
 * @Description:
 * @author: 悟空
 * @date: 2021/3/18 19:58
 * @email: 10947@163.com
 */

@Slf4j
@Service
public class BizArticleServiceImpl implements BizArticleService {

    @Autowired
    private BizArticleMapper bizArticleMapper;


    @Override
    public Article insert(Article entity) {
        return null;
    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean updateSelective(Article entity) {
        return false;
    }

    @Override
    public Article getByPrimaryKey(Long primaryKey) {
        return null;
    }


    @Override
    public PageInfo<Article> findPageBreakByCondition(ArticleConditionVO vo) {
        PageHelper.startPage(vo.getPageStart(),vo.getPageSize());
        List<BizArticle> list = bizArticleMapper.findPageBreakByCondition(vo);
        List<Article> boList = new LinkedList<>();
        for(BizArticle bizArticle:list){
            boList.add(new Article(bizArticle));
        }
        PageInfo bean = new PageInfo<BizArticle>(list);//指定返回的分页数据格式

        bean.setList(boList);  //设置最终结果集合，程序会调用Article的getter方法映射到BizArticle的属性中去

        return bean;
    }






}
