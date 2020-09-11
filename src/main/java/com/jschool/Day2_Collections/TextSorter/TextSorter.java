package com.jschool.Day2_Collections.TextSorter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/** Класс содержит меторы для сортировки строк.
 *  Для работы реализован служебный класс PrepareString, выполняющей подтотовку строки из файла.
 */
public class TextSorter {

    //Подсчитайте количество различных слов в файле
    public static long wordCounter(String text) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(text.split(" ")));
        System.out.println("Количество уникальныйх слов: " + wordSet.size() + "\n");
        return wordSet.size();
    }

    //Выведите на экран список различных слов файла, отсортированный по возрастанию их длины
    // (компаратор сначала по длине слова, потом по тексту)
    public static void sortedUniqueWords(String textString) {

        /** Создаются компараторы для сортировки по двум значениям. */
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

        stringTreeSet.forEach(System.out::println);

    }

    /**Подсчитывает и выведит на экран сколько раз каждое слово встречается в строке.
     *
     * @param textString
     * @return  Map<String, Integer>
     */
    public static Map<String, Integer> uniqueWordCounter(String textString) {
        HashMap<String, Integer> resultMap = new HashMap<>();

        for (String s : textString.split(" ")) {
            if (!resultMap.containsKey(s)) {
                resultMap.put(s, 1);
            } else {
                Integer i = resultMap.get(s) + 1;
                resultMap.put(s, i);
            }
        }
        return resultMap;
    }

    /**Выводит на экран все строки файла в обратном порядке.
     *
     * @param textString
     */
    public static void printReversStrings(String textString) {

        Deque<String> stringDeque = new ArrayDeque<>();
        for (String s : textString.split(System.lineSeparator())) {
            stringDeque.push(s);
        }

        for (String s : stringDeque) {
            System.out.println(s);
        }

    }

    /**Создает Iterator для обхода списка в обратном порядке
     *
     * @param iterable
     * @param <T>
     * @return Iterator - выполняет обход коллекции в обратном порядке
     */
    public static <T> Iterator<T> reversIterator(Iterable<T> iterable) {
        Iterator<T> iter = iterable.iterator();
        List<T> reversList = new ArrayList<>();

        while (iter.hasNext()) {
            reversList.add(0, iter.next());
        }

        return reversList.iterator();

    }

    /**Выводит на экран строки, номера которых задаются пользователем в произвольном порядке
     *
     * @param textString - анализируемый текст
     */
    public static void printRequestString(String textString) {
        List<String> textArrayList = new ArrayList<>(Arrays.asList(textString.split(System.lineSeparator())));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер строки");

        while (true) {
            try {
                System.out.println(textArrayList.get(scanner.nextInt()));
            } catch (Exception e) {
                System.out.println("Введена строка, отсутствующая в файле");
                break;
            }
        }

    }


}
