package com.amp.goods.controller;

import com.amp.goods.entity.vo.GoodsVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 商品controller
 *
 * @author caizy
 * @date 2019/12/13 14:42
 **/
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @GetMapping("/getGood/{id}")
    public GoodsVo getGoodById(@PathVariable String id){
        GoodsVo goodsVo = new GoodsVo();
        goodsVo.setId(id);
        goodsVo.setGoodsName("iphone");
        goodsVo.setGoodsNo("G2019121001231");
        goodsVo.setPrice(new BigDecimal(123123));
        return goodsVo;
    }
}
