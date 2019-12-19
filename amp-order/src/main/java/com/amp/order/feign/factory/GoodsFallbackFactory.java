package com.amp.order.feign.factory;

import com.amp.order.entity.vo.GoodsVo;
import com.amp.order.feign.GoodsService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * fallback工厂类
 *
 * @author caizy
 * @date 2019/12/19 14:16
 **/
@Component
@Slf4j
public class GoodsFallbackFactory implements FallbackFactory<GoodsService> {

    @Override
    public GoodsService create(Throwable cause) {
        log.error("the provider error is: {}", cause.getMessage());
        return new GoodsService() {
            @Override
            public GoodsVo getGoodsById(String id) {
                GoodsVo goodsVo = new GoodsVo();
                goodsVo.setId("xxxx");
                goodsVo.setGoodsName("假象的");
                goodsVo.setGoodsNo("假的");
                goodsVo.setPrice(BigDecimal.ZERO);
                return goodsVo;
            }
        };
    }
}
