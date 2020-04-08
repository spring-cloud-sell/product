package com.cczhilie.edu.product.enums;

import lombok.Getter;

/**
 * @author: GZC
 * @create: 2020-04-08 17:41
 * @description:
 **/
@Getter
public enum ResultEnum {

    /**
     * 商品不存在
     */
    PRODUCT_NOT_EXIST(1, "商品不存在"),
    /**
     * 库存有误
     */
    PRODUCT_STOCK_ERROR(2, "库存有误"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
