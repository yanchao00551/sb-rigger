package com.ebaycloud.rigger.controller;

import com.ebaycloud.rigger.business.entity.Article;
import com.ebaycloud.rigger.business.entity.Type;
import com.ebaycloud.rigger.business.enums.ArticleStatusEnum;
import com.ebaycloud.rigger.business.service.BizArticleService;
import com.ebaycloud.rigger.business.service.BizTagsService;
import com.ebaycloud.rigger.business.service.BizTypeService;
import com.ebaycloud.rigger.business.vo.ArticleConditionVO;
import com.ebaycloud.rigger.persistence.beans.BizArticle;
import com.ebaycloud.rigger.persistence.beans.BizTags;
import com.ebaycloud.rigger.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @PackageName:com.ebaycloud.rigger.controller
 * @ClassName:RenderController
 * @Description:
 * @author: 悟空
 * @date: 2021/3/26 20:35
 * @email: 10947@163.com
 */
@Controller
public class RenderController {
    private static final String INDEX_URL = "index";

    @Autowired
    private BizArticleService bizArticleService;
    @Autowired
    private BizTagsService bizTagsService;
    @Autowired
    private BizTypeService bizTypeService;

    private void loadIndexPage(ArticleConditionVO vo, Model model) {
        vo.setStatus(ArticleStatusEnum.PUBLISHED.getCode());
        PageInfo<Article> pageInfo = bizArticleService.findPageBreakByCondition(vo);
        model.addAttribute("page", pageInfo);
        model.addAttribute("model", vo);
    }

    @RequestMapping("/")
    public ModelAndView home(ArticleConditionVO vo, Model model) {
        model.addAttribute("url", INDEX_URL);
        loadIndexPage(vo, model);
        return ResultUtil.view(INDEX_URL);
    }


    /**
     * 首页（分页）
     *
     * @param pageNumber
     * @param vo
     * @param model
     * @return
     */
    @RequestMapping("/index/{pageNumber}")
    public ModelAndView type(@PathVariable("pageNumber") Integer pageNumber, ArticleConditionVO vo, Model model) {
        vo.setPageNumber(pageNumber);
        model.addAttribute("url", INDEX_URL);
        loadIndexPage(vo, model);
        return ResultUtil.view(INDEX_URL);
    }


    /**
     * 文章详情
     *
     * @param model
     * @param articleId
     * @return
     */
    @GetMapping("/article/{articleId}")
    public ModelAndView article(Model model, @PathVariable("articleId") Long articleId) {
        Article article = bizArticleService.getByPrimaryKey(articleId);
        if (article == null || ArticleStatusEnum.UNPUBLISHED.getCode() == article.getStatusEnum().getCode()) {
            return ResultUtil.forward("/error/404");
        }
        //TODO:查询文章标签
        List<BizTags> tags = bizTagsService.queryArticleTags(articleId);
        article.setTags(tags);
        model.addAttribute("article", article);
        model.addAttribute("articleDetail", true);
        return ResultUtil.view("article");
    }


    /**
     * 获取所有分类和文章
     * @author 悟空
     * @description //TODO
     * @date 18:57 2021/6/12
     * @param model
     * @return org.springframework.web.servlet.ModelAndView
     */
    @GetMapping("/categories")
    public ModelAndView categories(Model model){
        List<Type> types = bizTypeService.listAll();
        types.forEach((value) -> {
            List<BizArticle> list = bizArticleService.findTypeArticleList(value.getId());
            value.setBizArticles(list);
        });
        model.addAttribute("types",types);
        model.addAttribute("url","Categories");
        return ResultUtil.view("categories");
    }

    /**
     * 链接
     * @author 悟空
     * @description //TODO
     * @date 20:47 2021/6/12
     * @param model
     * @return org.springframework.web.servlet.ModelAndView
     */
    @GetMapping("/links")
    public ModelAndView links(Model model){
        model.addAttribute("url","Links");
        return ResultUtil.view("links");
    }

    /**
     * 关于
     * @author 悟空
     * @description //TODO
     * @date 21:02 2021/6/12
     * @param model
     * @return org.springframework.web.servlet.ModelAndView
     */
    @GetMapping("/about")
    public ModelAndView about(Model model){
        model.addAttribute("url","About");
        return ResultUtil.view("about");
    }


    /**
     * 标签列表
     *
     * @param tagId
     * @param model
     * @return
     */
    @GetMapping("/tag/{tagId}")
    public ModelAndView tag(@PathVariable("tagId") Long tagId, Model model) {
        ArticleConditionVO vo = new ArticleConditionVO();
        vo.setTagId(tagId);
        model.addAttribute("url", "tag/" + tagId);
        loadIndexPage(vo, model);

        return ResultUtil.view(INDEX_URL);
    }


}
