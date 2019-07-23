package com.amp.common.utils;

import com.amp.common.exception.BaseException;
import com.amp.common.vo.BaseResult;

/**
 * 异常工具类
 *
 * @author caizy
 * @date 2019/7/23 15:08
 **/
public class ExceptionUtil {

    /**
     * 基本错误码
     */
    private static final int  FAIL_CODE = -1;

    /**
     * 基本异常信息
     */
    private static  final String BASE_MESSAGE= "系统内部异常";

    public static BaseResult fail(Exception e){
        if(e instanceof BaseException){
            return BaseResult.fail(((BaseException) e).getCode(),e.getMessage());
        }
        return BaseResult.fail(FAIL_CODE,BASE_MESSAGE);
    }
}
