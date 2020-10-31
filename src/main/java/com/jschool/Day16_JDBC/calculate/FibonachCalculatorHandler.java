package com.jschool.Day16_JDBC.calculate;

import com.jschool.Day16_JDBC.dao.DBTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Map;

public class FibonachCalculatorHandler implements InvocationHandler {
    private final Object delegate;
    private final Map<Integer, Integer> cache;
    DBTools dbTools = new DBTools();

    public FibonachCalculatorHandler(Object delegate) throws SQLException {
        this.delegate = delegate;
        cache = dbTools.getFromDB();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Integer result;
        Integer intArg = (Integer) args[0];

        if (method.isAnnotationPresent(DBCache.class) && method.getName().equals("getFibonacci")) {

            if (null != (result = cache.get(intArg)))
                return result;
        }

        result = (Integer) method.invoke(delegate, args);
        cache.put(intArg, result);
        dbTools.setIntoDB(cache);

        return result;
    }
}
