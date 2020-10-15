package com.jschool.Day12_JMM.ExecutionManager;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutionManagerImpl implements ExecutionManager {
    private final AtomicInteger completedTaskCount = new AtomicInteger(0);
    private final AtomicInteger failedTaskCount = new AtomicInteger(0);
    private final AtomicInteger interruptedTaskCount = new AtomicInteger(0);
    private final AtomicBoolean isInterrupted = new AtomicBoolean(false);
    private final AtomicInteger allTaskCount = new AtomicInteger();
    private ExecutorService executorService;

    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
        int threadCount = 7;
        executorService = Executors.newFixedThreadPool(threadCount);

        Arrays.stream(tasks).map(task ->
                {
                    return (Runnable) () -> {
                        if (isInterrupted.get()) {
                            interruptedTaskCount.incrementAndGet();
                        } else {
                            try {
                                task.run();
                                completedTaskCount.incrementAndGet();
                            } catch (Exception e) {
                                failedTaskCount.incrementAndGet();
                            }
                        }
                        if (allTaskCount.incrementAndGet() == tasks.length) {
                            callback.run();
                            executorService.shutdown();
                        }
                    };
                }
        ).forEach(executorService::submit);

        return new ContextImpl();
    }

    private class ContextImpl implements Context {
        @Override
        public int getCompletedTaskCount() {
            return completedTaskCount.get();
        }

        @Override
        public int getFailedTaskCount() {
            return failedTaskCount.get();
        }

        @Override
        public int getInterruptedTaskCount() {
            return interruptedTaskCount.get();
        }

        @Override
        public void interrupt() {
            isInterrupted.set(true);

        }

        @Override
        public boolean isFinished() {
            return executorService.isShutdown();
        }
    }
}
