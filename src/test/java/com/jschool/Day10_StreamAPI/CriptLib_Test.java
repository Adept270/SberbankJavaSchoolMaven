package com.jschool.Day10_StreamAPI;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

public class CriptLib_Test {
    private static List<String> stringList = Arrays.asList("Hello ", "World!");


    @Test
    public void testEncodeDecode() {
        List<String> encodeList = new ArrayList<>();
        stringList.stream().map(s -> CriptLib.encode(s, "key")).forEach(encodeList::add);

        Stream<String> decodeList = encodeList.stream().map(s -> CriptLib.decode(s, "key"));

        Assert.assertArrayEquals(stringList.toArray(), decodeList.toArray());

    }

}