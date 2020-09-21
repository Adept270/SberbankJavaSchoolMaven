package com.jschool.Day5_Reflection.Task1_Annotations.Calculator;

import java.lang.reflect.Proxy;

public class ProxyUtils {
    public static Calculator makeCache(Calculator calculator) {
        return (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(),
                new Class[] {Calculator.class},
                new CalculatorHandler(calculator));

    }
}
