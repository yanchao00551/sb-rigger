package com.ebaycloud.rigger.persistence.beans;

import com.ebaycloud.rigger.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;
import java.util.List;

/**
 * @PackageName:com.ebaycloud.rigger.persistence.beans
 * @ClassName:BizType
 * @Description:
 * @author: 悟空
 * @date: 2021/3/20 21:57
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizType extends AbstractDO {
    private Long pid;
    private String name;
    private String description;
    private Integer sort;
    private Boolean available;
    private String icon;

    /*
     * @Author 悟空
     * @Description //TODO 父级分类
     * @Date 22:01 2021/3/20
     * @Param
     * @return
     **/

    @Transient
    private BizType parent;

    /*
     * @Author 悟空
     * @Description //TODO 子集分类集合
     * @Date 22:02 2021/3/20
     * @Param
     * @return
     **/

    @Transient
    private List<BizType> nodes;

}
