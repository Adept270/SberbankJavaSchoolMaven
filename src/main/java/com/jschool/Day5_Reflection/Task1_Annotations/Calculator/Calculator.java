package com.jschool.Day5_Reflection.Task1_Annotations.Calculator;

import com.jschool.Day5_Reflection.Task1_Annotations.Calculator.Cache.Cache;
import com.jschool.Day5_Reflection.Task1_Annotations.Calculator.Metric.Metric;

public interface Calculator {
    /**
     * Расчет факториала числа.
     * @param number - натуральное число, факториал которого будет вычислен.
     */
    @Cache
    @Metric
    int calc (int number);

}
