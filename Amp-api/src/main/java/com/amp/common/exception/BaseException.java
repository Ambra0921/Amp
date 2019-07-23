package com.amp.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基本异常类
 *
 * @author caizy
 * @date 2019/7/23 14:58
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseException extends RuntimeException {

    private String message;

    private int code;


}
