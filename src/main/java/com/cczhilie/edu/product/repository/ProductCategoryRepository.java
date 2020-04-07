package com.cczhilie.edu.product.repository;

import com.cczhilie.edu.product.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: GZC
 * @create: 2020-04-07 15:09
 * @description: 商品类目dao层
 **/
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    /**
     * 根据商品类目类型查询商品类目列表
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
