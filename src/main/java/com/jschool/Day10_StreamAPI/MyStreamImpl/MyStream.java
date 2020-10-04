package com.jschool.Day10_StreamAPI.MyStreamImpl;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 * Напишите свою реализацию класса java.util.stream.Stream, которая позволит выполнить
 * следующий код:
 * Stream<Integer> integerStream = Stream.of(1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 9).filter(i -> i%2 == 0).map(i
 * -> i*i).distinct();
 * integerStream.forEach(System.out::println);
 */
public class MyStream<T> {
    private Collection<T> streamCollection;

    private MyStream(Collection<? extends T> streamList) {
        this.streamCollection = new ArrayList<>(streamList);
    }

    public static <T> MyStream<T> of(T... values) {
        return new MyStream<>(Arrays.asList(values));
    }

    public MyStream<T> filter(Predicate<? super T> predicate) {
        streamCollection.removeIf(t -> !predicate.test(t));
        return this;
    }

    public MyStream<T> map(Function<? super T, ? extends T> function) {
        List<T> tempList = new ArrayList<>();
        for (T t : streamCollection) {
            tempList.add(function.apply(t));
        }

        streamCollection.clear();
        streamCollection.addAll(tempList);
        return this;
    }

    public MyStream<T> distinct() {
        Set<T> tempSet = new HashSet<>(streamCollection);
        streamCollection.clear();
        streamCollection.addAll(tempSet);

        return this;
    }

    public void forEach(Consumer<? super T> action) {
        for (T t : streamCollection) {
            action.accept(t);
        }
    }
}
