package com.jschool.Day10_StreamAPI.MyStreamImpl;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.*;

public class MyStreamTest {
//    Stream<Integer> integerStream = Stream.of(1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 9).filter(i -> i%2 == 0).map(i
//-> i*i).distinct();
//integerStream.forEach(System.out::println);


    public static void main(String[] args) {
        MyStream<Integer> myStream = MyStream.of(1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 9).filter(i -> i % 2 == 0).map(i
                -> i * i).distinct();
        myStream.forEach(System.out::println);

        System.out.println("-----------------");

        Stream<Integer> integerStream = Stream.of(1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 9).filter(i -> i % 2 == 0).map(i
                -> i * i).distinct();
        integerStream.forEach(System.out::println);


    }

//
//    @Test
//    public void of() {
//    }
//
//    @Test
//    public void filter() {
//    }
//
//    @Test
//    public void map() {
//    }
//
//    @Test
//    public void distinct() {
//    }
//
//    @Test
//    public void forEach() {
//    }
}