package com.amp.common.utils;

import com.amp.common.exception.BaseException;
import com.amp.common.vo.BaseResult;
import lombok.extern.slf4j.Slf4j;

/**
 * 异常工具类
 *
 * @author caizy
 * @date 2019/7/23 15:08
 **/
@Slf4j
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
            return BaseResult.fail(-1,e.getMessage());
        }

        log.error("系统内部异常：{}",e.getMessage(),e);
        return BaseResult.fail(FAIL_CODE,BASE_MESSAGE);
    }
}
