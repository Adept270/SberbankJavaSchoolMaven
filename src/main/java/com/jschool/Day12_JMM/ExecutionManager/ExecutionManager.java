package com.jschool.Day12_JMM.ExecutionManager;

public interface ExecutionManager {
    /**
     * принимает массив тасков, это задания которые ExecutionManager должен выполнять параллельно
     * (в вашей реализации пусть будет в своем пуле потоков).
     * После завершения всех тасков должен выполниться callback (ровно 1 раз)
     */
    Context execute(Runnable callback, Runnable... tasks);
}
