package com.cczhilie.edu.product.service.impl;

import com.cczhilie.edu.product.common.DecreaseStockInput;
import com.cczhilie.edu.product.common.ProductInfoOutput;
import com.cczhilie.edu.product.dataobject.ProductInfo;
import com.cczhilie.edu.product.enums.ProductStatusEnums;
import com.cczhilie.edu.product.enums.ResultEnum;
import com.cczhilie.edu.product.exception.ProductException;
import com.cczhilie.edu.product.repository.ProductInfoRepository;
import com.cczhilie.edu.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<ProductInfoOutput> findByProductIdIn(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList)
                .stream()
                .map(e -> {
                    ProductInfoOutput productInfoOutput = new ProductInfoOutput();
                    BeanUtils.copyProperties(e,productInfoOutput);
                    return productInfoOutput;
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        for (DecreaseStockInput decreaseStockInput : decreaseStockInputList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(decreaseStockInput.getProductId());
            //判断商品是否存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            ProductInfo productInfo = productInfoOptional.get();
            //库存是否足够
            Integer result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }

}
