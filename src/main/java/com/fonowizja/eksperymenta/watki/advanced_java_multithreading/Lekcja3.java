package com.fonowizja.eksperymenta.watki.advanced_java_multithreading;

import java.util.Arrays;
import java.util.stream.Stream;

public class Lekcja3 {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        Woker3 woker3 = new Woker3(account);
        Thread thread1 = new Thread(woker3, "thread1");
        Thread thread2 = new Thread(woker3, "thread2");
        long poczatek = System.nanoTime();
        thread1.start();
        thread2.start();
        thread1.join();
        System.out.println(Thread.currentThread().getState());
        thread2.join();
        System.out.println(account.getStan());

        long koniec = System.nanoTime();
        System.out.println("Trwalo to: " + ((koniec - poczatek)));

        //5009083187
        //5016870172
    }
}

class Woker3 implements Runnable {
    final Object lock = new Object();

    public Woker3(Account account) {
        this.account = account;
    }

    Account account;

    @Override
    public void run() {

        // try
        // {
        //    Thread.sleep(200);
        // }
        // catch (InterruptedException e)
        // {
        //    e.printStackTrace();
        // }
        doSmth();
        synchronized (lock) {
            for (int i = 0; i < 10_000; i++) {
                account.incrementStan();
            }
        }
    }

    void doSmth() {
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {

        }
    }
}

class Account {
    //można zastosowac AtomicInteger
    volatile Integer stan = 0;

    void incrementStan() {
        stan++;
    }

    public Integer getStan() {
        return stan;
    }
}
