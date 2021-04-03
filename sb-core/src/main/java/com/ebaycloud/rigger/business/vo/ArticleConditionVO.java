package com.ebaycloud.rigger.business.vo;

import com.ebaycloud.rigger.business.entity.Article;
import com.ebaycloud.rigger.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章条件视图
 * @PackageName:com.ebaycloud.rigger.business.vo
 * @ClassName:ArticleConditionVO
 * @Description:
 * @author: 悟空
 * @date: 2021/3/20 22:40
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ArticleConditionVO extends BaseConditionVO {
    private Article article;
    private Long typeId;
    private Integer status;



}
