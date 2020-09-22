package com.jschool.Day5_Reflection.Task1_Annotations.Calculator;

import org.junit.Test;


public class CalculatorImplTest {
    @Test
    public void cacheCalcTest() {
        Calculator calculator = ProxyUtils.performanceMetric(ProxyUtils.makeCache(new CalculatorImpl()));

        System.out.println(calculator.calc(5));
        System.out.println(calculator.calc(5));
    }

}