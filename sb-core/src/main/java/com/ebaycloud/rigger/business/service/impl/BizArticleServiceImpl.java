package com.ebaycloud.rigger.business.service.impl;

import com.ebaycloud.rigger.business.entity.Article;
import com.ebaycloud.rigger.business.enums.ArticleStatusEnum;
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

import java.util.ArrayList;
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
        return new Article(bizArticleMapper.selectByPrimaryKey(primaryKey));
    }


    @Override
    public PageInfo<Article> findPageBreakByCondition(ArticleConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        Integer i = vo.getPageStart();
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


    /**
     * 站长推荐
     *
     * @param pageSize
     * @return
     */
    @Override
    public List<Article> listRecommended(int pageSize) {
        ArticleConditionVO vo = new ArticleConditionVO();
        vo.setRecommended(true);
        vo.setStatus(ArticleStatusEnum.PUBLISHED.getCode());
        vo.setPageSize(pageSize);
        PageInfo pageInfo = this.findPageBreakByCondition(vo);
        return null == pageInfo ? null : pageInfo.getList();
    }

    /**
     * 近期文章
     *
     * @param pageSize
     * @return
     */
    @Override
    public List<Article> listRecent(int pageSize) {
        ArticleConditionVO vo = new ArticleConditionVO();
        vo.setPageSize(pageSize);
        vo.setStatus(ArticleStatusEnum.PUBLISHED.getCode());
        PageInfo pageInfo = this.findPageBreakByCondition(vo);
        return null == pageInfo ? null : pageInfo.getList();
    }


    /**
     * 随机文章
     *
     * @param pageSize
     * @return
     */
    @Override
    public List<Article> listRandom(int pageSize) {
        ArticleConditionVO vo = new ArticleConditionVO();
        vo.setRandom(true);
        vo.setStatus(ArticleStatusEnum.PUBLISHED.getCode());
        vo.setPageSize(pageSize);
        PageInfo pageInfo = this.findPageBreakByCondition(vo);
        return null == pageInfo ? null : pageInfo.getList();
    }

    /**
     * 获取热门文章
     *
     * @return
     */
    @Override
    public List<Article> listHotArticle(int pageSize) {
        PageHelper.startPage(1, pageSize);

        List<BizArticle> entityList = bizArticleMapper.listHotArticle();
        if (CollectionUtils.isEmpty(entityList)) {
            return null;
        }
        List<Article> list = new ArrayList<>();
        for (BizArticle entity : entityList) {
            list.add(new Article(entity));
        }
        return list;
    }

    /**
     * 获取分类下所有文章
     * @author 悟空
     * @description //TODO
     * @date 19:21 2021/6/12
     * @param typeId
     * @return java.util.List<com.ebaycloud.rigger.persistence.beans.BizArticle>
     */
    @Override
    public List<BizArticle> findTypeArticleList(Long typeId) {
        Example example = new Example(BizArticle.class);
        example.createCriteria().andEqualTo("typeId",typeId);
        List<BizArticle> list = bizArticleMapper.selectByExample(example);
        return list;
    }


}
