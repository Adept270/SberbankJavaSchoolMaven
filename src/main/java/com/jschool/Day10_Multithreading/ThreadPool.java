package com.jschool.Day10_Multithreading;

public interface ThreadPool {
    void start();
    void execute(Runnable runnable);
}
