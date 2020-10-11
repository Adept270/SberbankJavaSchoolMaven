package com.jschool.Day10_Multithreading;

import org.junit.Test;

import static org.junit.Assert.*;

public class FixedThreadPoolTest {

    @Test
    public void testMultithreading() {

        Runnable r1 = () -> {
            System.out.println("Start 1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finish 1");

        };

        Runnable r2 = () -> {
            System.out.println("Start 2");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finish 2");
        };

        Runnable r3 = () -> {
            System.out.println("Start 3");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finish 3");

        };

        Runnable r4 = () -> {
            System.out.println("Start 4");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finish 4");

        };

        ThreadPool pool = new FixedThreadPool(4);
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);

        pool.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}