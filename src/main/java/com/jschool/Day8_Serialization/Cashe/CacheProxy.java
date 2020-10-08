package com.jschool.Day8_Serialization.Cashe;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class CacheProxy implements InvocationHandler {
    private Object delegate;
    private Map<Method, Object> cachedResult = new HashMap<>();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.isAnnotationPresent(Cache.class)) {
            //вызвать поиск в кэше
            return null;
        } else
            return method.invoke(delegate);
    }

    private Object inMemoryCache(Method method, Object[] args) {
        //if (cachedResult.containsKey(method))
        return null;
    }

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
