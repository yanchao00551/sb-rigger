package com.ebaycloud.rigger.framework.config;

import com.ebaycloud.rigger.business.service.SysConfigService;
import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @PackageName:com.ebaycloud.rigger.framework.config
 * @ClassName:FreeMarkerConfig
 * @Description:
 * @author: 悟空
 * @date: 2021/4/3 15:11
 * @email: 10947@163.com
 */
@Component
public class FreeMarkerConfig {
    @Autowired
    protected Configuration configuration;

    @Autowired
    private SysConfigService configService;


    @PostConstruct
    public void setSharedVariable() {
        try{
            configuration.setSharedVariable("config",configService.getConfigs());
        }catch (TemplateModelException e){
            e.printStackTrace();
        }
    }
}
