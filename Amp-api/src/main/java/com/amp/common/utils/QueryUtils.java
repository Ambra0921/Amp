package com.amp.common.utils;

import com.amp.common.annotion.QueryDesc;
import com.amp.common.annotion.QueryRuleEnum;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;

/**
 * 查询工具类
 *
 * @author caizy
 * @date 2019/8/2 15:39
 **/
@Slf4j
public class QueryUtils {

    /**
     * constructor
     */
    private QueryUtils(){

    }

    /**
     * 根据参数初始化QueryWrapper
     * @param searchObj
     * @param <T>
     * @return
     */
    public static <T>QueryWrapper<T> initQueryWrapper(T searchObj){
        long start = System.currentTimeMillis();
        QueryWrapper<T> queryWrapper = new QueryWrapper();
        //转化参数
        intallParams(searchObj,queryWrapper);
        log.debug("---查询条件构造器初始化完成,耗时:"+(System.currentTimeMillis()-start)+"毫秒----");
        return queryWrapper;
    }

    /**
     * 初始化参数
     * @param searchObj
     * @param queryWrapper
     * @param <T>
     */
    private static <T> void intallParams(T searchObj, QueryWrapper<T> queryWrapper) {
        try{
            Class<?> clazz = searchObj.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for(Field field : fields){

                QueryDesc queryDesc = field.getAnnotation(QueryDesc.class);
                if(queryDesc!=null){
                    //预先校验
                    Object value =  field.get(searchObj);
                    String filedName = queryDesc.field();
                    if(StringUtils.isEmpty(filedName)){
                        filedName = field.getName();
                    }
                    setParam(queryWrapper,queryDesc.op(),filedName,value);

                    if(queryDesc.isOrder()){
                        if(queryDesc.asc()){
                            queryWrapper.orderByAsc(filedName);
                        }else{
                            queryWrapper.orderByDesc(filedName);
                        }
                    }
                }
            }
        }catch (IllegalAccessException e){
            log.error("获取值失败：{}",e.getMessage(),e);
        }

    }

    /**
     * 设置参数
     * @param queryWrapper
     * @param op
     * @param filedName
     * @param value
     * @param <T>
     */
    private static <T> void setParam(QueryWrapper<T> queryWrapper, QueryRuleEnum op, String filedName, Object value) {

        log.error("进行sql条件构建:op:{},name:{},value:{}",JSONUtils.toJSONString(op),filedName,JSONUtils.toJSONString(value));
        switch (op) {
            case GT:
                queryWrapper.gt(filedName, value);
                break;
            case GE:
                queryWrapper.ge(filedName, value);
                break;
            case LT:
                queryWrapper.lt(filedName, value);
                break;
            case LE:
                queryWrapper.le(filedName, value);
                break;
            case EQ:
                queryWrapper.eq(filedName, value);
                break;
            case NE:
                queryWrapper.ne(filedName, value);
                break;
            case IN:
                if(value instanceof String) {
                    queryWrapper.in(filedName, (Object[])value.toString().split(","));
                }else if(value instanceof String[]) {
                    queryWrapper.in(filedName, (Object[]) value);
                }else {
                    queryWrapper.in(filedName, value);
                }
                break;
            case LIKE:
                queryWrapper.like(filedName, value);
                break;
            case LEFT_LIKE:
                queryWrapper.likeLeft(filedName, value);
                break;
            case RIGHT_LIKE:
                queryWrapper.likeRight(filedName, value);
                break;
            default:
                log.error("--查询规则未匹配到---");
                break;
        }
    }
}
