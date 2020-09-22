package com.jschool.Day5_Reflection.Task1_Annotations.Calculator.Cache;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
}
