package com.jschool.Day5_Reflection.Task1_Annotations.Calculator;

import com.jschool.Day5_Reflection.Task1_Annotations.Calculator.Cache.CalculatorHandler;
import com.jschool.Day5_Reflection.Task1_Annotations.Calculator.Metric.PerformanceProxy;

import java.lang.reflect.Proxy;

public class ProxyUtils {

    public static Calculator makeCache(Calculator calculator) {
        return (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(),
                new Class[]{Calculator.class},
                new CalculatorHandler(calculator));
    }

    public static Calculator performanceMetric(Calculator calculator) {
        return (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(),
                new Class[]{Calculator.class},
                new PerformanceProxy(calculator));
    }
}
