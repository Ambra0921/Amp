package com.amp.order.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author caizy
 * @date 2019/12/13 15:52
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderVo implements Serializable {

    private static final long serialVersionUID = -7449355308287008193L;

    private String id;

    private String goodsId;

    private String orderNo;

    private String goodsNo;

    private String goodsName;

    private BigDecimal price;
}
