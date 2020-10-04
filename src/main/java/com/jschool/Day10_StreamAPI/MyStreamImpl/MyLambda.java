package com.jschool.Day10_StreamAPI.MyStreamImpl;

/**
 * Опишите функциональный интерфейс, который позволит выполнить следующий код:
 * MyLambda<String> myLambda1 = (a, b) -> a + b;
 * MyLambda<Integer> myLambda2 = (a, b) -> a + b;
 */
@java.lang.FunctionalInterface
public interface MyLambda<T> {
    public T func(T a, T b);

}
