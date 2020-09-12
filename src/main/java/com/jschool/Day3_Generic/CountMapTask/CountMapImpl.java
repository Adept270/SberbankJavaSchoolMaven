package com.jschool.Day3_Generic.CountMapTask;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<K> implements CountMap<K> {

    private Map<K, Integer> map;

    public CountMapImpl() {
        map = new HashMap<>();
    }

    /**
     * Добавляет элемент в конструкторе контейнер
     *
     * @param key - добавляемый объект
     */
    @Override
    public void add(K key) {

        Integer objCount = map.get(key);
        if (objCount != null) {
            map.put(key, ++objCount);

        } else {
            map.put(key, 1);
        }
    }

    /**
     * Возвращает количество добавлений элемента @param в контейнер
     *
     * @param key - объект, искомый в контейнере
     * @return - количество добавлений объекта
     */
    @Override
    public int getCount(K key) {

        Integer result = map.get(key);
        return result != null ? result : 0;
    }

    /**
     * Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
     *
     * @param key - элемент контейнера
     * @return - количество добавлений элемента (до удаления)
     */
    @Override
    public int remove(K key) {

        Integer objCount = map.remove(key);
        return objCount != null ? objCount : 0;
    }

    /**
     * @return - Возвращает количество уникальных элементов котнейнера
     */
    @Override
    public int size() {
        return map.size();
    }

    /**
     * Добавляет все элементы из source в текущий контейнер,
     * при совпадении ключей, суммирует значения
     *
     * @param source - контейнер, для добавления ключей
     */
    @Override
    public void addAll(CountMap<K> source) {
        for (K key : source.toMap().keySet()) {
            map.put(key, map.get(key) + source.getCount(key));
        }
    }

    /**
     * @return - java.util.Map, где  ключ - добавленный элемент, значение - количество его добавлений
     */
    @Override
    public Map<K, Integer> toMap() {
        return map;
    }

    /**
     * Метод выполняет запись в @param
     *
     * @param destination - Map, в которую выполняется запись
     */
    @Override
    public void toMap(Map<K, Integer> destination) {
        destination.putAll(map);

    }
}
