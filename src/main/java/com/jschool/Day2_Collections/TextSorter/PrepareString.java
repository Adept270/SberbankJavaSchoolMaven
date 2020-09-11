package com.jschool.Day2_Collections.TextSorter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PrepareString {
    public static final File FILE = new File("src/main/resources/Day2_test.txt");

    /**Служебный класс. Используется для получения строки из файла, для ее дальнейшей сортировки.
     *
     * @param file - файл, содержащий текс для обработки
     * @return String - текст, полученный в результате чтения файла
     */
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

        return stringBuilder.toString().replaceAll("\\p{Punct}|\\d", "").toLowerCase().
                replaceAll(System.lineSeparator(), "");
    }
}
