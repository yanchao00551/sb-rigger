package com.ebaycloud.rigger.persistence.beans;

import com.ebaycloud.rigger.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;
import java.util.List;

/**
 * 每行实体的javabean，如果存在相关依赖关系，增加其他javabean作为属性
 * @PackageName:com.ebaycloud.rigger.persistence.beans
 * @ClassName:BizArticle
 * @Description:
 * @author: 悟空
 * @date: 2021/3/20 21:46
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizArticle extends AbstractDO {

    @Transient
    List<BizTags> tags;
    @Transient
    BizType bizType;

    private String title;
    private Long userId;
    private String coverImage;
    private String qrcodePath;
    private Boolean isMarkdown;
    private String content;
    private String contentMd;
    private Boolean top;
    private Long typeId;
    private Boolean status;
    private Boolean recommended;
    private Boolean original;
    private String description;
    private String keywords;
    private Boolean comment;

    @Transient
    private Integer lookCount;
    @Transient
    private  Integer commentCount;

}
