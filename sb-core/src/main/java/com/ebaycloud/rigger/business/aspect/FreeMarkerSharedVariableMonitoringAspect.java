package com.ebaycloud.rigger.business.aspect;

import com.ebaycloud.rigger.business.enums.ConfigKeyEnum;
import com.ebaycloud.rigger.business.service.SysConfigService;
import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * 用于监控freemarker自定义标签中共享变量是否发生变化，发生变化时实时更新到内存中
 * @PackageName:com.ebaycloud.rigger.business.aspect
 * @ClassName:FreeMarkerSharedVariableMonitoringAspect
 * @Description:
 * @author: 悟空
 * @date: 2021/4/3 17:09
 * @email: 10947@163.com
 */
@Aspect
@Component
@Slf4j
@Order(1)
public class FreeMarkerSharedVariableMonitoringAspect {
    private static volatile long configLastUpdateTime = 0L;

    @Autowired
    protected Configuration configuration;
    @Autowired
    SysConfigService configService;


    /**
     * 切面切入点
     * @author 悟空
     * @description //TODO
     * @date 17:12 2021/4/3
     * @param
     */
    @Pointcut(value = "@annotation(org.springframework.web.bind.annotation.GetMapping)" +
    "|| @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void pointCut(){
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint){
        Map config = configService.getConfigs();
        if(null == config){
            log.error("config为空");
            return;
        }
        Long updateTime = ((Date)config.get(ConfigKeyEnum.UPDATE_TIME.getKey())).getTime();
        if(updateTime == configLastUpdateTime){
            log.info("config表未更新");
            return;
        }
        log.info("config表已更新,重新加载config到shared variable");
        configLastUpdateTime = updateTime;
        try{
            configuration.setSharedVariable("config",config);
        }catch (TemplateModelException e){
            e.printStackTrace();
        }
    }

}
