package com.cczhilie.edu.product.controller;

import com.cczhilie.edu.product.service.CategoryService;
import com.cczhilie.edu.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: GZC
 * @create: 2020-04-07 15:03
 * @description: 商品controller类
 **/
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
}
