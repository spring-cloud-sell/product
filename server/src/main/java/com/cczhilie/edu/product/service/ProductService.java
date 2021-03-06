package com.cczhilie.edu.product.service;

import com.cczhilie.edu.product.common.DecreaseStockInput;
import com.cczhilie.edu.product.common.ProductInfoOutput;
import com.cczhilie.edu.product.dataobject.ProductInfo;

import java.util.List;

/**
 * @author: GZC
 * @create: 2020-04-07 16:17
 * @description: 商品service层
 **/
public interface ProductService {
    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 根据ID列表查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findByProductIdIn(List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
