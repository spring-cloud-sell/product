package com.cczhilie.edu.product.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author: GZC
 * @create: 2020-04-07 15:07
 * @description: 商品类目实体类
 **/
@Entity
@Data
public class ProductCategory {
    @Id
    @GeneratedValue
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    /** 创建日期. */
    private Date createTime;

    /** 更新日期. */
    private Date updateTime;
}
