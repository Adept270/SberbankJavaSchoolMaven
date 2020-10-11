package com.jschool.Day10_Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ScalableThreadPool implements ThreadPool {
    private final int minJobCount;
    private final int maxJobCount;

    private final Queue<Runnable> tasksQueue = new ConcurrentLinkedQueue<>();
    private final List<Thread> jobs;

    private volatile boolean doWork = false;


    public ScalableThreadPool(int minJobCount, int maxJobCount) {
        this.minJobCount = minJobCount;
        this.maxJobCount = maxJobCount;

        jobs = new ArrayList<>();
        for (int i = 0; i < minJobCount; i++) {
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

        //Проанализируем необходимость увелчиения джобов, после добавления нового задания
        analyzeAddingJob();

        doWork = true;
        synchronized (tasksQueue) {
            tasksQueue.notifyAll();
        }
    }

    private void analyzeAddingJob() {
        if (tasksQueue.size() > jobs.size() && jobs.size() < maxJobCount) {
            Job newJob = new Job();
            jobs.add(newJob);
            newJob.start();
        }
    }

    private void analyzeDecreaseJobs() {
        if (tasksQueue.size() < jobs.size() && tasksQueue.size() > minJobCount) {

            Optional<Thread> first = jobs.parallelStream().filter(job -> !job.isAlive()).findFirst();

            if (first.isPresent()) {
                Thread thread = first.get();
                thread.interrupt();
                jobs.remove(thread);

            }

        }
    }

    private final class Job extends Thread {
        @Override
        public void run() {

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
                analyzeDecreaseJobs();

                if (runnable == null) {
                    synchronized (tasksQueue) {
                        doWork = false;
                        tasksQueue.wait();
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
