package com.cczhilie.edu.product.service.impl;

import com.cczhilie.edu.product.dataobject.ProductCategory;
import com.cczhilie.edu.product.repository.ProductCategoryRepository;
import com.cczhilie.edu.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: GZC
 * @create: 2020-04-07 17:27
 * @description:
 **/
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
