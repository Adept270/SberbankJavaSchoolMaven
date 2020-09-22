package com.jschool.Day5_Reflection.Task1_Annotations.Base_Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) throws InvocationTargetException, IllegalAccessException {
        Map<String, Method> allSetters = getAllSetters(to);
        Map<String, Method> allGetters = getAllGetters(from);

        for (Map.Entry<String, Method> entry : allGetters.entrySet()) {
            Method getMethod = entry.getValue();
            getMethod.setAccessible(true);

            if (allSetters.containsKey(getMethod.getName().substring(3))) {
                Method setMethod = allSetters.get(entry.getKey());
                setMethod.setAccessible(true);
                if (isCompareParams(getMethod, setMethod)) {
                    setMethod.invoke(to, getMethod.invoke(from));
                }
            }
        }
    }

    private static Map<String, Method> getAllSetters(Object o) {
        Map<String, Method> allSettersMap = new HashMap<>();
        for (Method method : o.getClass().getDeclaredMethods()) {
            if (method.toString().startsWith("set") && method.getParameterCount() == 1) {
                allSettersMap.put(method.getName().substring(3), method);
            }
        }
        return allSettersMap;
    }

    private static Map<String, Method> getAllGetters(Object o) {
        Map<String, Method> allGettersMap = new HashMap<>();
        for (Method method : o.getClass().getDeclaredMethods()) {
            if (method.getName().startsWith("get") && method.getParameterCount() == 0 &&
                    method.getReturnType() != void.class) {
                allGettersMap.put(method.getName().substring(3), method);
            }
        }
        return allGettersMap;
    }

    private static boolean isCompareParams(Method getter, Method setter) {
        return (getter.getReturnType() == setter.getParameterTypes()[0] &&
                getter.getName().substring(3).equals(setter.getName().substring(3)));
    }
}


