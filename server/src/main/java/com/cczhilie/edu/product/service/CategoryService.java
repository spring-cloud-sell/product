package com.cczhilie.edu.product.service;

import com.cczhilie.edu.product.dataobject.ProductCategory;

import java.util.List;

/**
 * @author: GZC
 * @create: 2020-04-07 17:27
 * @description: 商品类目service
 **/
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
