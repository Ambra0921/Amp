package com.amp.goods.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author caizy
 * @date 2019/12/13 14:45
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsVo implements Serializable {

    private static final long serialVersionUID = -7449355308287008193L;

    /**
     * 主键
     */
    private String id;

    /**
     * 商品编号
     */
    private String goodsNo;

    /**
     * 商品名称
     */
    private String goodsName;


    /**
     * 价格
     */
    private BigDecimal price;
}
