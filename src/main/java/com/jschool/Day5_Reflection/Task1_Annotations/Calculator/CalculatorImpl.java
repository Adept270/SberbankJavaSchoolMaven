package com.jschool.Day5_Reflection.Task1_Annotations.Calculator;

import java.lang.reflect.Proxy;

public class CalculatorImpl implements Calculator {

    @Override
    public int calc(int number) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (number <= 1)
            return 1;
        else
            return number * calc(number - 1);
    }
}

