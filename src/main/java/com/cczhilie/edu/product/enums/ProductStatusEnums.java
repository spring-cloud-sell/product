package com.cczhilie.edu.product.enums;

import lombok.Getter;

/**
 * @author: GZC
 * @create: 2020-04-07 16:21
 * @description: 商品状态枚举
 **/
@Getter
public enum  ProductStatusEnums {

    /**
     *商品状态在架
     */
    UP(0,"在架"),

    /**
     * 商品状态下架
     */
    DOWN(1,"下架"),
    ;

    private Integer code;

    private String msg;

    ProductStatusEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
