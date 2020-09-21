package com.jschool.Day5_Reflection.Task1_Annotations.Calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorImplTest {
    @Test
    public void cacheCalcTest() {
        Calculator calculator = ProxyUtils.makeCache(new CalculatorImpl());
        System.out.println(calculator.calc(5));
        System.out.println(calculator.calc(5));
    }

}