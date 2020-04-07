package com.cczhilie.edu.product.service.impl;

import com.cczhilie.edu.product.dataobject.ProductInfo;
import com.cczhilie.edu.product.enums.ProductStatusEnums;
import com.cczhilie.edu.product.repository.ProductInfoRepository;
import com.cczhilie.edu.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: GZC
 * @create: 2020-04-07 16:20
 * @description:
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnums.UP.getCode());
    }
}
