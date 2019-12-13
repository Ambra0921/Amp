package com.amp.order.controller;

import com.amp.order.entity.vo.GoodsVo;
import com.amp.order.entity.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 订单controller
 *
 * @author caizy
 * @date 2019/12/13 15:44
 **/
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getDetail/{id}")
    public OrderVo getDetail(@PathVariable String id){
        OrderVo orderVo = new OrderVo();
        orderVo.setId(id);
        GoodsVo goodsVo = restTemplate.getForObject("http://amp-goods/goods//getGood/123", GoodsVo.class);
        BeanUtils.copyProperties(goodsVo,orderVo,new String[]{"id"});
        orderVo.setGoodsId(goodsVo.getId());
        return orderVo;
    }
}
