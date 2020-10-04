package com.jschool.Day10_StreamAPI.MyStreamImpl;


import org.junit.Test;

import static org.junit.Assert.*;

public class MyLambdaTest {

    @Test
    public void testMyLambda() {
        MyLambda<String> stringMyLambda = (a, b) -> a + b;
        MyLambda<Integer> integerMyLambda = (a, b) -> a + b;

        assertEquals("12", stringMyLambda.func("1", "2"));
        assertEquals((Integer) 3, integerMyLambda.func(1, 2));
    }


}