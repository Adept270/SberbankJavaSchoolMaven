package com.jschool.Day8_Day14_Serialization.Cashe;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class CacheProxy implements InvocationHandler {
    private final Object delegate;
    private final ConcurrentMap<Integer, Object> cachedResult = new ConcurrentHashMap<>();

    public <T> CacheProxy(T delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IOException, InvocationTargetException, IllegalAccessException {

        Object result = null;
        Cache annotation = method.getAnnotation(Cache.class);

        if (annotation != null) {
            switch (annotation.cacheType()) {
                case FILE:
                    result = fileCache(method, args);
                    break;
                case IN_MEMORY:
                    result = memoryCache(method, args);
                    break;
                default:
                    break;
            }
        } else
            result = method.invoke(delegate);

        return result;
    }


    /**
     * Возвращает результат работы вызванного метода из кеша при кешировании в памяти.
     * При наличии кешированного значения - из кеша. Иначе -
     * в результате вызова метода напрямую. Полученный при этом результат работы - сохраняется в кеше.
     *
     * @param args - параметры вызванного метода
     * @throws - InvocationTargetException
     * @throws - IllegalAccessException
     */
    private Object memoryCache(Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        Integer hashCode = method.hashCode() + Arrays.hashCode(args);
        if (cachedResult.containsKey(hashCode)) {
            return cachedResult.get(hashCode);
        } else {
            Object result = method.invoke(delegate, args);
            cachedResult.put((method.hashCode() + Arrays.hashCode(args)), result);
            return result;
        }
    }

    /**
     * Возвращает результат работы вызванного метода из кеша при кешировании в файл.
     * При наличии кешированного значения - из кеша. Иначе -
     * в результате вызова метода напрямую. Полученный при этом результат работы - сохраняется в кеше.
     *
     * @param method - вызванный метод
     * @param args   - параметры вызванного метода
     * @return - результат работы @param method.
     * @throws - IOException,
     * @throws - InvocationTargetException
     * @throws - IllegalAccessException
     */
    private Object fileCache(Method method, Object[] args) throws IOException, InvocationTargetException, IllegalAccessException {
        Object result;
        Cache annotation = method.getAnnotation(Cache.class);

        File file = File.createTempFile(annotation.fileNamePrefix(), "");

        if (file.createNewFile()) {
            //Если файл создан - получим и сохраним результат
            result = method.invoke(delegate, args);

            if (annotation.zip())
                saveToZIP(result, file);
            else
                saveToFile(result, file);
        } else {
            //Если файл существует - получим хранимое значение
            if (annotation.zip()) {
                result = getFromZIP(file);
            } else {
                result = getFromFile(file);
            }
        }
        return result;
    }

    /**
     * Вспомогательный метод, для сохранения результата работы функции в файл
     *
     * @param obj  - сохраняемый объект
     * @param file - файл-получатель результата работы метода
     */
    private void saveToFile(Object obj, File file) {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(obj);

        } catch (FileNotFoundException e) {
            Printer.printConsole("Файл не найден");
        } catch (IOException e) {
            Printer.printConsole("Ошибка создания поотока сериализации");
        }
    }

    /**
     * Вспомогательный метод, для записи результата работы функции в файл
     *
     * @param file - файл-источник результата работы метода
     * @return - сохраненный результат работы метода
     */
    private Object getFromFile(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return ois.readObject();
        } catch (FileNotFoundException e) {
            Printer.printConsole("Запрошенный файл не найден");
        } catch (ClassNotFoundException e) {
            Printer.printConsole("Не удалось получить запрошенный объект.");
        } catch (IOException e) {
            Printer.printConsole("Ошибка создания потока десиреализации");
        }
        return null;
    }

    /**
     * Вспомогательный метод, для получения результата работы функции из архива
     *
     * @param file - файл-источник
     * @return - сохраненный в файле результат работы метода
     */
    private Object getFromZIP(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             GZIPInputStream zipIs = new GZIPInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(zipIs)) {

            return ois.readObject();

        } catch (FileNotFoundException e) {
            Printer.printConsole("Запрошенный файл не найден");
        } catch (ClassNotFoundException e) {
            Printer.printConsole("Объект не найден.");
        } catch (IOException e) {
            Printer.printConsole("Ошибка создания потока получения данных из архива");
        }
        return null;
    }

    /**
     * Вспомогательный метод, для записи результата работы функции в архив
     *
     * @param obj  - сохраняемый результат
     * @param file - путь к файлу-получателю
     */
    private void saveToZIP(Object obj, File file) {
        try (FileOutputStream fos = new FileOutputStream(file);
             GZIPOutputStream zipOs = new GZIPOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(zipOs)) {

            oos.writeObject(obj);

        } catch (FileNotFoundException e) {
            Printer.printConsole("Файл не найден");
        } catch (IOException e) {
            Printer.printConsole("Ошибка создания поотока сериализации");
        }
    }
}
