package com.amp.common.annotion;

import java.lang.annotation.*;

/**
 * 查询注解
 *
 * @author caizy
 * @date 2019/8/2 14:09
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
@Documented
public @interface QueryDesc {

    /**
     * 查询的字段
     * @return
     */
    String field() default "";

    /**
     * 查询的比较操作
     * @return
     */
    QueryRuleEnum op() default QueryRuleEnum.EQ;

    /**
     * 描述
     * @return
     */
    String description() default "";

    /**
     * 是否排序
     * @return
     */
    boolean isOrder() default false;

    /**
     * 排序
     * @return
     */
    boolean asc() default true;
}
