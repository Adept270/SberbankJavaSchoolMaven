package com.jschool.Day10_StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Задание № 4
 * С помощью lambda и Stream API реализуйте алгоритм шифрования текста методом
 * гаммирования.
 * Это творческое задание, в качестве гаммы
 * используйте либо строку текста, либо последовательность натуральных чисел. Результат
 * шифрования необязательно должен поддаваться расшифровке
 */
public class CriptLib {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Hello ", "World");

        Stream<String> encodeStream = stringList.stream().map(s -> CriptLib.encode(s, "key"));
        encodeStream.map(s -> CriptLib.decode(s, "key")).forEach(System.out::println);

    }

    public static String encode(String pText, String pKey) {
        byte[] txt = pText.getBytes();
        byte[] key = pKey.getBytes();
        byte[] res = new byte[pText.length()];

        for (int i = 0; i < txt.length; i++) {
            res[i] = (byte) (txt[i] ^ key[i % key.length]);
        }

        return new String(res);
    }

    public static String decode(String inString, String pKey) {
        byte[] pText = inString.getBytes();
        byte[] res = new byte[pText.length];
        byte[] key = pKey.getBytes();

        for (int i = 0; i < pText.length; i++) {
            res[i] = (byte) (pText[i] ^ key[i % key.length]);
        }

        return new String(res);
    }
}
