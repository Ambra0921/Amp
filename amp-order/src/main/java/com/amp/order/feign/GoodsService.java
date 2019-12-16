package com.amp.order.feign;

import com.amp.config.FeignConfiguration;
import com.amp.order.entity.vo.GoodsVo;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 商品Feign客户端
 *
 * @author caizy
 * @date 2019/12/16 13:31
 **/
@FeignClient(value = "amp-goods",configuration = FeignConfiguration.class)
public interface GoodsService {

    @RequestLine("GET /goods/getGood/{id}")
    GoodsVo getGoodsById(@Param("id") String id);
}
