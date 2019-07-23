package com.amp.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 基本结果类
 *
 * @author caizy
 * @date 2019/7/23 14:28
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResult<T> implements Serializable {

    private int code;

    private String msg;

    private T result;

    public BaseResult successResult(T result){
        return new BaseResult<>(200,null,result);
    }

    public static BaseResult fail(int code,String msg){
        return new BaseResult<>(200,null,null);
    }
}
