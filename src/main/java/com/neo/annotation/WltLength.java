package com.neo.annotation;

/**
 * created by 魏霖涛 on 2017/10/10 0010
 */

import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
//@Inherited//@Inherited 元注解是一个标记注解，@Inherited阐述了某个被标注的类型是被继承的。如果一个使用了@Inherited修饰的annotation类型被用于一个class，则这个annotation将被用于该class的子类。
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface WltLength {
    boolean isEmpty() default true;
    int max() default 2147483647;
    int min() default 0;
    String message() default "";
}