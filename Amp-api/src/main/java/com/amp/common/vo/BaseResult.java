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
public class BaseResult implements Serializable {

    private int code;

    private String msg;

    private Object result;

    /**
     * 成功带返回值的结果
     * @param result
     * @return
     */
    public static BaseResult successResult(Object result){
        return new BaseResult(200,null,result);
    }

    /**
     * 失败
     * @param code
     * @param msg
     * @return
     */
    public static BaseResult fail(int code,String msg){
        return new BaseResult(code,msg,null);
    }

    /**
     * 成功带消息不带返回值的结果
     * @param code
     * @param msg
     * @return
     */
    public static BaseResult sucess(int code,String msg){
        return new BaseResult(code,msg,null);
    }
}
