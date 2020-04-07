package com.cczhilie.edu.product.util;

import com.cczhilie.edu.product.vo.ResultVo;


/**
 * @author: GZC
 * @create: 2020-04-07 19:16
 * @description:
 **/
public class ResultVoUtil {

    public static ResultVo success(Object object) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        //noinspection unchecked
        resultVo.setData(object);
        return resultVo;
    }
}
