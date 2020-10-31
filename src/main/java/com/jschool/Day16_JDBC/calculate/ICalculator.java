package com.jschool.Day16_JDBC.calculate;

public interface ICalculator {

    /**
     * Получение числа Фибоначчи
     * @param - номер числа в ряду Фибоначчи
     * @return - значение числа
     */
    @DBCache
    int getFibonacci(int n);

}
