package com.ebaycloud.rigger.controller;

import com.ebaycloud.rigger.business.entity.Article;
import com.ebaycloud.rigger.business.enums.ArticleStatusEnum;
import com.ebaycloud.rigger.business.service.BizArticleService;
import com.ebaycloud.rigger.business.vo.ArticleConditionVO;
import com.ebaycloud.rigger.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

}
