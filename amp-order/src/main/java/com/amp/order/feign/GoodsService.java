package com.amp.order.feign;

import com.amp.config.FeignConfiguration;
import com.amp.order.entity.vo.GoodsVo;
import com.amp.order.feign.factory.GoodsFallbackFactory;
import com.amp.order.feign.fallback.GoodsFallback;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 商品Feign客户端
 *
 * @author caizy
 * @date 2019/12/16 13:31
 **/
@FeignClient(name = "amp-goods",configuration = FeignConfiguration.class,fallbackFactory = GoodsFallbackFactory.class)
public interface GoodsService {

    @RequestLine("GET /goods/getGood/{id}")
    GoodsVo getGoodsById(@Param("id") String id);
}


