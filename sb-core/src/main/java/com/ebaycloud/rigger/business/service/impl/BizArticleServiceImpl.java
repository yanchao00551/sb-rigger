package com.ebaycloud.rigger.business.service.impl;

import com.ebaycloud.rigger.business.entity.Article;
import com.ebaycloud.rigger.business.enums.CommentStatusEnum;
import com.ebaycloud.rigger.business.service.BizArticleService;
import com.ebaycloud.rigger.business.vo.ArticleConditionVO;
import com.ebaycloud.rigger.persistence.beans.BizArticle;
import com.ebaycloud.rigger.persistence.beans.BizArticleLook;
import com.ebaycloud.rigger.persistence.beans.BizComment;
import com.ebaycloud.rigger.persistence.mapper.BizArticleLookMapper;
import com.ebaycloud.rigger.persistence.mapper.BizArticleMapper;
import com.ebaycloud.rigger.persistence.mapper.BizCommentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    @Autowired
    private BizArticleLookMapper bizArticleLookMapper;
    @Autowired
    private BizCommentMapper commentMapper;


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
        PageHelper.startPage(vo.getPageStart(), vo.getPageSize());
        List<BizArticle> list = bizArticleMapper.findPageBreakByCondition(vo);
        //CollectionUtils是Spring框架提供的工具类
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        List<Long> ids = list.stream().map(BizArticle::getId).collect(Collectors.toList());
        List<BizArticle> listTag = bizArticleMapper.listTagsByArticleId(ids);
        Map<Long, BizArticle> tagMap = listTag.stream().collect(Collectors.toMap(BizArticle::getId, a -> a, (k1, k2) -> k1));

        List<Article> boList = new LinkedList<>();
        for (BizArticle bizArticle : list) {
            BizArticle tagArticle = tagMap.get(bizArticle.getId());
            if (tagArticle == null) {
                log.warn("文章[{}] 未绑定标签信息，或者已绑定的标签不存在!", bizArticle.getTitle());
            } else {
                bizArticle.setTags(tagArticle.getTags());
            }
            this.subquery(bizArticle);
            boList.add(new Article(bizArticle));
        }
        //指定返回的分页数据格式
        PageInfo bean = new PageInfo<BizArticle>(list);

        //设置最终结果集合，程序会调用Article的getter方法映射到BizArticle的属性中去
        bean.setList(boList);

        return bean;
    }

    private void subquery(BizArticle entity) {
        Long primaryKey = entity.getId();
        //TODO:查看的次数
        BizArticleLook look = new BizArticleLook();
        look.setArticleId(primaryKey);
        entity.setLookCount(bizArticleLookMapper.selectCount(look));
        //TODO:评论数
        Example example = new Example(BizComment.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sid",primaryKey);
        criteria.andEqualTo("status", CommentStatusEnum.APPROVED.toString());
        entity.setCommentCount(commentMapper.selectCountByExample(example));
    }


}
