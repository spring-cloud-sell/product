package com.cczhilie.edu.product.controller;

import com.cczhilie.edu.product.common.DecreaseStockInput;
import com.cczhilie.edu.product.common.ProductInfoOutput;
import com.cczhilie.edu.product.dataobject.ProductCategory;
import com.cczhilie.edu.product.dataobject.ProductInfo;
import com.cczhilie.edu.product.service.CategoryService;
import com.cczhilie.edu.product.service.ProductService;
import com.cczhilie.edu.product.util.ResultVoUtil;
import com.cczhilie.edu.product.vo.ProductInfoVo;
import com.cczhilie.edu.product.vo.ProductVo;
import com.cczhilie.edu.product.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: GZC
 * @create: 2020-04-07 15:03
 * @description: 商品controller类
 **/
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    /**
     * 1. 查询所有在架的商品
     * 2. 获取类目type列表
     * 3. 查询类目
     * 4. 构造数据
     */
    @GetMapping("/list")
    public ResultVo<ProductVo> list() {
        //1. 查询所有在架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. 获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        //3. 从数据库查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //4. 构造数据
        List<ProductVo> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: categoryList) {
            ProductVo productVO = new ProductVo();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVo> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVo productInfoVO = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVoUtil.success(productVOList);
    }


    /**
     * 获取商品列表(给订单服务用的)
     *
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("获取商品列表(给订单服务用的)");
        return productService.findByProductIdIn(productIdList);
    }

    /**
     * 扣除商品库存(给订单服务用的)
     *
     * @param decreaseStockInputList
     */
    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
        log.info("扣除商品库存(给订单服务用的)");
        productService.decreaseStock(decreaseStockInputList);
    }

}
