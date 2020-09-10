package com.jschool.Day2_Collections.TextSorter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TextSorter {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/16727641/IdeaProjects/JavaSchoolSberbank/ResourcesFiles/Day2_test.txt");
        System.out.println(textHolder(file));

        System.out.println("-------------\nКол-во слов: " + wordCounter(textHolder(file)));

        System.out.println("-----------");

        for (String s : sortedUniqueWords(textHolder(file))) {
            System.out.println(s);
        }


    }


    //TODO: добавить нормализацию, чтобы возвращались только слова, без чисел и знаков препинания.
    public static String textHolder(File file) {

        List<String> allLines = new ArrayList<>();

        try {
            allLines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : allLines) {
            stringBuilder.append(s);
            stringBuilder.append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }

    //Подсчитайте количество различных слов в файле
    public static int wordCounter(String text) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(text.split(" ")));
        return wordSet.size();
    }

    //Выведите на экран список различных слов файла, отсортированный по возрастанию их длины
    // (компаратор сначала по длине слова, потом по тексту)
    public static TreeSet<String> sortedUniqueWords(String textString) {

        Comparator<String> lengthCompare = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };

        Comparator<String> textCompare = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        TreeSet<String> stringTreeSet = new TreeSet<>(lengthCompare.thenComparing(textCompare));
        stringTreeSet.addAll(Arrays.asList(textString.split(" ")));

        return stringTreeSet;

    }


}
