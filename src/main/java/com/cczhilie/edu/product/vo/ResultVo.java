package com.cczhilie.edu.product.vo;

import lombok.Data;

/**
 * @author: GZC
 * @create: 2020-04-07 17:35
 * @description: 通用返回数据对象
 **/
@Data
public class ResultVo<T> {


    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
