package com.ebaycloud.rigger.framework.object;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @PackageName:com.ebaycloud.sbcore.framework.object
 * @ClassName:PageResult
 * @Description: //TODO: bootstrap table用到的返回json格式
 * @author: 悟空
 * @date: 2021/3/18 18:28
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PageResult {
    private Long total;
    private List rows;

    public PageResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }
}
