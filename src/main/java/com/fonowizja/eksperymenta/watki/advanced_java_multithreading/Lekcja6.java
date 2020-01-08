package com.fonowizja.eksperymenta.watki.advanced_java_multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author krzysztof.kramarz
 */
class Lekcja6 {
    //CountDownLatches
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor6(latch));
        }
        executorService.shutdown();
        latch.await();

        System.out.println("GOTOWE..");
    }

}

class Processor6 implements Runnable {
    private final CountDownLatch latch;

    public Processor6(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("watek: " + Thread.currentThread().getName() + ", i latch PRZED = " + latch.getCount());
        latch.countDown();
        System.out.println("watek: " + Thread.currentThread().getName() + ", i latch PO = " + latch.getCount());

        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.getMessage();
        }

    }
}