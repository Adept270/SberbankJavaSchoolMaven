package com.jschool.Day6_IteratorTest;

import java.util.Iterator;

public class MyIterable<T> implements Iterable<T> {
    private T[] objArr;

    public MyIterable(T[] objArr) {
        this.objArr = objArr;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < objArr.length && objArr[currentIndex] != null;
            }

            @Override
            public T next() {
                return objArr[currentIndex++];
            }
        };
    }
}
