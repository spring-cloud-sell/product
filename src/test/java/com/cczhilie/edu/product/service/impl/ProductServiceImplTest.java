package com.cczhilie.edu.product.service.impl;

import com.cczhilie.edu.product.ProductApplicationTests;
import com.cczhilie.edu.product.dataobject.ProductInfo;
import com.cczhilie.edu.product.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ProductServiceImplTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = productService.findUpAll();
        System.out.println(Arrays.toString(upAll.toArray()));
    }
}