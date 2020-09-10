package com.jschool.Day2_Collections.TextSorter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/16727641/IdeaProjects/JavaSchoolSberbank/ResourcesFiles/Day2_test.txt");
        System.out.println(textHolder(file));

        System.out.println(ModifierUtils.wordCounter(textHolder(file)));

    }


    //TODO: добавить нормализацию, чтобы возвращались только слова, без чисел и знаков препинания.
    public static String textHolder(File file) throws IOException {
        List<String> allLines = Files.readAllLines(Paths.get("./src/main/resources/Day2_test.txt"));

        ArrayList<String> result = parseWords(allLines);

        Files.write(Paths.get("./src/main/resources/Day2_test.txt"), result);

        String line = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }

            return stringBuilder.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    private static ArrayList<String> parseWords(List<String> allLines) {
        ArrayList<String> result = new ArrayList<>();

        for (String line : allLines) {
            String[] split = line.split(" ");
        }
        return result;
    }
}
