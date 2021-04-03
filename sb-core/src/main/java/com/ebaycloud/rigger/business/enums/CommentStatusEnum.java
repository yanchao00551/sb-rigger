package com.ebaycloud.rigger.business.enums;

/**
 * 评论状态枚举
 * @author 悟空
 * @description //TODO
 * @date 12:09 2021/4/3
 * @param null
 * @return null
 */
public enum CommentStatusEnum {
    /**
     * 正在审核
     * @author 悟空
     * @description //TODO
     * @date 12:13 2021/4/3
     * @param null
     * @return null
     */
    VERIFYING("正在审核"),
    /**
     * 审核通过
     * @author 悟空
     * @description //TODO
     * @date 12:13 2021/4/3
     * @param null
     * @return null
     */
    APPROVED("审核通过"),
    /**
     * 审核失败
     * @author 悟空
     * @description //TODO
     * @date 12:13 2021/4/3
     * @param null
     * @return null
     */
    REJECT("审核失败"),
    /**
     * 已删除
     * @author 悟空
     * @description //TODO
     * @date 12:13 2021/4/3
     * @param null
     * @return null
     */
    DELETED("已删除"),
    ;

    private String desc;

    CommentStatusEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
