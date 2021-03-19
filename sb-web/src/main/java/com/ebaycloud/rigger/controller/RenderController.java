package com.ebaycloud.rigger.controller;

import com.ebaycloud.rigger.business.service.UserService;
import com.ebaycloud.rigger.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName:com.ebaycloud.sbweb.controller
 * @ClassName:RenderController
 * @Description:
 * @author: 悟空
 * @date: 2021/3/18 18:15
 * @email: 10947@163.com
 */
@Controller
public class RenderController{

    @Autowired
    private UserService userService;


    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping("/")
    public ModelAndView home(Model model) {
        Map<String,Object> map = new HashMap<>();
        map.put("v",userService.printStr());
        return ResultUtil.view("index",map);
    }


}
