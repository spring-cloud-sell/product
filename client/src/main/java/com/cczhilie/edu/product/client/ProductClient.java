package com.cczhilie.edu.product.client;

import com.cczhilie.edu.product.common.DecreaseStockInput;
import com.cczhilie.edu.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author: GZC
 * @create: 2020-04-08 20:42
 * @description:
 **/
@FeignClient(name = "product")
public interface ProductClient {

    /**
     * 获取商品信息
     * @param productIdList
     * @return
     */
    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    /**
     * 通过商品服务获取商品列表
     * @param decreaseStockInputList
     */
    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
}
