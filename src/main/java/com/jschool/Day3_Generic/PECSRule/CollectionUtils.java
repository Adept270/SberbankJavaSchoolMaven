package com.jschool.Day3_Generic.PECSRule;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, T someObj) {
        return source.indexOf(someObj);
    }

    public static <T> List<? extends T> limit(List<? extends T> source, int size) {
        return source.subList(0, size);
    }

    public static <T> void add(List<? super T> source, T someObj) {
        source.add(someObj);
    }

    public static <T> void removeAll(List<? extends T> removeFrom, List<T> c2) {
        for (T t : c2)
            removeFrom.remove(t);
    }

    /**
     * @return - возвращает true если первый лист содержит все элементы второго
     */
    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    /**
     * @return - возарвщает true если первый лист содержит хотя-бы 1 второго
     */
    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T t : c1) {
            if (c2.contains(t)) return true;
        }
        return false;
    }

    /**
     * Метод выполняет сравнение элементов через Comparable и удаление элементов в заданном диапазоне.
     * Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
     *
     * @param list - коллекция, переденная для модификации
     * @param min  - минимальное значение массива
     * @param max  - максимальное значение массива
     * @return - Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
     */
    public static <T> List<? super T> range(List<? extends T> list, Object min, Object max) {
        List<? super T> resultList = newArrayList();

        for (T t : list) {
            if (compare(t, min) >= 0 && compare(t, max) <= 0) {
                resultList.add(t);
            }
        }

        return resultList;
    }

    /**
     * @return - возвращает результат сравнения элементов, для использования в методе range.
     */
    public static <T> int compare(T obj1, T obj2) {
        return ((Comparable<? super T>) obj1).compareTo(obj2);
    }


    /**
     * Метод выполняет сравнение элементов через полученный Comparator и их удаление в заданном диапазоне.
     * Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
     *
     * @param list - коллекция, переденная для модификации
     * @param min  - минимальное значение массива
     * @param max  - максимальное значение массива
     * @return - Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
     */
    public static <T> List<? super T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {

        List<? super T> resultList = newArrayList();

        for (T t : list) {
            if (comparator.compare(t, min) >= 0 && comparator.compare(t, max) <= 0) {
                resultList.add(t);
            }
        }

        return resultList;
    }

}