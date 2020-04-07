package com.cczhilie.edu.product.service.impl;

import com.cczhilie.edu.product.ProductApplicationTests;
import com.cczhilie.edu.product.dataobject.ProductCategory;
import com.cczhilie.edu.product.service.CategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;


public class CategoryServiceImplTest extends ProductApplicationTests {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(11, 22));
        System.out.println(productCategoryList.toString());
    }
}