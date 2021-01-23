package com.hcf.response;

/**
 * @Description: 返回码定义区间如下
 * Rules:
 * #200:操作成功
 * #300：操作失败
 * #1000-1999区间：参数错误
 * #2000-2999区间：用户错误
 * #3000-3999区间：接口错误
 */
public enum ResultCode implements CustomizeResultCode{
    /**
     * 操作成功
     */
    SUCCESS(200,"操作成功"),
    /**
     * 失败
     */
    FAIL(300,"操作失败");
    private Integer code;
    private String message;

    ResultCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
