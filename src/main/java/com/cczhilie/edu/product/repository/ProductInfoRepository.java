package com.cczhilie.edu.product.repository;

import com.cczhilie.edu.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: GZC
 * @create: 2020-04-07 15:10
 * @description: 商品dao层
 **/
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    /**
     * 根据上架状态查询商品列表
     * @param status
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer status);

    /**
     * 根据id集合查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
