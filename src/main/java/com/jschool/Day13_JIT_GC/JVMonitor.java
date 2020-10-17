package com.jschool.Day13_JIT_GC;

import java.util.HashMap;
import java.util.Map;

/**
 * По JIT:
 * Сделать цикл на 100000 итераций, в цикле в предварительно созданную Map<Integer, String>
 * сложить ключ - индекс, значение - "value" + индекс
 * Запустить с опцией -XX:+PrintCompilation, проанализировать информацию в консоли
 * Запустить с опцией -XX:+PrintCompilation -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining,
 * проанализировать информацию в консоли
 *
 * По GC:
 * Из %JAVA_HOME%\bin запустить jvisualvm, установить через пункт меню Tools\Plugins\Available Plugis плагин:
 * Visual GC
 * Запустить приложение создающее много объектов с разными GC,
 * посмотреть в jvisualvm как заполняются объекты в разных областях памяти(heap)
 */

public class JVMonitor {
    public static void main(String[] args) {
        Map<Integer, String> testMap = new HashMap<>();

        for (int i = 0; i <= 100000; i++) {
            testMap.put(i, String.valueOf(i));
        }
    }
}
