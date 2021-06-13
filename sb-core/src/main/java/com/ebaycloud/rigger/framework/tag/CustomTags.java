package com.ebaycloud.rigger.framework.tag;


import com.ebaycloud.rigger.business.service.BizTagsService;
import com.ebaycloud.rigger.business.service.SysConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.NumberUtils;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Random;

/**
 * 自定义的freemarker标签
 * 调整实现，所有自定义标签只需继承BaseTag后通过构造函数将自定义标签类的className传递给父类即可。
 * 增加标签时，只需要添加相关的方法即可，默认自定义标签的method就是自定义方法的函数名。
 */
@Slf4j
@Component
public class CustomTags extends BaseTag {

    private final Random randoms = new Random();
    private final DecimalFormat df = new DecimalFormat("#.##");

    @Autowired
    private BizTagsService bizTagsService;
    @Autowired
    private SysConfigService configService;

    public CustomTags() {
        super(CustomTags.class.getName());
    }

    public Object tagsList(Map params) {
        return bizTagsService.listAll();
    }

    public Object random(Map params) {
        int max = NumberUtils.parseNumber(getParam(params, "max"), Integer.class);
        int min = NumberUtils.parseNumber(getParam(params, "min"), Integer.class);
        return df.format(randoms.nextInt(max) % (max - min + 1) + min + Math.random());
    }

    public Object color(Map params){
        int[] c = new int[]{666,777,888,999};
        int i = randoms.nextInt(3);

        return c[randoms.nextInt(3)];
    }

    public Object siteInfo(Map params) {
        return configService.getSiteInfo();
    }

}
