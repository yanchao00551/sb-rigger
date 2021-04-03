package com.ebaycloud.rigger.framework.object;

import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 基础分页视图对象
 * @PackageName:com.ebaycloud.rigger.framework.object
 * @ClassName:BaseConditionVO //TODO:基础分页视图对象
 * @Description:
 * @author: 悟空
 * @date: 2021/3/20 22:41
 * @email: 10947@163.com
 */
@ToString
public class BaseConditionVO {

    public final static int DEFAULT_PAGE_SIZE = 10;

    private Integer pageNumber;
    private Integer pageSize;
    private Integer pageStart;

    private String orderField;
    private String orderDirection;
    private String keywords;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    public int getPageSize() {
        if(pageSize == null){
            pageSize = 0;
        }
        return pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;
    }


    public int getPageStart() {
        if(pageNumber == null){
            pageNumber = 1;
        }
        return pageNumber > 0 ? (pageNumber - 1) * getPageSize() :0;
    }
}
