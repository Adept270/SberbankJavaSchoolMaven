package com.jschool.Day10_StreamAPI;

import java.util.Arrays;
import java.util.List;

/**
 * Задание № 3
 * С помощью lambda и Stream API реализуйте метод для генерации чисел трибоначчи (да,
 * именно «трибоначчи», не Фибоначчи) до n-го члена последовательности.
 */
public class Tribonacci {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        integerList.forEach(Tribonacci::generateTribonacci);

    }

    public static void generateTribonacci(Integer n) {
        Integer[] arr = new Integer[n];

        for (int i = 0; i < arr.length; i++) {
            if (i < 3)
                arr[i] = 1;
            else {
                arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
            }
        }
        System.out.println(Arrays.asList(arr).toString());
    }
}
