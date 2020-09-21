package com.jschool.Day5_Reflection.Task1_Annotations.Calculator;

public interface Calculator {
    /**
     * Расчет факториала числа.
     * @param number - натуральное число, факториал которого будет вычислен.
     */
    @Cache
    int calc (int number);

}
