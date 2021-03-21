package com.ebaycloud.rigger.framework.object;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @PackageName:com.ebaycloud.rigger.framework.object
 * @ClassName:BaseConditionVO //TODO:基础分页视图对象
 * @Description:
 * @author: 悟空
 * @date: 2021/3/20 22:41
 * @email: 10947@163.com
 */
public class BaseConditionVO {

    public final static int DEFAULT_PAGE_SIZE = 10;

    private int pageNumber = 1;
    private int pageSize = 0;
    private int pageStart = 0;

    private String orderField;
    private String orderDirection;
    private String keywords;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    public int getPageSize() {
        return pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;
    }


    public int getPageStart() {
        return pageNumber > 0 ? (pageNumber - 1) * getPageSize() :0;
    }
}
