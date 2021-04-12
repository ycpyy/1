package com.yc.springframework.stereotype;

import javax.lang.model.util.ElementFilter;
import java.lang.annotation.*;

@Target(value = {ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyResource {

    String name() default "";

}
