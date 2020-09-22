package com.jschool.Day5_Reflection.Task1_Annotations.Calculator.Cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CalculatorHandler implements InvocationHandler {
    private final Object delegate;
    private final Map<Integer, Integer> cache = new HashMap<>();

    public CalculatorHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Integer result;
        Integer intArg = (Integer) args[0];

        if (method.isAnnotationPresent(Cache.class) && method.getName().equals("calc")) {

            if (null != (result = cache.get(intArg)))
                return result;
        }

        result = (Integer) method.invoke(delegate, args);
        cache.put(intArg, result);
        return result;
    }
}
