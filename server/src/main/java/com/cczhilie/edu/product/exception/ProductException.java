package com.cczhilie.edu.product.exception;

import com.cczhilie.edu.product.enums.ResultEnum;

/**
 * @author: GZC
 * @create: 2020-04-08 17:40
 * @description:
 **/
public class ProductException extends RuntimeException{

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
