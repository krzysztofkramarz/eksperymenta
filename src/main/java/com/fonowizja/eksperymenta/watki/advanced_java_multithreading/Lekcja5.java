package com.fonowizja.eksperymenta.watki.advanced_java_multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author krzysztof.kramarz
 */
class Lekcja5 {
    public static void main(String[] args) throws Exception {

         // There is a lot of a overhead in starting new Thread and pool is saving this time
        ExecutorService executorService = Executors.newFixedThreadPool(2);

       for (int i = 0; i < 5; i++) {
            executorService.submit(new Pocessor5(i));
        }

        executorService.shutdown();
        System.out.println("Submitted!");
        //java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTas
        // executorService.submit(new Pocessor5(2));
        executorService.awaitTermination(20L, TimeUnit.MINUTES);
        System.out.println("GOTOWE!");
    }
}

class Pocessor5 implements Runnable {

    private final int id;

    Pocessor5(int id) {
        this.id = id;
    }

    @Override
    public void run() {

        System.out.println("Startujemy.. id= " + id + " . Watek: " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Skonczylem! id= " + id + " . Watek: " + Thread.currentThread().getName());
    }
}
