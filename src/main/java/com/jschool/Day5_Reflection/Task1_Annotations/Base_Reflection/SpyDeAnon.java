package com.jschool.Day5_Reflection.Task1_Annotations.Base_Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class SpyDeAnon {

    /**
     * Метод выводит на консоль все методы класса, включая родительские методы (включая приватные).
     *
     * @param clazz - класс, все методы которого будут выведены на консоль
     */
    public static void getAllMethodsRec(Class clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(method.getName());
        }

        Class superclass = clazz.getSuperclass();
        if (superclass != null) {
            getAllMethodsRec(superclass);
        }
    }


    /**
     * Выводит все геттеры класса на консоль.
     *
     * @param clazz - класс, переданный для анализа
     */
    public static void getClassGetters(Class clazz) {

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().startsWith("get") && method.getParameterTypes().length == 0) {
                System.out.println(method.getName());
            }
        }
    }

    //Проверить что все String константы имеют значение = их имени
    //public static final String MONDAY = "MONDAY";

    /**
     * Проверка, что все строковые константы измеют значение их имени.
     * Например: public static final String MONDAY = "MONDAY";
     * @param o - объект, для которого выполняется проверка
     * @return - true, если объект соответствует требованиям
     * @throws IllegalAccessException - предусмотреть обработку ошибки доступа
     */
    public static boolean checkConstantFields(Object o) throws IllegalAccessException {

        //Получим все поля метода
        for (Field field : o.getClass().getDeclaredFields()) {
            int modifiers = field.getModifiers();

            //Выберем только строковые константы
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers) ||
                    field.getType().equals(String.class)) {

                //Сверим соответствие имени поля и его знечения
                if (!field.getName().equals((String) field.get(o))) {
                    return false;
                }

            }
        }
        return true;
    }
}
