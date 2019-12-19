package com.amp.order.feign.fallback;

import com.amp.order.entity.vo.GoodsVo;
import com.amp.order.feign.GoodsService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author caizy
 * @date 2019/12/18 14:52
 **/
@Component
public  class GoodsFallback implements GoodsService {

    @Override
    public GoodsVo getGoodsById(String id) {
        GoodsVo goodsVo = new GoodsVo();
        goodsVo.setId("xxxx");
        goodsVo.setGoodsName("假象的");
        goodsVo.setGoodsNo("假的");
        goodsVo.setPrice(BigDecimal.ZERO);
        return goodsVo;
    }
}
