package com.jschool.Day11_Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FixedThreadPool implements ThreadPool {
    private final Queue<Runnable> tasksQueue = new ConcurrentLinkedQueue<>();
    private final List<Thread> jobs;
    private volatile boolean doWork = false;

    public FixedThreadPool(int threadCount) {

        jobs = new ArrayList<>(threadCount);
        for (int i = 0; i <= threadCount; i++) {
            jobs.add(new Job());
        }
    }

    @Override
    public void start() {
        jobs.parallelStream().forEach(Thread::start);
    }

    @Override
    public void execute(Runnable runnable) {
        tasksQueue.add(runnable);
        doWork = true;
        synchronized (tasksQueue) {
            tasksQueue.notifyAll();
        }

    }

    private final class Job extends Thread {
        @Override
        public void run() {

            while (!Thread.currentThread().isInterrupted()) {

                while (!doWork) {
                    synchronized (tasksQueue) {
                        try {
                            tasksQueue.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }

                try {
                    Runnable runnable = tasksQueue.poll();

                    if (runnable == null) {
                        synchronized (tasksQueue) {
                            tasksQueue.wait();
                            doWork = false;
                        }
                    } else {
                        runnable.run();
                    }

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

