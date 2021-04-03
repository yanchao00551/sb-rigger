package com.ebaycloud.rigger.business.entity;

import com.ebaycloud.rigger.persistence.beans.BizArticleLook;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @PackageName:com.ebaycloud.rigger.business.entity
 * @ClassName:ArticleLook
 * @Description:
 * @author: 悟空
 * @date: 2021/4/3 0:15
 * @email: 10947@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ArticleLook implements Serializable {
    private static final long serialVersionUID = -6801027795658245923L;

    private BizArticleLook bizArticleLook;

    public ArticleLook() {
        this.bizArticleLook = new BizArticleLook();
    }

    public ArticleLook(BizArticleLook bizArticleLook) {
        this.bizArticleLook = bizArticleLook;
    }

    @JsonIgnore
    public BizArticleLook getBizArticleLook() {
        return bizArticleLook;
    }

    public Long getArticleId() {
        return bizArticleLook.getArticleId();
    }

    public Long getUserId() {
        return bizArticleLook.getUserId();
    }

    public String getUserIp() {
        return bizArticleLook.getUserIp();
    }

    public Date getLookTime() {
        return bizArticleLook.getLookTime();
    }

    public void setArticleId(Long articleId) {
        bizArticleLook.setArticleId(articleId);
    }

    public void setUserId(Long userId) {
        bizArticleLook.setUserId(userId);
    }

    public void setUserIp(String userIp) {
        bizArticleLook.setUserIp(userIp);
    }

    public void setLookTime(Date lookTime) {
        bizArticleLook.setLookTime(lookTime);
    }

    public void setId(Long id) {
        bizArticleLook.setId(id);
    }

    public void setUpdateTime(Date updateTime) {
        bizArticleLook.setUpdateTime(updateTime);
    }

    public Long getId() {
        return bizArticleLook.getId();
    }

    public void setCreateTime(Date createTime) {
        bizArticleLook.setCreateTime(createTime);
    }

    public Date getCreateTime() {
        return bizArticleLook.getCreateTime();
    }

    public Date getUpdateTime() {
        return bizArticleLook.getUpdateTime();
    }
}
