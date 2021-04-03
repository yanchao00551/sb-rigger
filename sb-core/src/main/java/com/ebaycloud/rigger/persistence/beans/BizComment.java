package com.ebaycloud.rigger.persistence.beans;

import com.ebaycloud.rigger.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;

/**
 * @PackageName:com.ebaycloud.rigger.persistence.beans
 * @ClassName:BizComment
 * @Description:
 * @author: 悟空
 * @date: 2021/4/3 12:01
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizComment extends AbstractDO {
    @Transient
    private BizComment parent;
    @Transient
    private BizArticle article;

    private Long sid;

    private Long userId;

    private Long pid;

    private String qq;

    private String nickname;

    private String avatar;

    private String email;

    private String url;

    private String status;

    private String ip;

    private String lng;

    private String lat;

    private String address;

    private String os;

    private String osShortName;

    private String browser;

    private String browserShortName;

    private String content;

    private String remark;

    private Integer support;

    private Integer oppose;


}
