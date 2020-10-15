package com.jschool.Day12_JMM.Task;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Данный класс в конструкторе принимает экземпляр java.util.concurrent.Callable.
 * Callable похож на Runnuble, но результатом его работы является объект (а не void).
 * <p>
 * Ваша задача реализовать метод get() который возвращает результат работы Callable.
 * Выполнение callable должен начинать тот поток, который первый вызвал метод get().
 * <p>
 * Если несколько потоков одновременно вызывают этот метод, то выполнение должно начаться только в одном потоке,
 * а остальные должны ожидать конца выполнения (не нагружая процессор).
 * Если при вызове get() результат уже просчитан, то он должен вернуться сразу,
 * (даже без задержек на вход в синхронизированную область).
 * <p>
 * Если при просчете результата произошел Exception, то всем потокам при вызове get(), надо кидать этот Exception, обернутый в ваш RuntimeException (подходящее название своему ексепшену придумайте сами).
 */
public class Task<T> {
    private final Callable<? extends T> callable;
    ConcurrentHashMap<Callable<? extends T>, Object> localCache = new ConcurrentHashMap<>();
    ConcurrentHashMap<Callable<? extends T>, Exception> getException = new ConcurrentHashMap<>();

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public synchronized T get() throws Exception {

        if (getException.containsKey(callable)) {
            throw getException.get(callable);
        }

        if (!localCache.containsKey(callable)) {
            synchronized (this) {
                if (!localCache.containsKey(callable)) {
                    try {
                        localCache.put(callable, callable.call());
                    } catch (Exception e) {
                        getException.put(callable, new GetCallableException("Ошибка выполнения потока, при вызове" +
                                "метода get(), класса " + this.getClass().getSimpleName()));
                        throw getException.get(callable);
                    }
                }
            }
        }

        return (T) localCache.get(callable);
    }

}
