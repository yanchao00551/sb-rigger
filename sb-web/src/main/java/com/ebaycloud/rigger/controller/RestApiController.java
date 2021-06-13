package com.ebaycloud.rigger.controller;

import com.ebaycloud.rigger.business.entity.Article;
import com.ebaycloud.rigger.business.service.BizArticleService;
import com.ebaycloud.rigger.business.vo.ArticleConditionVO;
import com.ebaycloud.rigger.framework.object.ResponseVO;
import com.ebaycloud.rigger.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName:com.ebaycloud.sbweb.controller
 * @ClassName:RenderController
 * @Description:
 * @author: 悟空
 * @date: 2021/3/18 18:15
 * @email: 10947@163.com
 */

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {

    @Autowired
    private BizArticleService bizArticleService;


    /**
     * 首页
     *
     * @param model
     * @return
     */
    @GetMapping("/testList")
    public ResponseVO home(ArticleConditionVO vo, Model model) {
        PageInfo<Article> pageInfo = bizArticleService.findPageBreakByCondition(vo);
        return ResultUtil.success(pageInfo);
    }



}
