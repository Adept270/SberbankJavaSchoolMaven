package com.jschool.Day11_Multithreading;

public interface ThreadPool {
    void start();
    void execute(Runnable runnable);
}
