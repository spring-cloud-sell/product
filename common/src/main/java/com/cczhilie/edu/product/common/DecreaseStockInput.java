package com.cczhilie.edu.product.common;

import lombok.Data;

/**
 * @author: GZC
 * @create: 2020-04-08 20:39
 * @description:
 **/
@Data
public class DecreaseStockInput {

    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
