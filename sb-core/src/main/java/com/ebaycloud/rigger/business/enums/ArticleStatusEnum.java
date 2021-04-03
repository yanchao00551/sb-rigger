package com.ebaycloud.rigger.business.enums;

/**
 * 文章状态枚举
 * @PackageName:com.ebaycloud.rigger.business.enums
 * @ClassName:articleStatusEnumeration
 * @Description:
 * @author: 悟空
 * @date: 2021/4/2 10:38
 * @email: 10947@163.com
 */
public enum ArticleStatusEnum {

    /**
     * 已发布
     * @Author 悟空
     * @Description //TODO
     * @Date 21:51 2021/4/2
     * @Param
     * @return
     **/
    PUBLISHED(1,"已发布"),
    /**
     * 草稿
     * @Author 悟空
     * @Description //TODO
     * @Date 21:51 2021/4/2
     * @Param
     * @return
     **/
    UNPUBLISHED(0,"草稿"),
    ;

    private int code;
    private String desc;

    ArticleStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ArticleStatusEnum get(Integer code){
        if(code == null){
            return UNPUBLISHED;
        }
        ArticleStatusEnum[] statusEnums = ArticleStatusEnum.values();
        for(ArticleStatusEnum statusEnum:statusEnums){
            if(statusEnum.getCode() == code){
                return  statusEnum;
            }
        }
        return UNPUBLISHED;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}

