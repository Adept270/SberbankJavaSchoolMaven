package com.jschool.Day10_Multithreading;

public class ScalableThreadPool implements ThreadPool {
    private final int minJobCount;
    private final int maxJobCount;


    public ScalableThreadPool(int minJobCount, int maxJobCount) {
        this.minJobCount = minJobCount;
        this.maxJobCount = maxJobCount;
    }

    @Override
    public void start() {

    }

    @Override
    public void execute(Runnable runnable) {

    }
}
