package com.jschool.Day4_Exceptions;

public class Messages {
    public static void consoleExceptionPrinter(Throwable throwable) {
        System.out.println(throwable.getMessage());

        //если ошибка одного типа - отразать один текст
        //если ошибка другая - другой тип ответа
        //иначе - ответ по умолчанию
    }

    public static void printConsoleMessage(String message) {
        System.out.println(message);
    }
    public static void printDefaultConsoleErr() {
        System.out.println("Возникла техническая ошибка, просьба обратиться в службу поддержки.");
    }

}
