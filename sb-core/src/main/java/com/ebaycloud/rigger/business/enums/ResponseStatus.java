package com.ebaycloud.rigger.business.enums;


/**
 * 返回状态.
 * @Author 悟空
 * @Description //TODO
 * @Date 12:26 2021/3/27
 * @Param
 * @return
 **/
public enum ResponseStatus {

    //成功
    SUCCESS(200, "操作成功！"),
    //错误
    ERROR(500, "服务器未知错误！"),
    //失败
    INVALID_PARAMS(500, "操作失败，无效的参数，请检查参数格式、类型是否正确！"),
    //上传失败
    UPLOAD_FILE_ERROR(500, "文件上传失败！"),
    ;

    /**
     * 返回编码
     * @Author 悟空
     * @Description //TODO
     * @Date 12:27 2021/3/27
     * @Param
     * @return
     **/

    private Integer code;
    /**
     * 返回消息
     * @Author 悟空
     * @Description //TODO
     * @Date 12:27 2021/3/27
     * @Param
     * @return
     **/

    private String message;

    ResponseStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResponseStatus getResponseStatus(String message) {
        for (ResponseStatus ut : ResponseStatus.values()) {
            if (ut.getMessage() == message) {
                return ut;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
