package com.jschool.Day16_JDBC.calculate;

public class Calculator implements ICalculator {

    public int getFibonacci(int n) {
        if ((n <= 1) || (n == 2)) {
            return 1;
        } else {
            return (getFibonacci(n - 1) + getFibonacci(n - 2));
        }
    }
}
