package com.jschool.Day5_Reflection.Task1_Annotations.Calculator.Metric;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceProxy implements InvocationHandler {
    private final Object delegate;

    public PerformanceProxy(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.isAnnotationPresent(Metric.class)) {
            Object invokeObj;
            long currentTime = System.nanoTime();
            invokeObj = method.invoke(delegate, args);
            System.out.println("Время работы метода: " + (System.nanoTime() - currentTime) + " (в наносек)");
            return invokeObj;
        }
        return method.invoke(delegate, args);
    }
}
