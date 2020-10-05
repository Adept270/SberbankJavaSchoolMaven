package com.jschool.Day10_StreamAPI;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import static org.junit.Assert.*;

public class CriptLibTest {

    @Test
    public void encode() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello!");

        stringList.stream().map(CriptLib::encode).forEach(System.out::println);

        List<String> stringList1 = Collections.singletonList("yT]]^\u0010");
        stringList1.stream().map(CriptLib::decode).forEach(System.out::println);


    }

    @Test
    public void decode() {
    }
}