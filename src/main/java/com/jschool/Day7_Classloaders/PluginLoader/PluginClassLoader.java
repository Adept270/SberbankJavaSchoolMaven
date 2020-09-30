package com.jschool.Day7_Classloaders.PluginLoader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Реализация загрузчика классов с измененным порядком загрузки класса: сначала загружает самостоятельно,
 * в случае ошибки - передает загрузку родительскому классу.
 */
public class PluginClassLoader extends URLClassLoader {
    public PluginClassLoader(URL[] urls) {
        super(urls);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> clazz = findLoadedClass(name);

        try {
            if (clazz == null) {
                clazz = findClass(name);
            }
        } catch (ClassNotFoundException e) {
            clazz = super.loadClass(name);
        }
        return super.loadClass(name);
    }
}
