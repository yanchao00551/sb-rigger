package com.ebaycloud.rigger.business.entity;

import com.ebaycloud.rigger.persistence.beans.BizArticle;
import com.ebaycloud.rigger.persistence.beans.BizTags;
import com.ebaycloud.rigger.persistence.beans.BizType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

/**
 * @PackageName:com.ebaycloud.rigger.business.entity
 * @ClassName:Article
 * @Description:
 * @author: 悟空
 * @date: 2021/3/20 22:10
 * @email: 10947@163.com
 */
public class Article {

    private BizArticle bizArticle;


    @JsonIgnore
    public BizArticle getBizArticle() {
        return bizArticle;
    }


    public Article(){
        this.bizArticle = new BizArticle();
    }


    public Article(BizArticle bizArticle) {
        this.bizArticle = bizArticle;
    }

    public Integer getLookCount() {
        return bizArticle.getLookCount();
    }

    public Integer getCommentCount() {
        return bizArticle.getCommentCount();
    }

    public void setLookCount(Integer lookCount) {
        bizArticle.setLookCount(lookCount);
    }

    public void setCommentCount(Integer commentCount) {
        bizArticle.setCommentCount(commentCount);
    }

    public List<BizTags> getTags() {
        return bizArticle.getTags();
    }

    public Long getUserId() {
        return bizArticle.getUserId();
    }

    public String getCoverImage() {
        return bizArticle.getCoverImage();
    }

    public void setUserId(Long userId) {
        bizArticle.setUserId(userId);
    }

    public Boolean getComment() {
        return bizArticle.getComment();
    }


    public void setQrcodePath(String qrcodePath) {
        bizArticle.setQrcodePath(qrcodePath);
    }

    public void setStatus(Boolean status) {
        bizArticle.setStatus(status);
    }

    public BizType getBizType() {
        return bizArticle.getBizType();
    }

    public String getTitle() {
        return bizArticle.getTitle();
    }

    public Boolean getStatus() {
        return bizArticle.getStatus();
    }

    public String getQrcodePath() {
        return bizArticle.getQrcodePath();
    }

    public Boolean getIsMarkdown() {
        return bizArticle.getIsMarkdown();
    }

    public Boolean getRecommended() {
        return bizArticle.getRecommended();
    }


    public void setTags(List<BizTags> tags) {
        bizArticle.setTags(tags);
    }

    public void setContentMd(String contentMd) {
        bizArticle.setContentMd(contentMd);
    }

    public String getContent() {
        return bizArticle.getContent();
    }

    public String getContentMd() {
        return bizArticle.getContentMd();
    }

    public Boolean getOriginal() {
        return bizArticle.getOriginal();
    }

    public void setDescription(String description) {
        bizArticle.setDescription(description);
    }

    public void setComment(Boolean comment) {
        bizArticle.setComment(comment);
    }

    public void setIsMarkdown(Boolean isMarkdown) {
        bizArticle.setIsMarkdown(isMarkdown);
    }

    public void setTop(Boolean top) {
        bizArticle.setTop(top);
    }

    public void setRecommended(Boolean recommended) {
        bizArticle.setRecommended(recommended);
    }

    public void setBizType(BizType bizType) {
        bizArticle.setBizType(bizType);
    }

    public Boolean getTop() {
        return bizArticle.getTop();
    }

    public String getDescription() {
        return bizArticle.getDescription();
    }

    public void setCoverImage(String coverImage) {
        bizArticle.setCoverImage(coverImage);
    }

    public void setTitle(String title) {
        bizArticle.setTitle(title);
    }

    public void setOriginal(Boolean original) {
        bizArticle.setOriginal(original);
    }

    public Long getTypeId() {
        return bizArticle.getTypeId();
    }

    public void setTypeId(Long typeId) {
        bizArticle.setTypeId(typeId);
    }

    public void setContent(String content) {
        bizArticle.setContent(content);
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getCreateTime() {
        return bizArticle.getCreateTime();
    }

    public void setUpdateTime(Date updateTime) {
        bizArticle.setUpdateTime(updateTime);
    }

    public Long getId() {
        return bizArticle.getId();
    }

    public void setId(Long id) {
        bizArticle.setId(id);
    }

    public void setCreateTime(Date createTime) {
        bizArticle.setCreateTime(createTime);
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getUpdateTime() {
        return bizArticle.getUpdateTime();
    }

    public String getKeywords() {
        return bizArticle.getKeywords();
    }

    public void setKeywords(String keywords) {
        bizArticle.setKeywords(keywords);
    }
}
