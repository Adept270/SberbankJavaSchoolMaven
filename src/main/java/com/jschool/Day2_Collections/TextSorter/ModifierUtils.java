package com.jschool.Day2_Collections.TextSorter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ModifierUtils {
    // посчитать кол-во различных слов в файле
    public static int wordCounter_(String text) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(text.split(" ")));
        return wordSet.size();
    }

    //Сколько раз каждое слово встречается в файле
}
